'use strict';

angular.module('myApp.templatesController', ['ngRoute'])

.controller('templatesControllerCtrl', ['$rootScope', '$scope', '$location', function ($rootScope, $scope, $location) {
        $scope.newOrder = function(){
            $location.path('/newOrderView');
        };
        $scope.lastMonthOrders = function(){
            $location.path('/lastMonthOrdersView');
        };
        $scope.logout = function(){
            $location.path("/loginView");
        };
}]);
