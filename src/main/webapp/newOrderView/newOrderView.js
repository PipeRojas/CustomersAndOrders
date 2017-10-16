'use strict';

angular.module('myApp.newOrderView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/newOrderView', {
    templateUrl: 'newOrderView/newOrderView.html',
    controller: 'newOrderViewCtrl'
  });
}])

.controller('newOrderViewCtrl', ['detailsByCustomer', 'order', '$rootScope', '$scope', '$resource', '$location', function (detailsByCustomer, order, $rootScope, $scope, $resource, $location) {
        $scope.customerName=$rootScope.actualCustomer.name;
        $scope.availableProducts=$rootScope.actualCustomer.customer_available_products;
        $scope.deliveryAddress="";
        $scope.disableProducts=false;
        for (var i = 0; i < $scope.availableProducts.length; ++i) {
            $scope.availableProducts[i].addToCart=false;
            $scope.availableProducts[i].quantity=1;
        }
        $scope.noMoreThan5Products= function (){
            $scope.productsQuantity=0;
            $scope.productUnitQuantityLimit=false;
            for (var i = 0; i < $scope.availableProducts.length; ++i) {
                if($scope.availableProducts[i].addToCart){
                    $scope.productsQuantity++;
                    if($scope.availableProducts[i].quantity>=5){
                        $scope.productUnitQuantityLimit=true;
                    }
                }else{
                    $scope.availableProducts[i].quantity=1;
                }
            }
            if($scope.productsQuantity>=5){
                $scope.disableProducts=true;
            }else{
                $scope.disableProducts=false;
            }
        };
        $scope.saveOrder=function (){
            $scope.orderToSave={};
            $scope.orderToSave.delivery_address=$scope.deliveryAddress;
            $scope.orderToSave.customer_id=$rootScope.actualCustomer.customer_id;
            $scope.orderToSave.date=Date.now();
            $scope.orderToSave.orden_detail=[];
            for (var i = 0; i < $scope.availableProducts.length; ++i) {
                if($scope.availableProducts[i].addToCart){
                    $scope.actDetail={};
                    $scope.primaryKey={};
                    $scope.actOrder={};
                    $scope.actOrder.delivery_address=$scope.orderToSave.delivery_address;
                    $scope.actOrder.customer_id=$scope.orderToSave.customer_id;
                    $scope.actOrder.date=$scope.orderToSave.date;
                    $scope.primaryKey.orden=$scope.actOrder;
                    $scope.actProduct={};
                    $scope.actProduct.product_id=$scope.availableProducts[i].product_id;
                    $scope.actProduct.name=$scope.availableProducts[i].name;
                    $scope.actProduct.price=$scope.availableProducts[i].price;
                    $scope.primaryKey.product=$scope.actProduct;
                    $scope.actDetail.pk=$scope.primaryKey;
                    if(!$scope.availableProducts[i].product_description){
                        $scope.availableProducts[i].product_description="";
                    }
                    $scope.actDetail.product_description=$scope.availableProducts[i].product_description;
                    $scope.actDetail.quantity=$scope.availableProducts[i].quantity;
                    $scope.orderToSave.orden_detail.push($scope.actDetail);
                }
            }
            $scope.actCust={};
            $scope.actCust.customer_id=$rootScope.actualCustomer.customer_id;
            $scope.actCust.name=$rootScope.actualCustomer.name;
            $scope.actCust.email=$rootScope.actualCustomer.email;
            $scope.orderToSave.customer=$scope.actCust;
            $scope.orderWrapper={};
            $scope.orderWrapper.orden=$scope.orderToSave;
            $scope.orderWrapper.details=$scope.orderToSave.orden_detail;
            order.save({customerId:""+$rootScope.actualCustomer.customer_id}, $scope.orderWrapper)
            .$promise.then(
                //success
                function( data ){
                    alert("La Orden se guardó con éxito");
                    $location.path('/homeView');
                },
                //error
                function( error ){
                    alert("No se pudo guardar la orden");
                }
            );
        };
}]);
