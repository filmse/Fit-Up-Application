/**
 * Created by Film on 3/12/2559.
 */
(function () {
  'use strict';
  angular.module('starter.controllers')

  /** @ngInject */
    .controller('favoriteController', function (getToFavoriteService, $scope, $rootScope, $http, $ionicLoading, $timeout) {

      $scope.queryPromise = getToFavoriteService.query(function (data) {
        $ionicLoading.show({
          template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
        });
        $timeout(function () {
          $ionicLoading.hide();
        }, 2000);
        $scope.favorites = data;
      }).$promise;
    })

})();
