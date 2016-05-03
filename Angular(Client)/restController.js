(function (angular) {
  'use strict';
  angular.module("TaskManagement").controller('RestController', ['$scope', '$http', function($scope, $http) {
        $scope.task = {};
        
        $scope.edit = function (taskId) {
          $http.get("http://localhost:5000/api/tasks/" + taskId)
            .then(function (response) {
              $scope.task = response.data;
            });
        };
        
        $scope.delete = function (taskId) {
          $http.delete("http://localhost:5000/api/tasks/" + taskId)
            .then(function (response) {
              $scope.getRestTasks();
            });
        };
        
        $scope.getRestTasks = function () {
            $http.get("http://localhost:5000/api/tasks")
            .then(function (response) {
              $scope.tasks = response.data;
            })
        };
        
        $scope.postRestTask = function () {
          $http.post("http://localhost:5000/api/tasks",
           $scope.task)
              .then(function (response) {
                $scope.task = {};
                $scope.getRestTasks();
            });
        };
        
        $scope.putRestTask = function (taskId) {
          $http.put("http://localhost:5000/api/tasks/" + taskId,
          $scope.task)
            .then(function (response) {
              $scope.task = {};
              $scope.getRestTasks();
            });
        };
        
    }]);
}(angular))