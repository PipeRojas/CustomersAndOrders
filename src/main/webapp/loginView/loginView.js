'use strict';

angular.module('myApp.loginView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/loginView', {
    templateUrl: 'loginView/loginView.html',
    controller: 'loginViewCtrl'
  });
}])

.controller('loginViewCtrl', ['customer', '$rootScope', '$scope', '$resource', '$location', function (customer, $rootScope, $scope, $resource, $location) {
        $scope.user;
        $scope.wrongId=false;
        $scope.login = function(){
            if($scope.user){
                customer.get({customerId:""+$scope.user})
                    .$promise.then(
                        //success
                        function( value ){
                            $rootScope.actualCustomer=value;
                            $location.path("/homeView");
                        },
                        //error
                        function( error ){
                            $scope.wrongId=true;
                            $scope.errorMessage="El ID no corresponde a un Cliente Registrado";
                        }
                    );
            }else{
                $scope.wrongId=true;
                $scope.errorMessage="Ingrese un ID de Cliente valido";
            }
        };
}]);
