'use strict';

angular.module('myApp.view3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view3', {
    templateUrl: 'resources/view3/view3.html',
    controller: 'View3Ctrl'
  });
}])

.controller('View3Ctrl', ['$scope','$http',function($scope,$http) {
	$scope.tipoUsuarioList = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0,"direction": "","sortBy": [""],"searchColumn": "string","searchTerm": "","tipoUsuario": {}};
	$http.post('rest/protected/tipoUsuario/getAll',$scope.requestObject).success(function(response) {
		console.log("response",response)
		$scope.tipoUsuarioList = response.tipoUsuarioList;
		console.log("$scope.tipoUsuarioList",$scope.tipoUsuarioList)
		
	});
	
}]);