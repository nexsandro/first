/*-----------------------------------

  Contact AngularJS module
  
  @author santos dot sandro at gmail dot com
  
 ------------------------------------*/


(function() {
	
	
	// Add module contact
	var app = angular.module('contact', ['ui.bootstrap']);
	
	/*
	 * Contact DAO service 
	 */
	
	app.service('contactDao', function($http, $q) {

		// Service API
		return {
			save: saveContact,
			get: getContact,
			del: deleteContact,
			list: listContacts
		};

		/*
		 * Business add method
		 */
		function saveContact(data) {
			
			var promisse = $http.post('rest/contacts', data);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
		}
		
		/*
		 * Business get method
		 */
		function getContact(id) {

			var promisse = $http.get('../control/rest/contact/' + id);  // we could add here something like $scope.httpDefaultConfig
			
			return promisse.then(handleSuccess, handleError);
			
		}
		
		/*
		 * Business delete method
		 */
		function deleteContact(companyId, contactId) {

			return $http.delete('../control/rest/contact/' + contactId);
			
		}
		
		/*
		 * Business list method
		 */
		function listContacts(companyId) {

			var promisse = $http.get('rest/company/' + companyId + '/contacts');  // we could add here something like $scope.httpDefaultConfig
			
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
	
	// ContactEditController
	app.controller('ContactEditController', function($scope, $routeParams, $location, contactDao) {

		var localContext = this;

		this.contact = {};
		
		/*
		 * Reset the identified user
		 */
		this.reset = function () {

			
			if ($routeParams.contactId) {
				contactDao.get($routeParams.contactId).then(
					function (resultJson) {
						localContext.contact = resultJson;
					}	
				);
			} else {
				localContext.contact = {id: null, version: null, company: {id: $routeParams.companyId}};
			}
			
		};
		
		/*
		 * Save this contact
		 */
		this.save = function () {
			
			contactDao.save(localContext.contact).then(function(data) {
				// success
				$location.path('/company/' + localContext.contact.company.id + '/contacts');
			}, function(message) {
				// error
				alert(message);
			});
		};

		/**
		 * Delete contact
		 */
		this.deleteContact = function() {

			if( confirm('Confirma a exclusão do contato ?') ) {

				contactDao.del(localContext.contact.company.id, localContext.contact.id).then(
						function() {
							$location.path('/company/' + localContext.contact.company.id + '/contacts');
						}, 
						function(error) {
							alert('Erro excluindo contato. Exclua suas relações antes !');
						}
				);
			}
			
		};
		
		/*
		 * Search for products.
		 */
		this.searchProducts = function (partialName) {
			
			return contactDao.search(partialName);
			
		};
		
		/*
		 * Start with the contact
		 */
		this.reset();

	});
	
	// ContactListController
	app.controller('ContactListController', function($routeParams, contactDao) {

		  // save this in scoped var 
		  var contactStore = this;
		  
		  this.company = {id: $routeParams.companyId};
		  
		  // List of contacts
		  this.contacts = [];
		  
		  
		  /**
		   * Edit the contact by it's id
		   */
		  this.edit = function(contactId) {
			  $location.path('/contact/' + contactId);
		  }
		  
		  // Load Contacts
		  contactDao.list($routeParams.companyId)
		  	.then(
				function(contactList) {
					contactStore.contacts = contactList;
				},
				function(errorMsg) {
					alert(errorMsg);
				}
		  );

	  });

	
})();