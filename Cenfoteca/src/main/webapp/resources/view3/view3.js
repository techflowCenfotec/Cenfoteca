'use strict';

angular.module('myApp.view3', ['ngRoute','ui.grid', 'ui.grid.edit', 'ui.grid.rowEdit', 'ui.grid.cellNav'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view3', {
    templateUrl: 'resources/view3/view3.html',
    controller: 'View3Ctrl'
  });
}])
//Investigar el $q y el $interval ademas el ui-grid edit row edit y cellNav
.controller('View3Ctrl', ['$scope','$http','$q','$interval',function($scope,$http,$q,$interval) {
	
	$scope.onError = false;
	$scope.requestObject = {};
	$scope.tipoUsuarioList = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0,"direction": "","sortBy": [""],"searchColumn": "string","searchTerm": "","tipoUsuario": {}};
	$scope.gridOptions = {enableCellEdit: false,
		    enableCellEditOnFocus: true
		    };
									//El nombre se define por los atributos del objeto que se encuentra en la lista del tipo
	 $scope.gridOptions.columnDefs = [
	                                  { name: 'nombretipo', displayName: 'Nombre',enableCellEdit: true},
	                                  { name: 'idtipo', displayName: 'Id'},
	                                  { name: ' ',
	                                      cellTemplate:'<button class="btn btn-danger" ng-click="grid.appScope.deleteTipoUsuario(row.entity.idtipo)">Eliminar</button>&nbsp;&nbsp;&nbsp;<button class="btn btn-info" ng-click="grid.appScope.modifyTipoUsuario(row.entity.idtipo,row.entity.nombretipo)">Modificar</button>' },
	                                ];
	
	$http.post('rest/protected/tipoUsuario/getAll',$scope.requestObject).success(function(response) {
		console.log("response",response)
		$scope.tipoUsuarioList = response.tipoUsuarioList;
		console.log("$scope.tipoUsuarioList",$scope.tipoUsuarioList)
		$scope.gridOptions.data = $scope.tipoUsuarioList;
		
	});
	$scope.saveTipoUsuario = function(event){
	    
	     $http.post('rest/protected/tipoUsuario/create', {nombretipo : $scope.requestObject.tipo})
	     .success(function(data, status, config) {
	            $scope.message = data;
	            $scope.gridOptions.data.push(data.tipoUsuarioList[0]);
	          }).error(function(data, status, config) {
	            alert( "failure message: " + JSON.stringify({data: data}));
	          }); 
	    };
	    
	$scope.deleteTipoUsuario = function(id ){
		
		  var data = $.param({
              id: id,
          });
		 console.log(data);
		$http["delete"]('rest/protected/tipoUsuario/delete?'+data)
        .success(function (data, status, headers) {
            //$scope.ServerResponse = data;
        	$scope.gridOptions.data = _.without($scope.gridOptions.data,_.findWhere($scope.gridOptions.data,{idtipo:id}));
        	console.log($scope.gridOptions.data)
        });
			
	};
	
	
	$scope.modifyTipoUsuario = function(id,nombre){
		var data ={};
		
		data = {
			       nombretipo : nombre,
			       idtipo : id
		};
		
		$http.post('rest/protected/tipoUsuario/create', data)
	    .success(function(data, status, config) {
	        $scope.message = data;
	      }).error(function(data, status, config) {
	        alert( "failure message: " + JSON.stringify({data: data}));
	      });  
	};
	
	
	
	$scope.saveRow = function( rowEntity ) {
		    // create a fake promise - normally you'd use the promise returned by $http or $resource
		var promise = $q.defer();
		$scope.gridApi.rowEdit.setSavePromise( rowEntity, promise.promise );
		 
		    // fake a delay of 3 seconds whilst the save occurs, return error if gender is "male"
		$interval( function() {
		    if (rowEntity.gender === 'male' ){
		      promise.reject();
		    } else {
		      promise.resolve();
		    }
		    }, 3000, 1);
		  };
	
	$scope.gridOptions.onRegisterApi = function(gridApi){
		    //set gridApi on scope
		    $scope.gridApi = gridApi;
		    gridApi.rowEdit.on.saveRow($scope, $scope.saveRow);
		  };
	
	
}]);