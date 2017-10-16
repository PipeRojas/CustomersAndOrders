'use strict';

angular.module('myApp', [
  'ngRoute',
  'myApp.loginView',
  'myApp.templatesController',
  'myApp.homeView',
  'myApp.lastMonthOrdersView',
  'myApp.newOrderView',
  'myApp.version',
  'services.factory'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl: 'loginView/loginView.html',
        controller: 'loginViewCtrl'
    });
}]);

