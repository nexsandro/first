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
			save: saveBrand,
			get: getBrand,
			del: deleteBrand,
			list: listBrands,
			search : search
		};

		/*
		 * Business add method
		 */
		function saveBrand(data) {
			
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
		function deleteBrand(brandId) {

			return $http.delete('../control/rest/brand/' + brandId);
			
		}
		
		/*
		 * Business list method
		 */
		function listBrands() {

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

		var localContext = this;

		this.brand = {};
		
		/*
		 * Reset the identified user
		 */
		this.reset = function () {
			
			if ($routeParams.id) {
				brandDao.get($routeParams.id).then(
					function (resultJson) {
						localContext.brand = resultJson;
					}	
				);
			} else {
				localContext.brand = {id: null, version: null, name: ''};
			}
			
		};
		
		/*
		 * Save this brand
		 */
		this.save = function () {
			
			brandDao.save(localContext.brand).then(function(data) {
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
	app.controller('BrandListController', function($location, brandDao) {

		  // save this in scoped var 
		  var localContext = this;
		  
		  // List of brands
		  this.brands = [];

		  /*
		   * Reset the list
		   */
		  this.reset = function() {
				
			  // Load Companies
			  brandDao.list()
			  	.then(
					function(brandList) {
						localContext.brands = brandList;
					},
					function(errorMsg) {
						alert(errorMsg);
					}
			  );
		  };
		  
		  /**
		   * Edit the brand by it's id
		   */
		  this.edit = function(brandId) {
			  $location.path('/brand/' + brandId);
		  }

		  /**
		   * Delete brand
		   */
		  this.deleteBrand = function(brandId) {

			  if( confirm('Confirma a exclusão da marca ?') ) {
				
				  brandDao.del(brandId).then(
			          function() {
			        	  localContext.reset();
				      }, 
					  function(response) {
						  alert('Erro excluindo marca. Exclua suas relações antes !');
					  });
			  }
				
		  };

		  this.reset();
		  
	  });

	
})();