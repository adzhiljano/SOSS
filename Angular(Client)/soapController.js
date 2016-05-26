(function (angular) {
  'use strict';
  angular.module("TaskManagement").controller('SoapController', ['$scope', '$soap', function($scope, $soap) {
      $scope.task = {};
        
      $scope.edit = function (taskId) {
        $soap.post('http://localhost:8080/SOAPWS/TaskWS', "GetTask", {
          taskId: taskId })
          .then(function(response){
              $scope.task = response;            
          });
      };
        
      $scope.editBPEL = function (taskId) {
        $soap.post('http://localhost:9090/ode/processes/CallService', "CallServiceRequest", {
          input: taskId })
          .then(function(response){
              $scope.task = response;            
          });
      };
      
      $scope.delete = function (taskId) {
        $soap.post('http://localhost:8080/SOAPWS/TaskWS', "DeleteTask", {
            taskId: taskId
          })
          .then(function (response) {
            $scope.getSoapTasks();
          });
      };
        
      $scope.getSoapTasks = function () {
          $soap.post('http://localhost:8080/SOAPWS/TaskWS', "GetTasks")
          .then(function(response){
            //nasty workaround due to bugs in angular-soap and soapclient
            if(!response) {
              $scope.tasks = [];
            } else if(angular.isArray(response)) {
              $scope.tasks = response;
            } else {
              $scope.tasks = [response];
            }
          });
      };
        
      $scope.postSoapTask = function () {
        $soap.post('http://localhost:8080/SOAPWS/TaskWS', "CreateTask", 
              $scope.task)
              .then(function(response){
                $scope.task = {};
                $scope.getSoapTasks();
              });
      };
      
      $scope.putSoapTask = function (taskId) {
        $soap.post('http://localhost:8080/SOAPWS/TaskWS', "UpdateTask", $scope.task)
          .then(function(response){
              $scope.task = {};
              $scope.getSoapTasks();
          });
      };
  }]);
}(angular))