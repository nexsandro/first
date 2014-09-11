/*-----------------------------------

  MarketSegment AngularJS module
  
  @author santos dot sandro at gmail dot com
  
 ------------------------------------*/


(function() {
	
	
	// Add module marketSegment
	var app = angular.module('marketSegment', ['ui.bootstrap', 'company']);
	
	/*
	 * MarketSegment DAO service 
	 */
	
	app.service('marketSegmentDao', function($http, $q) {

		// Service API
		return {
			addToCompany: addToCompany,
			save: saveMarketSegment,
			get: getMarketSegment,
			remove: removeMarketSegment,
			list: listMarketSegments,
			search: searchMarketSegments
		};

		/*
		 * Business add method
		 */
		function saveMarketSegment(data) {
			
			var promisse = $http.post('rest/marketSegments', data);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
		}
		
		/*
		 * Business get method
		 */
		function getMarketSegment(id) {

			var promisse = $http.get('../control/rest/marketSegment/' + id);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
			
		}
		
		/*
		 * Business delete method
		 */
		function removeMarketSegment(companyId, marketSegmentId) {

			return $http.delete('../control/rest/company/' + companyId + '/marketSegment/' + marketSegmentId);
			
		}
		
		/*
		 * Business add marketSegment to company
		 */
		function addToCompany(company, marketSegment) {

			return $http.post('rest/company/marketSegments', {company: company, marketSegment: marketSegment});
			
		}

		/*
		 * Search for products with partialName.
		 */
		function searchMarketSegments(partialName) {

			var promisse = $http.get('rest/marketsegment/name=' + partialName);  // we could add here something like $scope.httpDefaultConfig

			return promisse.then(handleSuccess, handleError);
			
		}

		
		/*
		 * Business list method
		 */
		function listMarketSegments(companyId) {

			var promisse = $http.get('rest/company/' + companyId + '/marketSegments');  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);

		}
		
		/*
		 * Tool method for error handling
		 */
		function handleError( response ) {
			
			if ( !angular.isObject(response.data) || ! response.data.message ) {
				
				return $q.reject("An unknown error ocurred!");
				
			}

			return $q.reject(response.data.message);
			
		}
		
		/*
		 * Tool method for success handling
		 */
		function handleSuccess(response) {

			return response.data;
			
		}
		
	});
	
	// MarketSegmentEditController
	app.controller('MarketSegmentEditController', function($scope, $routeParams, $location, marketSegmentDao, companyDao) {

		var localContext = this;

		this.marketSegment = {name: ''};
		
		this.company = {name: '', id: $routeParams.companyId};
		
		/*
		 * Save this marketSegment
		 */
		this.save = function () {
			
			marketSegmentDao.save(localContext.marketSegment).then(function(data) {
				// success
				$location.path('/company/' + localContext.marketSegment.company.id + '/marketSegments');
			}, function(message) {
				// error
				alert(message);
			});
		};
		
		/*
		 * Business add marketSegment to company
		 */
		this.addToCompany = function() {

			// Verify if object or string
			if (!localContext.marketSegment.id) {
				localContext.marketSegment = {name: localContext.marketSegment};
			}
			
			// Add relation
			marketSegmentDao.addToCompany(localContext.company, localContext.marketSegment).then(function(data) {
				// success
				$location.path('/company/' + localContext.company.id + '/marketSegments');
			}, function(message) {
				// error
				alert(message);
			});
			
		}

		/*
		 * List for typeahead of Market Segment
		 */
		this.searchMarketSegments = function (partialName) {
			
			return marketSegmentDao.search(partialName);
			
		};

	});
	
	// MarketSegmentListController
	app.controller('MarketSegmentListController', function($routeParams, $location, marketSegmentDao) {

		  // save this in scoped var 
		  var localContext = this;
		  
		  this.company = {id: $routeParams.companyId};
		  
		  // List of marketSegments
		  this.marketSegments = [];
		  
		  
		  /**
		   * Edit the marketSegment by it's id
		   */
		  this.edit = function(marketSegmentId) {
			  $location.path('/marketSegment/' + marketSegmentId);
		  }
		  
		  // Load MarketSegments
		  marketSegmentDao.list($routeParams.companyId)
		  	.then(
				function(marketSegmentList) {
					localContext.marketSegments = marketSegmentList;
				},
				function(errorMsg) {
					alert(errorMsg);
				}
		  );
		
			/**
			 * Delete marketSegment
			 */
			this.removeMarketSegment = function(companyId, marketSegmentId) {
			
				if( confirm('Confirma a remoçao do segmento de mercado ?') ) {
			
					marketSegmentDao.remove(companyId, marketSegmentId).then(
							function() {
								$location.path('#/company/' + companyId + '/marketSegments');
							}, 
							function(error) {
								alert('Erro removendo segmento de mercado!');
							}
					);
				}
				
			};
	  });


	
})();