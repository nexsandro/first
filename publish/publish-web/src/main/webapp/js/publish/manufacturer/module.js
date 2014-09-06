/*-----------------------------------

  Manufacturer AngularJS module
  
  @author santos dot sandro at gmail dot com
  
 ------------------------------------*/


(function() {
	
	
	// Add module manufacturer
	var app = angular.module('manufacturer', ['ui.bootstrap']);
	
	/*
	 * Manufacturer DAO service 
	 */
	
	app.service('manufacturerDao', function($http, $q) {

		// Service API
		return {
			add: addManufacturer,
			get: getManufacturer,
			del: deleteManufacturer,
			list: listCompanies,
			search : search
		};

		/*
		 * Business add method
		 */
		function addManufacturer(data) {
			
			var promisse = $http.post('rest/manufacturers', data);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
		}
		
		/*
		 * Business get method
		 */
		function getManufacturer(id) {

			var promisse = $http.get('../control/rest/manufacturer/' + id);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
			
		}
		
		/*
		 * Business delete method
		 */
		function deleteManufacturer(id) {

			var promisse = $http({
				method: 'delete',
				url: '/rest/manufacturer/',
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

			var promisse = $http.get('rest/manufacturers');  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
			
		}

		/*
		 * Search for products with partialName.
		 */
		function search(partialName) {

			var promisse = $http.get('rest/products/name=' + partialName);  // we could add here something like $scope.httpDefaultConfig
			
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
	
	// ManufacturerEditController
	app.controller('ManufacturerEditController', function($scope, $routeParams, $location, manufacturerDao) {

		var localObj = this;

		this.manufacturer = {};
		
		/*
		 * Reset the identified user
		 */
		this.reset = function () {

			
			if ($routeParams.id) {
				manufacturerDao.get($routeParams.id).then(
					function (resultJson) {
						localObj.manufacturer = resultJson;
					}	
				);
			} else {
				localObj.manufacturer = {id: null, version: null};
			}
			
		};
		
		/*
		 * Save this manufacturer
		 */
		this.save = function () {
			
			manufacturerDao.add(localObj.manufacturer).then(function(data) {
				// success
				$location.path('/manufacturers');
			}, function(message) {
				// error
				alert(message);
			});
		};


		/*
		 * Search for products.
		 */
		this.searchProducts = function (partialName) {
			
			return manufacturerDao.search(partialName);
			
		};
		
		/*
		 * Start with the manufacturer
		 */
		this.reset();

	});
	
	// ManufacturerListController
	app.controller('ManufacturerListController', function(manufacturerDao) {

		  // save this in scoped var 
		  var manufacturerStore = this;
		  
		  // List of manufacturers
		  this.manufacturers = [];
		  
		  
		  /**
		   * Edit the manufacturer by it's id
		   */
		  this.edit = function(manufacturerId) {
			  $location.path('/manufacturer/' + manufacturerId);
		  }
		  
		  // Load Companies
		  manufacturerDao.list()
		  	.then(
				function(manufacturerList) {
					manufacturerStore.manufacturers = manufacturerList;
				},
				function(errorMsg) {
					alert(errorMsg);
				}
		  );

	  });

	
})();