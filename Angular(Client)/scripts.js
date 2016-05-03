(function (angular) {
  'use strict';
  var app = angular.module("TaskManagement", ['angularSoap', 'ngRoute']);
  app.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            controller  : 'TaskController'
        })
        .when('/rest', {
            templateUrl : 'pages/rest.html',
            controller  : 'RestController'
        })
        .when('/soap', {
            templateUrl : 'pages/soap.html',
            controller  : 'SoapController'
        })
        .when('/node', {
            templateUrl : 'pages/node.html',
            controller  : 'NodeController'
        })
        .when('/external', {
            templateUrl : 'pages/external.html',
            controller  : 'ExternalController'
        });
    });
    app.controller("TaskController", ['$scope', function($scope) {
		
    }]);

}(angular));