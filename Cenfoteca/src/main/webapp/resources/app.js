'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.view1',
  'myApp.view2',
  'myApp.version',
  'ui.grid',
  'angularFileUpload'
])
.config(['$routeProvider','$provide','$httpProvider', function($routeProvider,$provide,$httpProvider) {
	$routeProvider.otherwise({redirectTo: '/view1'});
  
	$provide.factory('responseHttpInterceptor', function($q) {
		  return {
		    response: function(response) {
		      // do something on success
		      return response;
		    },
		    responseError: function(response) {
		      // do something on error
		    	if(response.status === 401){
					window.location.href = "/cenfoteca/#/login";
				}
		      return $q.reject(response);
		    }
		  };
		});
	
	$httpProvider.interceptors.push('responseHttpInterceptor');
	
	//RESPONSE INTERCEPTOR FOR ALL THE JQUERY CALLS: EX:THE JQGRID
	$.ajaxSetup({
	    beforeSend: function() {
	    },
	    complete: function(response) {
	    	if(response.status === 401){
	    		window.location.href = "/cenfoteca/#/login";
			}
	    }
	});
  
}]);
