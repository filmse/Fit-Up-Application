/**
 * Created by Film on 5/11/2559.
 */
(function () {
  'use strict';
  angular.module('starter.controllers')

  /** @ngInject */
    .controller('addPassSetController', function ($scope, $http, $rootScope, PassSetService, $ionicLoading, $timeout, $state) {

      var vm = this;
      vm.passSet = {};
      vm.SetPassword = function () {

        PassSetService.save(vm.passSet, function () {
          $rootScope.addSuccess = true;
          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
          });
          $timeout(function () {
            $ionicLoading.hide();
          }, 2000)
          $state.go('app.login');
        })
      }
    })
    /** @ngInject */
    .controller('listPassSetController', function ($scope, $rootScope, infoService, passSetService, querypassSetService, $http, $ionicLoading, $timeout) {

      $scope.queryPromise = querypassSetService.query(function (data) {
        $ionicLoading.show({
          template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
        });
        $timeout(function () {
          $ionicLoading.hide();
        }, 2000);
        $scope.passSets = data;
      }).$promise;

      $scope.deleteRequest = function (id) {
        console.log(id);
        var answer = confirm("Are you sure?");
        if (answer) {

          passSetService.delete({id: id}, function () {
            console.log(id);
            $rootScope.deleteSuccess = true;
          });
          location.reload("app.video")
        }
      }
    })

})();
