<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="myApp" class="no-js"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Proyecto 3 | To Do List</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/bower_components/html5-boilerplate/dist/css/normalize.css">
  <link rel="stylesheet" href="resources/bower_components/html5-boilerplate/dist/css/main.css">
  <link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/appLogin.css">
  <script src="resources/bower_components/html5-boilerplate/dist/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
  <!--[if lt IE 7]>
      <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
  <![endif]-->

  <div ng-view></div>
  
  <!-- In production use:
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
  -->
  <script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
  <script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
  <script src="resources/bower_components/angular/angular.js"></script>
  <script src="resources/bower_components/angular-route/angular-route.js"></script>
  <script src="resources/appLogin.js"></script>
  <script src="resources/loginView/loginView.js"></script>
</body>
</html>
