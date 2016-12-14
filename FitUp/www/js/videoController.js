/**
 * Created by Film on 23/9/2559.
 */
(function () {
  'use strict';
  angular.module('starter.controllers')

  /** @ngInject */
    .controller('addVideoController', function ($timeout, $ionicLoading, VideoService, $http, $scope, $rootScope, $state) {

      $scope.price = {
        price: null, availableOptions: [
          {id: '-', name: '-'},
          {id: '50', name: '50'},
          {id: '70', name: '70'},
          {id: '100', name: '100'},
          {id: '100', name: '150'},
          {id: '100', name: '200'}
        ]
      };

      var vm = this;
      vm.video = {};
      vm.addVideo = true;
      vm.addVideo = function (flowFiles) {

        $scope.user = $rootScope.user;

        VideoService.save({userId: $rootScope.user.id}, vm.video, function (data) {
          var videoId = data.id;

          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Video Uploading...</p>'
          });

          $timeout(function () {
            $ionicLoading.hide();
            $state.go("app.video");
          }, 7000);
          // set location
          flowFiles.opts.target = 'http://localhost:8080/videoClip/add';
          flowFiles.opts.testChunks = false;
          flowFiles.opts.query = {videoId: videoId, videoName: name};
          flowFiles.upload();
          $rootScope.addSuccess = true;
          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Video Uploading...</p>'
          });

        })
      };
    })
    /** @ngInject */
    .controller('listVideoController', function ($location, $ionicLoading, $state, $ionicPopup, $timeout, userService, $scope, $rootScope, videoService, shoppingService, $sce, addToFavoriteService) {

      $scope.queryPromise = userService.query(function (data) {
        $rootScope.users = data;
      }).$promise;

      $scope.playVideo = function (video) {
        console.log(video);
        console.log("HAHA");
        $timeout(function () {
          $ionicPopup.alert({
            title: '"Purchase Exercise Video"',
            template: 'This is the exercise example <br> if you need more <br> you can  purchase it'
          });
          $timeout(function () {
            //location.reload();
            location.reload();
          }, 10000);
        }, 7000);
      };


      $scope.queryPromise = videoService.query(function (data) {
        $scope.videos = data;
        //angular.forEach($scope.videos, function (value, key) {
        //console.log(value.videoClips[0].fileName);
        //})
      }).$promise;

      $scope.searchInfo = function (name) {
        queryVideoService.query({name: name}, function (data) {
          $scope.videos = data;
        });
      };

      $scope.addToCart = function (video) {
        //console.log(video);
        $scope.user = $rootScope.user;
        //console.log($scope.user);
        video.videos = null;

        shoppingService.save({
          videoId: video.id,
          userId: $rootScope.user.id
        }, {shoppingCartId: $rootScope.shoppingCart}, function (shoppingCart) {

          $ionicPopup.alert({
            title: 'Success!',
            template: 'Add video to your cart'
          });
          $rootScope.shoppingCart = shoppingCart;
        }, function () {
          // fail event
          $ionicPopup.alert({
            title: 'Failed!',
            template: 'Cannot add video to your cart'
          });
        })
      };

      $scope.addToFavorite = function (video) {
        console.log(video);
        $scope.user = $rootScope.user;
        console.log($scope.user);
        video.videos = null;

        addToFavoriteService.save({
          videoId: video.id,
          userId: $scope.user.id
        }, {FavoriteId: $rootScope.favorite}, function (favorite) {

          //success event
          $ionicPopup.alert({
            title: 'Success!',
            template: 'Add video to your favorite'
          });
          $rootScope.favorite = favorite;
          console.log("success");

        }, function () {
          // fail event
          $ionicPopup.alert({
            title: 'Failed!',
            template: 'Cannot add video to your favorite'
          });
        })
      };
    })
    /** @ngInject */
    .controller('editVideoController', function ($scope, $route, $timeout, $ionicLoading, $routeParams, $location, $rootScope, videoService, VideoService, $http) {

      $scope.$on('$ionicView.loaded', function (data, event) {
        console.log(event.stateParams.id)
        var videoId = event.stateParams.id;
        videoService.get({id: videoId}, function (data) {
          $scope.videos = data;
        })
      });

      $scope.editVideo = function (flowFiles) {
        videoService.update({id: $scope.videos.id}, $scope.videos, function () {
          var videoId = $scope.videos.id;
          // set location
          flowFiles.opts.target = 'http://10.80.52.77:8080/videoClip/add';
          flowFiles.opts.testChunks = false;
          flowFiles.opts.query = {videoId: videoId};
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

      $scope.deleteVideo = function (id) {
        console.log(id);
        var answer = confirm("Are you sure?");
        if (answer) {
          $http.delete("http://localhost:8080/removeVideo?videoId=" + id + "&userId=" + $rootScope.user.id).success(function (data) {
            $rootScope.user = data;
            console.log($rootScope.user);
            $ionicLoading.show({
              template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
            });
            console.log("Complete");
            $timeout(function () {
              $ionicLoading.hide();
              console.log("Complete");
              videoService.delete({id: id}, function () {
                console.log(id);
                $rootScope.deleteSuccess = true;
              });
            }, 2000);
          });
        }
      }
    })

})();
