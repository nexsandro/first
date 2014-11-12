/*-----------------------------------

  Company AngularJS module
  
  @author santos dot sandro at gmail dot com
  
 ------------------------------------*/


(function() {
	
	
	// Add module company
	var app = angular.module('company', ['ui.bootstrap']);
	
	/*
	 * Company DAO service 
	 */
	
	app.service('companyDao', function($http, $q) {

		// Service API
		return {
			save: saveCompany,
			get: getCompany,
			del: deleteCompany,
			list: listCompanies
		};

		/*
		 * Business save or update method
		 */
		function saveCompany(data) {

			var promisse = $http.post('rest/companies', data);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
		}
		
		/*
		 * Business get method
		 */
		function getCompany(id) {

			var promisse = $http.get('../control/rest/company/' + id);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
			
		}
		
		
		/*
		 * Business delete method
		 */
		function deleteCompany(companyId) {

			return $http.delete('../control/rest/company/' + companyId);
			
		}
		
		/*
		 * Business list method
		 */
		function listCompanies() {

			var promisse = $http.get('rest/companies');  // we could add here something like $scope.httpDefaultConfig
			
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
	
	// CompanyEditController
	app.controller('CompanyEditController', function($scope, $routeParams, $location, companyDao) {

		var localContext = this;

		this.company = {};
		
		this.editMarketSegment = {name: ''};
		
		/*
		 * Reset the identified user
		 */
		this.reset = function () {

			
			if ($routeParams.id) {
				companyDao.get($routeParams.id).then(
					function (resultJson) {
						localContext.company = resultJson;
					}	
				);
			} else {
				localContext.company = {id: null, version: null};
			}
			
		};
		
		/*
		 * Save this company
		 */
		this.save = function () {
			
			companyDao.save(localContext.company).then(function(data) {
				// success
				$location.path('/companies');
			}, function(message) {
				// error
				alert(message);
			});
		};
		
		/*
		 * Editar contatos
		 */
		this.editContacts = function() {
			
			$location.path('/company/' + localContext.company.id + '/contacts');

		}
		
		/*
		 * Editar segmentos de mercado
		 */
		this.editMarketSegments = function() {

			$location.path('/company/' + localContext.company.id + '/marketSegments');
			
		}
		
		/*
		 * Editar produtos negociados
		 */
		this.editNegotiations = function() {

			$location.path('/company/' + localContext.company.id + '/negotiations');
			
		}

		/**
		 * Delete company
		 */
		this.deleteCompany = function() {

			if( confirm('Confirma a exclusão da empresa ?') ) {

				companyDao.del(localContext.company.id).then(
						function() {
							$location.path('/companies');
						}, 
						function(response) {
							alert('Erro excluindo companhia. Exclua suas relações antes !');
						}
				);
			}
			
		};
		
		/*
		 * Add marketSegment to the list of market segments of the company
		 */
		this.addMarketSegment = function (marketSegment) {
			
			if (!localContext.company.marketSegments) localContext.company.marketSegments = [];
			
			var marketObj = marketSegment; 
			if (!marketSegment.id) {
				marketObj = {name: marketSegment};
			}
			
			localContext.company.marketSegments.push(marketObj);
		}
		
		/*
		 * Start with the company
		 */
		this.reset();

	});
	
	// CompanyListController
	app.controller('CompanyListController', function(companyDao) {

		  // save this in scoped var 
		  var companyStore = this;
		  
		  // List of companies
		  this.companies = [];
		  
		  
		  /**
		   * Edit the company by it's id
		   */
		  this.edit = function(companyId) {
			  $location.path('/company/' + companyId);
		  }
		  
		  // Load Companies
		  companyDao.list()
		  	.then(
				function(companyList) {
					companyStore.companies = companyList;
				},
				function(errorMsg) {
					alert(errorMsg);
				}
		  );

	  });

	
})();