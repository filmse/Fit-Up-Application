/**
 * Created by Film on 9/10/2559.
 */
(function () {
  'use strict';
  angular.module('starter.controllers')

  /** @ngInject */
    .controller('shoppingListController', function (purchasedService, $http, transactionListService, $timeout, $ionicLoading, $ionicPopup, $rootScope, transactionService, $scope, shoppingUpdateService, $state) {

      $scope.transaction = {};
      $scope.confirmPayment = function () {
        $scope.user = $rootScope.user;
        console.log($scope.user);
        transactionService.save({userId: $scope.user.id}, $scope.transaction, function () {

          $rootScope.addSuccess = true;
          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
          });
          $timeout(function () {
            $ionicLoading.hide();
          }, 2000);
          $state.go('app.video');
        })
      };

      $scope.queryPromise = shoppingUpdateService.query(function (data) {
        $scope.shoppingCarts = data;
        //console.log($scope.shoppingCarts);
      }).$promise;

      $scope.queryPromise = transactionListService.query(function (data) {
        $scope.transactions = data;
        //console.log($scope.shoppingCarts);
      }).$promise;

      $scope.deletePayment = function (id) {
        console.log(id);
        console.log("Welcome");
      };

      $scope.purchased = {};
      $scope.purchased = function () {
        console.log($scope.purchased.videoId);
        console.log($scope.purchased.userId);
        console.log("Welcome");

        purchasedService.save({
          videoId: $scope.purchased.videoId, userId: $scope.purchased.userId
        }, {purchasedId: $rootScope.purchased}, function () {
          console.log($scope.purchased.userId);
          console.log($scope.purchased.videoId);
          $rootScope.addSuccess = true;
          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
          });
          $timeout(function () {
            $ionicLoading.hide();
          }, 2000);
          $state.go('app.video');
        })
      };


    })
    /** @ngInject */
    .controller('dateController', function ($scope) {
      $scope.today = new Date();
    });

})
();
