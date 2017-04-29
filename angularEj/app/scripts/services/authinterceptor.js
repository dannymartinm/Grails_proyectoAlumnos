'use strict';

/**
 * @ngdoc service
 * @name angularEjApp.authInterceptor
 * @description
 * # authInterceptor
 * Factory in the angularEjApp.
 */
 //para crear este archivo -> yo angular:factory authInterceptor
angular.module('angularEjApp')
  .factory('authInterceptor', function ($rootScope, $window) {
    return{
      request: function(config){
        config.headers = config.headers || {};
        if($window.sessionStorage.token){
          config.headers.Authorization = "Bearer "+$window.sessionStorage.token;
        }
        return config;
      }
    };
  }).config(function($httpProvider){
    $httpProvider.interceptors.push('authInterceptor')
  });
