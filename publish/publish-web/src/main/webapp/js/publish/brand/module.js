/*-----------------------------------

  Brand AngularJS module
  
  @author santos dot sandro at gmail dot com
  
 ------------------------------------*/


(function() {
	
	
	// Add module brand
	var app = angular.module('brand', ['ui.bootstrap']);
	
	/*
	 * Brand DAO service 
	 */
	
	app.service('brandDao', function($http, $q) {

		// Service API
		return {
			add: addBrand,
			get: getBrand,
			del: deleteBrand,
			list: listCompanies,
			search : search
		};

		/*
		 * Business add method
		 */
		function addBrand(data) {
			
			var promisse = $http.post('rest/brands', data);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
		}
		
		/*
		 * Business get method
		 */
		function getBrand(id) {

			var promisse = $http.get('../control/rest/brand/' + id);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
			
		}
		
		/*
		 * Business delete method
		 */
		function deleteBrand(id) {

			var promisse = $http({
				method: 'delete',
				url: '/rest/brand/',
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

			var promisse = $http.get('rest/brands');  // we could add here something like $scope.httpDefaultConfig
			
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
	
	// BrandEditController
	app.controller('BrandEditController', function($scope, $routeParams, $location, brandDao) {

		var localObj = this;

		this.brand = {};
		
		/*
		 * Reset the identified user
		 */
		this.reset = function () {

			
			if ($routeParams.id) {
				brandDao.get($routeParams.id).then(
					function (resultJson) {
						localObj.brand = resultJson;
					}	
				);
			} else {
				localObj.brand = {id: null, version: null};
			}
			
		};
		
		/*
		 * Save this brand
		 */
		this.save = function () {
			
			brandDao.add(localObj.brand).then(function(data) {
				// success
				$location.path('/brands');
			}, function(message) {
				// error
				alert(message);
			});
		};


		/*
		 * Search for products.
		 */
		this.searchProducts = function (partialName) {
			
			return brandDao.search(partialName);
			
		};
		
		/*
		 * Start with the brand
		 */
		this.reset();

	});
	
	// BrandListController
	app.controller('BrandListController', function(brandDao) {

		  // save this in scoped var 
		  var brandStore = this;
		  
		  // List of brands
		  this.brands = [];
		  
		  
		  /**
		   * Edit the brand by it's id
		   */
		  this.edit = function(brandId) {
			  $location.path('/brand/' + brandId);
		  }
		  
		  // Load Companies
		  brandDao.list()
		  	.then(
				function(brandList) {
					brandStore.brands = brandList;
				},
				function(errorMsg) {
					alert(errorMsg);
				}
		  );

	  });

	
})();