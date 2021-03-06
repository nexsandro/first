/*-----------------------------------

  Product AngularJS module
  
  @author santos dot sandro at gmail dot com
  
 ------------------------------------*/


(function() {
	
	
	// Add module product
	var app = angular.module('product', ['ui.bootstrap']);
	
	/*
	 * Product DAO service 
	 */
	
	app.service('productDao', function($http, $q) {

		// Service API
		return {
			save: saveProduct,
			get: getProduct,
			del: deleteProduct,
			list: listProducts,
			search : search
		};

		/*
		 * Business add method
		 */
		function saveProduct(data) {
			
			var promisse = $http.post('rest/products', data);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
		}
		
		/*
		 * Business get method
		 */
		function getProduct(id) {

			var promisse = $http.get('../control/rest/product/' + id);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
			
		}

		  /**
		   * Delete product
		   */
		 function deleteProduct(productId) {

				return $http.delete('../control/rest/product/' + productId);
				
		  };
		  
		
		/*
		 * Business list method
		 */
		function listProducts() {

			var promisse = $http.get('rest/products');  // we could add here something like $scope.httpDefaultConfig
			
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
	
	// ProductEditController
	app.controller('ProductEditController', function($scope, $routeParams, $location, productDao) {

		var localObj = this;

		this.product = {};
		
		/*
		 * Reset the identified user
		 */
		this.reset = function () {

			
			if ($routeParams.id) {
				productDao.get($routeParams.id).then(
					function (resultJson) {
						localObj.product = resultJson;
					}	
				);
			} else {
				localObj.product = {id: null, version: null};
			}
			
		};
		
		/*
		 * Save this product
		 */
		this.save = function () {
			
			productDao.save(localObj.product).then(function(data) {
				// success
				$location.path('/products');
			}, function(message) {
				// error
				alert(message);
			});
		};


		/*
		 * Search for products.
		 */
		this.searchProducts = function (partialName) {
			
			return productDao.search(partialName);
			
		};
		
		/*
		 * Start with the product
		 */
		this.reset();

	});
	
	// ProductListController
	app.controller('ProductListController', function(productDao) {

		  // save this in scoped var 
		  var localContext = this;
		  
		  // List of products
		  this.products = [];
		  
		  /*
		   * Reset 
		   */
		  this.reset = function() {
			  // Load Products
			  productDao.list()
			  	.then(
					function(productList) {
						localContext.products = productList;
					},
					function(errorMsg) {
						alert(errorMsg);
					}
			  );
			  
		  };
		  
		  /**
		   * Edit the product by it's id
		   */
		  this.edit = function(productId) {
			  $location.path('/product/' + productId);
		  }

		  /**
		   * Delete product
		   */
		  this.deleteProduct = function(productId) {

			  if( confirm('Confirma a exclusão do produto ?') ) {
				
				  productDao.del(productId).then(
			          function() {
			        	  localContext.reset();
				      }, 
					  function(response) {
						  alert('Erro excluindo produto. Exclua suas relações antes !');
					  });
			  }
				
		  };

		  this.reset();
	  });

	
})();