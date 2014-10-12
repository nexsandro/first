/*-----------------------------------

  Negotiation AngularJS module
  
  @author santos dot sandro at gmail dot com
  
 ------------------------------------*/


(function() {
	
	
	// Add module negotiation
	var app = angular.module('negotiation', ['ui.bootstrap']);
	
	/*
	 * Negotiation DAO service 
	 */
	
	app.service('negotiationDao', function($http, $q) {

		// Service API
		return {
			save: saveNegotiation,
			get: getNegotiation,
			del: deleteNegotiation,
			list: listNegotiations
		};

		/*
		 * Business save or update method
		 */
		function saveNegotiation(data) {

			var promisse = $http.post('rest/negotiations', data);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
		}
		
		/*
		 * Business get method
		 */
		function getNegotiation(id) {

			var promisse = $http.get('../control/rest/negotiation/' + id);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
			
		}
		
		
		/*
		 * Business delete method
		 */
		function deleteNegotiation(negotiationId) {

			return $http.delete('../control/rest/negotiation/' + negotiationId);
			
		}
		
		/*
		 * Business list method
		 */
		function listNegotiations(companyId) {

			var promisse = $http.get('rest/company/' + companyId + '/negotiations');  // we could add here something like $scope.httpDefaultConfig
			
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
	
	// NegotiationEditController
	app.controller('NegotiationEditController', function($scope, $routeParams, $location, negotiationDao) {

		var localContext = this;

		this.negotiation = {};
		
		/*
		 * Reset the identified user
		 */
		this.reset = function () {

			
			if ($routeParams.id) {
				negotiationDao.get($routeParams.id).then(
					function (resultJson) {
						localContext.negotiation = resultJson;
					}	
				);
			} else {
				localContext.negotiation = {id: null, version: null};
			}
			
		};
		
		/*
		 * Save this negotiation
		 */
		this.save = function () {
			
			negotiationDao.save(localContext.negotiation).then(function(data) {
				// success
				$location.path('/negotiations');
			}, function(message) {
				// error
				alert(message);
			});
		};

		
		/*
		 * Editar produtos negociados
		 */
		this.editNegotiation = function() {

			$location.path('/negotiation/' + localContext.negotiation.id + '/negotiations');
			
		}

		/**
		 * Delete negotiation
		 */
		this.deleteNegotiation = function() {

			if( confirm('Confirma a exclusão da negociação ?') ) {

				negotiationDao.del(localContext.negotiation.id).then(
						function() {
							$location.path('/negotiations');
						}, 
						function(response) {
							alert('Erro excluindo companhia. Exclua suas relações antes !');
						}
				);
			}
			
		};
		
		/*
		 * Start with the negotiation
		 */
		this.reset();

	});
	
	// NegotiationListController
	app.controller('NegotiationListController', function(negotiationDao, $routeParams) {

		  // save this in scoped var 
		  var localContext = this;
		  
		  // List of negotiations
		  this.negotiations = [];

		  // Company
		  this.company = {id: $routeParams.companyId};
		  
		  /**
		   * Edit the negotiation by it's id
		   */
		  this.edit = function(negotiationId) {
			  $location.path('/negotiation/' + negotiationId);
		  }
		  
		  // Load Negotiations
		  negotiationDao.list($routeParams.companyId)
		  	.then(
				function(negotiationList) {
					localContext.negotiations = negotiationList;
				},
				function(errorMsg) {
					alert(errorMsg);
				}
		  );

	  });

	
})();