/*-----------------------------------

  Company AngularJS module
  
  @author santos dot sandro at gmail dot com
  
 ------------------------------------*/


(function() {
	
	
	// Add module company
	var app = angular.module('company', []);
	
	/*
	 * Company DAO service 
	 */
	
	app.service('companyDao', function($http, $q) {

		// Service API
		return {
			add: addCompany,
			get: getCompany,
			del: deleteCompany,
			list: listCompanies
		};
		
		/*
		 * Business add method
		 */
		function addCompany(data) {
			
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
		function deleteCompany(id) {

			var promisse = $http({
				method: 'delete',
				url: '/rest/company/',
				data : {
					id: id
				}
			});
			
			return promisse.then(handleSuccess, handleError);
			
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

		var localObj = this;

		this.company = {};
		
		/*
		 * Reset the identified user
		 */
		this.reset = function () {

			
			if ($routeParams.id) {
				companyDao.get($routeParams.id).then(
					function (resultJson) {
						localObj.company = resultJson;
					}	
				);
			} else {
				localObj.company = {id: null, version: null};
			}
			
		};
		
		/*
		 * Save this company
		 */
		this.save = function () {
			
			companyDao.add(localObj.company).then(function() {
				// success
				$location.path('/companies');
			}, function(message) {
				// error
				alert(message);
			});
		};

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