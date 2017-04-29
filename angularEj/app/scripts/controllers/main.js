'use strict';

/**
 * @ngdoc function
 * @name angularEjApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the angularEjApp
 */
angular.module('angularEjApp')
  .controller('MainCtrl', function ($scope, $http, $window) {

  	$scope.login = function(){
  		$http.post('http://localhost:8080/api/login',{
  			username : $scope.username,
  			password : $scope.password
  		}).then(function(response){
  			$scope.autentificado = "adentro";
  			$window.sessionStorage.token = response.data.access_token
  		});
  	};
  	$scope.listado = function(){
  		$http.get('http://localhost:8080/alumnos')
  		.then(function(response){
  			var listado = response.data;
  			$scope.alumnos = listado[0].nombre;
  		});
  	}

  });
