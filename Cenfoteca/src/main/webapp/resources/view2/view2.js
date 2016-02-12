'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'resources/view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', ['$scope', '$http','$location','$upload',function($scope, $http,$location,$upload) {
	
	$scope.rent={};
	$scope.files = {};
	$scope.onError = false;
	$scope.tipoAlquilerList = [];
	$scope.requestObject = {};
	$scope.gridOptions = {};
	
	 $scope.gridOptions.columnDefs = [
	                                  { name: 'name', displayName: 'Nombre',enableCellEdit: true},
	                                  { name: 'description', displayName: 'Descripcion'},
	                                  { name: ' ',
	                                      cellTemplate:'<button class="btn btn-danger" ng-click="grid.appScope.deleteRent(row.entity.idAlquiler)">Elimina'+
	                                    	  '</button>&nbsp;&nbsp;&nbsp;<button class="btn btn-info" ng-click="grid.appScope.modifyRent(row.entity,row.entity.name,row.entity.description,row.entity.image)">Modificar</button>' },
	                                ];
	
	 $http.post('rest/protected/rent/getAll',$scope.requestObject).success(function(response) {
			console.log("response",response)
			$scope.alquilerList = response.alquilerList;
			console.log("$scope.alquilerList",$scope.alquilerList)
			$scope.gridOptions.data = $scope.alquilerList;
			$scope.btnCreateModify = "Create";
		});
	
	
    $scope.init = function() {
    	
    	$http.get('rest/protected/tipoAlquiler/getAll')
		.success(function(response) {

			$scope.tipoAlquilerList = response.tipoAlquilerList;
			$scope.requestObject.idTipoAlquiler = $scope.tipoAlquilerList[0].idTipoAlquiler;
			
		});
    	
    };
    
    $scope.init();
    
    $scope.onFileSelect = function($files) {
    	$scope.files = $files;
    };
    
    $scope.saveRent = function(event){
    	
    	if(this.createRentForm.$valid){
    		$scope.onError = false;
    		
    		//$files: an array of files selected, each file has name, size, and type.
    		for ( var i = 0; i < $scope.files.length; i++) {
    			var file = $scope.files[i];
    			$scope.upload = $upload.upload({
    				url : 'rest/protected/rent/create',
    				data : {
    					idTipoAlquiler:$scope.requestObject.idTipoAlquiler,
    					name:$scope.requestObject.name,
    					description:$scope.requestObject.description,
    				},
    				file : file,
    			}).progress(
					function(evt) {
						console.log('percent: '+ parseInt(100.0 * evt.loaded / evt.total));
					}).success(function(data, status, headers, config) {
						console.log(data);
						$scope.gridOptions.data.push(data.alquilerList[0]);
						$scope.requestObject.name="";
						$scope.requestObject.description="";
						$("#fileButton").replaceWith("<input id='fileButton' type='file' name='inputfile' required ng-file-select='onFileSelect($files)'>").html();
					});
	    			
    		}
    	}else{
    		$scope.onError = true;
    	}
    };
    
    $scope.deleteRent = function(id ){
		console.log(id);
		  var data = $.param({
            id: id,
        });
		 console.log(data);
		$http["delete"]('rest/protected/rent/delete?'+data)
      .success(function (data, status, headers) {
      	$scope.gridOptions.data = _.without($scope.gridOptions.data,_.findWhere($scope.gridOptions.data,{idAlquiler:id}));
      	console.log($scope.gridOptions.data)
      });
			
	};
	$scope.modifyRent = function(idTipoAlquiler,name,description,image){
		console.log(idTipoAlquiler);
		$scope.requestObject.idTipoAlquiler =idTipoAlquiler;
		$scope.btnCreateModify = "Modify"
//		var data ={};
//		
//		data = {
//			       nombretipo : nombre,
//			       idtipo : id
//		};
//		
//		$http.post('rest/protected/rent/create', data)
//	    .success(function(data, status, config) {
//	        $scope.message = data;
//	      }).error(function(data, status, config) {
//	        alert( "failure message: " + JSON.stringify({data: data}));
//	      });  
	};
    
}]);