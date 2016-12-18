/**
 * Created by Film on 5/11/2559.
 */
(function () {
  'use strict';
  angular.module('starter.controllers')

  /** @ngInject */
    .controller('addRequestController', function ($scope, $http, $rootScope, RequestService, $ionicLoading, $timeout, $state) {

      var vm = this;
      vm.request = {};
      vm.reQuest = function () {

        RequestService.save(vm.request, function () {
          $rootScope.addSuccess = true;
          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
          });
          $timeout(function () {
            $ionicLoading.hide();
          }, 2000);
          $state.go('app.video');
        })
      }
    })
    /** @ngInject */
    .controller('listRequestController', function ($scope, $rootScope, infoService, requestService, queryRequestService, $http, $ionicLoading, $timeout) {

      $scope.queryPromise = queryRequestService.query(function (data) {
        $ionicLoading.show({
          template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
        });
        $timeout(function () {
          $ionicLoading.hide();
        }, 2000);
        $scope.requests = data;
      }).$promise;

      $scope.deleteRequest = function (id) {
        console.log(id);
        var answer = confirm("Are you sure?");
        if (answer) {

          requestService.delete({id: id}, function () {
            console.log(id);
            $rootScope.deleteSuccess = true;
          });
          location.reload("app.video")
        }
      }
    })

})();
