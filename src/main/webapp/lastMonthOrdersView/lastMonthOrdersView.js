'use strict';

angular.module('myApp.lastMonthOrdersView', ['ngRoute', 'ngResource'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/lastMonthOrdersView', {
    templateUrl: 'lastMonthOrdersView/lastMonthOrdersView.html',
    controller: 'lastMonthOrdersViewCtrl'
  });
}])

.controller('lastMonthOrdersViewCtrl', ['detailsByCustomer', 'orderByRange', 'customer', '$rootScope', '$scope', '$resource', '$location', function (detailsByCustomer, orderByRange, customer, $rootScope, $scope, $resource, $location) {
        
        //Source: http://jsfiddle.net/abdulrauf6182012/2Frm3/
        $scope.formatDate=function (date){
            var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();
            if (month.length < 2) month = '0' + month;
            if (day.length < 2) day = '0' + day;
            return [day, month, year].join('-');
        };
        
        $scope.customerName=$rootScope.actualCustomer.name;
        $scope.date = new Date();
        $scope.firstDay = new Date($scope.date.getFullYear(), $scope.date.getMonth(), 1);
        $scope.lastDay = new Date($scope.date.getFullYear(), $scope.date.getMonth() + 1, 0);
        orderByRange.get({customerId:""+$rootScope.actualCustomer.customer_id, fromDate:$scope.formatDate($scope.firstDay), toDate:$scope.formatDate($scope.lastDay)})
            .$promise.then(
                //success
                function( value ){
                    //Obtenemos Ordenes
                    $scope.orders=value;
                    detailsByCustomer.get({customerId:""+$rootScope.actualCustomer.customer_id})
                        .$promise.then(
                            //success
                            function( value ){
                                //Obtenemos Detalles
                                $scope.customerOrderDetails=value;
                                for(var i=0; i<$scope.orders.length;i++){
                                    $scope.orders[i].total=0;
                                    if(!$scope.orders[i].orden_detail){
                                        $scope.orders[i].orden_detail=[];
                                    }
                                    for(var j=0;j<$scope.customerOrderDetails.length;j++){
                                        if($scope.orders[i].order_id===$scope.customerOrderDetails[j].orden.order_id){
                                            $scope.orders[i].orden_detail.push($scope.customerOrderDetails[j]);
                                            $scope.orders[i].total+=$scope.customerOrderDetails[j].product.price*$scope.customerOrderDetails[j].quantity;
                                        }
                                    }
                                }
                            },
                            //error
                            function( error ){
                                alert("No se pudo cargar las ordenes");
                            });
                },
                //error
                function( error ){
                    alert("No se pudo cargar las ordenes");
                }
            );
    
        
}]);
