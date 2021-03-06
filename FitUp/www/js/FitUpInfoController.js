(function () {
  'use strict';
  angular.module('starter.controllers')

  /** @ngInject */
    .controller('addInfoController', function ($scope, $http, $location, $rootScope, InfoService, $ionicLoading, $timeout, $state) {

      var vm = this;
      vm.info = {};
      vm.addInfo = true;
      vm.addInfo = function (flowFiles) {

        $scope.user = $rootScope.user;

        InfoService.save({userId: $rootScope.user.id}, vm.info, function (data) {
          var infoId = data.id;
          // set location
          flowFiles.opts.target = 'http://localhost:8080/infoImage/add';
          flowFiles.opts.testChunks = false;
          flowFiles.opts.query = {infoId: infoId};
          flowFiles.upload();
          $rootScope.addSuccess = true;
          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
          });
          $timeout(function () {
            $ionicLoading.hide();
          }, 2000);
          $state.go("app.video");
        })
      }
    })
    /** @ngInject */
    .controller('listInfoController', function ($scope, $rootScope, infoService, queryInfoService) {

      // $scope.queryPromise = infoService.query(function (data) {
      //   $scope.infos = data;
      // }).$promise;

      $scope.searchInfo = function (name) {
        queryInfoService.query({name: name}, function (data) {
          $rootScope.infos = data;
        });
      };

    })
    /** @ngInject */
    .controller('editInfoController', function ($rootScope, $ionicPopup, $stateParams, $scope, $route, $timeout, $ionicLoading, $routeParams, $location, infoService, InfoService, $http) {

      $scope.$on('$ionicView.loaded', function (data, event) {
        console.log(event.stateParams.id);
        var infoId = event.stateParams.id;
        infoService.get({id: infoId}, function (data) {
          $scope.infos = data;
        })
      });

      $scope.editInfo = function (flowFiles) {
        infoService.update({id: $scope.infos.id}, $scope.infos, function () {
          var infoId = $scope.infos.id;
          // set location
          flowFiles.opts.target = 'http://localhost:8080/infoImage/add';
          flowFiles.opts.testChunks = false;
          flowFiles.opts.query = {infoId: infoId};
          flowFiles.upload();
          $rootScope.editSuccess = true;
          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
          });
          $timeout(function () {
            $ionicLoading.hide();
          }, 2000);
          $location.path("app.video");
        });
      };

      $scope.deleteImageInfo = function (id) {
        console.log(id);
        var answer = confirm("Are you sure?");
        if (answer) {
          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
          });
          $http.delete("http://localhost:8080/removeImage?imageId=" + id + "&infoId=" + $scope.infos.id).success(function (data) {
            $scope.infos = data;
            console.log($scope.infos);
            $rootScope.deleteImageSuccess = true;
            $timeout(function () {
              $ionicLoading.hide();
            }, 2000);
          });
        }
      }
    })
    /** @ngInject */
    .controller('deleteInfoController', function ($scope, $route, $timeout, $ionicLoading, $routeParams, $location, $rootScope, infoService, InfoService, $http) {
      $scope.deleteInfo = function (id) {
        console.log(id);

        var answer = confirm("Are you sure?");
        if (answer) {
          $http.delete("http://localhost:8080/remove?infoId=" + id + "&userId=" + $rootScope.user.id).success(function (data) {
            $rootScope.user = data;
            $ionicLoading.show({
              template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
            });
            console.log("Complete");
            $timeout(function () {
              $ionicLoading.hide();
              console.log("Complete");
              infoService.delete({id: id}, function () {
                console.log(id);
                $rootScope.deleteSuccess = true;
              });
            }, 2000);
          })
        }
      };
    })
    /** @ngInject */
    .controller('showsNewInfoController', function ($scope, $rootScope, infoService, queryInfoService, $http, $ionicLoading, $timeout) {

      $scope.queryPromise = infoService.query(function (data) {
        $ionicLoading.show({
          template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
        });
        $timeout(function () {
          $ionicLoading.hide();
        }, 3000);
        $scope.infos = data;
      }).$promise;


      $scope.adminDeleteInfo = function (id) {
        console.log(id);
        var answer = confirm("Are you sure?");
        if (answer) {

          infoService.delete({id: id}, function () {
            console.log(id);
            $rootScope.deleteSuccess = true;
          });
          //location.reload("app.video")
        }
      }

    })

})();
