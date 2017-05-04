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

  	if($window.sessionStorage.token){
  		$scope.logeado= true;
  	}else{
  		$scope.logeado=false;
  	}

  	$scope.login = function(){
  		$http.post('http://localhost:8080/api/login',{
  			username : $scope.username,
  			password : $scope.password
  		}).then(function(response){
  			$scope.autentificado = "adentro";
  			$scope.logeado= true;
  			$window.sessionStorage.token = response.data.access_token
  		});
  	};
  	$scope.listado = function(){
  		$http.get('http://localhost:8080/alumnos')
  		.then(function(response){
  			var listado = response.data;
  			$scope.alumnos = listado;
  		});
  	}

  	$scope.insertarAlumno = function(){
  		var alumnoInsertar = {
  			"nombre": $scope.nombre,
  			"apellidos": $scope.apellidos,
  			"matricula": $scope.matricula,
  			"email" : $scope.email,
  			"enabled": false,
  			"edad" : $scope.edad
  		}
  		$http.post('http://localhost:8080/alumnos', alumnoInsertar)
  		.then(function(response){
  			var respuesta = response.data;
  			$scope.resultadoInsercion =  respuesta;
  		});
  	}

  });
