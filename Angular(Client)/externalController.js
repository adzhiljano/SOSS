(function (angular, _) {
  'use strict';
  angular.module("TaskManagement").controller('ExternalController', ['$scope', '$http', function($scope, $http) {
      $scope.getWeather = function () {
        var chosenCity = $scope.city? $scope.city : 'Sofia';
        var daysCount = $scope.days ? $scope.days : 1; 
        $http.get("http://api.openweathermap.org/data/2.5/forecast/daily?" + 
        "q=" + chosenCity + 
        "&cnt=" + daysCount +
        "&APPID=aeeefb1decec498868646ff6dfa571ab")
          .then(function (response) {
            var data = response.data
            $scope.cityInfo = data.city.name + ", " + data.city.country;  
            $scope.weatherPerDays = _.map(data.list, function (infoPerDay) {
              return {
                'main': infoPerDay.weather[0].main,
				        'description': infoPerDay.weather[0].description
              };
            });
          });
      };
    }]);
}(angular, _))