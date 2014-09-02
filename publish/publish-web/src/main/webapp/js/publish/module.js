
/**
 * Publish AngularJS Project 
 * 
 * Main module.
 * 
 * @author sebastiao dot santos at gmail dot com
 */

(function() {
	
  var app = angular.module('publish', ['ngRoute', 'ngAnimate', 'company']);
  
	
  /*
   * Config routes
   */
  app.config(['$routeProvider', function($routeProvider) {
		  
	/*
	 * Home navigation rules.
	 */
  	$routeProvider.when(
  			
  			'/companies',
  			{
  				templateUrl: '../company/list.html',
  					
  				controller: 'CompanyListController',
  				
  				controllerAs: 'companyListCtrl'
  			}
  			
  	).
  	when(
  			'/company/:id',
  			{
  				templateUrl: '../company/edit.html'
  			}
  	).
  	when(
  			'/company',
  			{
  				templateUrl: '../company/edit.html'
  			}
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
