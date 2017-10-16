'use strict';

angular.module('services.factory', ['ngRoute', 'ngResource'])
.factory('order', function($resource){
    return $resource('/customer/:customerId/orden',{id:"@_customerId"},{get: {method: 'GET', isArray: true}});
})
.factory('customer', function($resource){
    return $resource('/customer/:customerId',{id:"@_customerId"},{get: {method: 'GET'}});
})
.factory('orderByRange', function($resource){
    return $resource('/customer/:customerId/orden?from=:fromDate&to=:toDate',{id:"@_customerId", fromDate:"@_fromDate", toDate:"@_toDate"},{get: {method: 'GET', isArray: true}});
})
.factory('detailsByCustomer', function($resource){
    return $resource('/customer/:customerId/orden/details',{id:"@_customerId"},{get: {method: 'GET', isArray: true}});
});