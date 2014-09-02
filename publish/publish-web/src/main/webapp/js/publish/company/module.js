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
			
			alert('Posting ' + JSON.stringify(data));
			var promisse = $http.post('../companies', data);  // we could add here something like $scope.httpDefaultConfig
			
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
	app.controller('CompanyEditController', ['$scope', '$routeParams', 'companyDao', function($scope, $routeParams, companyDao) {

		$scope.company = {};
		
		test =  function () {
				alert('Here');
				return 'Tested';
		};
		
		/*
		 * Reset the identified user
		 */
		reset = function () {
			
			if ($routeParams.id) {
				companyDao.get($routeParams.id).then(
					function (resultJson) {
						$scope.company = resultJson;
					}	
				);
			} else {
				$scope.company = {id: null, version: null};
			}
			
		};
		
		/*
		 * Save this company
		 */
		save = function () {
			companyDao.add($scope.company).then(function() {
				// success
				$location.path('/company/list');
			}, function(message) {
				// error
				alert(message);
			});
		};

		/*
		 * Start with the company
		 */
		reset();

	}]);
	
	// CompanyListController
	app.controller('CompanyListController', function(companyDao) {

		  // save this in scoped var 
		  var companyStore = this;
		  
		  // List of companies
		  this.companies = [];
		  
		  test = function () {
			  alert('x');
		  };
		  
		  
		  /**
		   * Edit the company by it's id
		   */
		  edit = function(companyId) {
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