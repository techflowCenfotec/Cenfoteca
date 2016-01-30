'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'resources/view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl', ['$scope','$http',function($scope,$http) {
	$scope.usuarios = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0,"direction": "","sortBy": [""],"searchColumn": "string","searchTerm": "","user": {}};
	$http.post('rest/protected/users/getAll',$scope.requestObject).success(function(response) {
		console.log("response",response)
		$scope.usuarios = response.usuarios;
		console.log("$scope.usuarios",$scope.usuarios)
		
	});
	
}]);