'use strict';

angular.module('myApp.homeView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/homeView', {
    templateUrl: 'homeView/homeView.html',
    controller: 'homeViewCtrl'
  });
}])

.controller('homeViewCtrl', ['customer', '$rootScope', '$scope', '$resource', '$location', function (customer, $rootScope, $scope, $resource, $location) {
        $scope.customerName=$rootScope.actualCustomer.name;
}]);
