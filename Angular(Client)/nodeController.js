(function (angular) {
  'use strict';
  angular.module("TaskManagement").controller('NodeController', ['$scope', '$http', function($scope, $http) {
      $scope.task = {};
      
      $scope.edit = function (taskId) {
        $http.get("http://localhost:3000/api/tasks/" + taskId)
          .then(function (response) {
            $scope.task = response.data[0];
          });
      };
      
      $scope.delete = function (taskId) {
        $http.delete("http://localhost:3000/api/tasks/" + taskId)
          .then(function (response) {
            $scope.getNodeTasks();
          });
      };
      
      $scope.getNodeTasks = function () {
          $http.get("http://localhost:3000/api/tasks")
          .then(function (response) {
            $scope.tasks = response.data;
          })
      };
      
      $scope.postNodeTask = function () {
        $http.post("http://localhost:3000/api/tasks",
          $scope.task)
            .then(function (response) {
              $scope.task = {};
              $scope.getNodeTasks();
          });
      };
      
      $scope.putNodeTask = function (taskId) {
        $http.put("http://localhost:3000/api/tasks/" + taskId,
        $scope.task)
          .then(function (response) {
            $scope.task = {};
            $scope.getNodeTasks();
          });
      };
  }]);
}(angular))