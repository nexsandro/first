
/**
 * Publish AngularJS Project 
 * 
 * Main module.
 * 
 * @author sebastiao dot santos at gmail dot com
 */

(function() {
	
  var app = angular.module('publish', ['ngRoute', 'company', 'product', 'brand', 'contact', 'manufacturer', 'marketSegment']);
  
	
  /*
   * Config routes
   */
  app.config(['$routeProvider', function($routeProvider) {
		
	/*
	 * Home navigation rules.
	 */
  	$routeProvider.when(
  			
  			'/companies',
  			{ templateUrl: '../company/list.html', controller: 'CompanyListController', controllerAs: 'companyListCtrl' }
  			
  	).
  	when(
  			
  			'/company/:id',
  			{ templateUrl: '../company/edit.html' }
  			
  	).
  	when(
  			
  			'/company',
  			{ templateUrl: '../company/edit.html' }
  			
  	).when(
  			
  			'/products',
  			{ templateUrl: '../product/list.html', controller: 'ProductListController', controllerAs: 'productListCtrl' }
  			
  	).
  	when(
  			
  			'/product/:id',
  			{ templateUrl: '../product/edit.html' }
  			
  	).
  	when(
  			
  			'/product',
  			{ templateUrl: '../product/edit.html' }
  			
  	).when(
  			
  			'/brands',
  			{ templateUrl: '../brand/list.html', controller: 'BrandListController', controllerAs: 'brandListCtrl' }
  			
  	).
  	when(
  			
  			'/brand/:id',
  			{ templateUrl: '../brand/edit.html' }
  			
  	).
  	when(
  			
  			'/brand',
  			{ templateUrl: '../brand/edit.html' }
  			
  	).when(
  			
  			'/manufacturers',
  			{ templateUrl: '../manufacturer/list.html', controller: 'ManufacturerListController', controllerAs: 'manufacturerListCtrl' }
  			
  	).
  	when(
  			
  			'/manufacturer/:id',
  			{ templateUrl: '../manufacturer/edit.html' }
  			
  	).
  	when(
  			
  			'/manufacturer',
  			{ templateUrl: '../manufacturer/edit.html' }
  			
  	).when(
  	
  			'/company/:companyId/contacts',
  			{ templateUrl: '../contact/list.html', controller: 'ContactListController', controllerAs: 'contactListCtrl' }
  			
  	).
  	when(
  			
  			'/company/:companyId/contact/:contactId',
  			{ templateUrl: '../contact/edit.html' }
  			
  	).
  	when(
  			
  			'/company/:companyId/contact',
  			{ templateUrl: '../contact/edit.html' }
  			
  	).when(
  	
  			'/company/:companyId/marketSegments',
  			{ templateUrl: '../marketsegment/list.html', controller: 'MarketSegmentListController', controllerAs: 'marketSegmentListCtrl' }
  			
  	).
  	when(
  			
  			'/company/:companyId/marketSegment/:marketSegmentId',
  			{ templateUrl: '../marketsegment/edit.html' }
  			
  	).
  	when(
  			
  			'/company/:companyId/marketSegment',
  			{ templateUrl: '../marketsegment/edit.html' }
  			
  	); // $routeProvider.when
		
  }]);

  
  /**
   * Create a diretive to make from button a back button.
   */
  app.directive('jlBack', ['$window', function($window) {
      return {
          restrict: 'A',
          link: function (scope, elem, attrs) {
              elem.bind('click', function () {
                  $window.history.back();
              });
          }
      };
  }]);
  
  
})();
