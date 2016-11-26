/**
 * Created by Film on 23/9/2559.
 */
(function () {
  'use strict';
  angular.module('starter.controllers')
  /** @ngInject */
    .controller('addVideoController', function (VideoService, $http, $scope, $rootScope, $state) {

      $scope.price = {
        price: null, availableOptions: [
          {id: '-', name: '-'},
          {id: '50', name: '50'},
          {id: '70', name: '70'},
          {id: '100', name: '100'},
          {id: '100', name: '150'},
          {id: '100', name: '200'}
        ],
      };

      var vm = this;
      vm.video = {};
      vm.addVideo = true;
      vm.addVideo = function (flowFiles) {

        $scope.user = $rootScope.user;

        VideoService.save({userId: $rootScope.user.id}, vm.video, function (data) {
          var videoId = data.id;
          // set location
          flowFiles.opts.target = 'http://localhost:8080/videoClip/add';
          flowFiles.opts.testChunks = false;
          flowFiles.opts.query = {videoId: videoId, videoName: name};
          flowFiles.upload();
          $rootScope.addSuccess = true;
          $state.go("app.video");
        })
      }
    })
    /** @ngInject */
    .controller('listVideoController', function (shoppingAddUserService, userService, $scope, $rootScope, videoService, shoppingService, $sce, addToFavoriteService, getToFavoriteService) {

      $scope.queryPromise = userService.query(function (data) {
        $rootScope.users = data;
      }).$promise;

      $scope.queryPromise = videoService.query(function (data) {
        $scope.videos = data;

        angular.forEach($scope.videos, function (value, key) {
          console.log(value.videoClips[0].fileName);
          // $scope.trustSrc = function (src) {
          //   return $sce.trustAsResourceUrl(src);
          // }
          // // $scope.movie = {src: "templates/video/" +value};
          // $scope.movie = {src: "templates/video/One two three four Steps1.mp4"}, {src: "templates/video/Fitness headback.mp4"};
        })

      }).$promise;

      $scope.searchInfo = function (name) {
        queryVideoService.query({name: name}, function (data) {
          $scope.videos = data;
        });
      }

      $scope.addToCart = function (video) {
        console.log(video);
        //console.log(user);

        $scope.user = $rootScope.user;
        console.log($rootScope.user);
        video.videos = null;
        shoppingService.save({videoId: video.id,userId: $rootScope.user.id}, {shoppingCartId: $rootScope.shoppingCart}, function (shoppingCart) {

          alert("Success!!");
          $rootScope.shoppingCart = shoppingCart;
        }, function (user) {

          $scope.user = $rootScope.user;
          shoppingAddUserService.save({userId: $rootScope.user.id}, {shoppingCartId: $rootScope.shoppingCart}, function (shoppingCart) {
            alert("Success!!");
            $rootScope.shoppingCart = shoppingCart;
          }, function () {
            // fail event
            alert("Failed!!");
          })
        })
      }

      $scope.addToFavorite = function (user) {
        user.users = null;
        addToFavoriteService.save({userId: user.id}, {FavoriteId: $rootScope.favorite}, function (favorite) {
          //success event
          $rootScope.favorite = favorite;
          console.log("success")
          // window.location.reload();
          // $state.go("app.payment");
          // $scope.$apply();
          // $scope.$digest();
        }, function () {
          // fail event
          alert("Failed!!");
        })
      }

      $scope.queryPromise = getToFavoriteService.query(function (data) {
        $scope.favorites = data;
      }).$promise;

    })
    /** @ngInject */
    .controller('editVideoController', function ($scope, $route, $timeout, $ionicLoading, $routeParams, $location, $rootScope, videoService, VideoService, $http) {

      $scope.$on('$ionicView.loaded', function (data, event) {
        console.log(event.stateParams.id)
        var videoId = event.stateParams.id;
        videoService.get({id: videoId}, function (data) {
          $scope.videos = data;
        })
      })

      $scope.editVideo = function (flowFiles) {
        videoService.update({id: $scope.videos.id}, $scope.videos, function () {
          var videoId = $scope.videos.id;
          // set location
          flowFiles.opts.target = 'http://localhost:8080/videoClip/add';
          flowFiles.opts.testChunks = false;
          flowFiles.opts.query = {videoId: videoId};
          flowFiles.upload();
          $rootScope.editSuccess = true;
          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
          });
          $timeout(function () {
            $ionicLoading.hide();
          }, 4000);
          $location.path("app.video");
        });
      };

      $scope.deleteVideo = function (id) {
        console.log(id)
        var answer = confirm("Are you sure?");
        if (answer) {
          $http.delete("http://localhost:8080/removeVideoClip?videoClipId=" + id + "&videoId=" + $scope.videos.id).success(function (data) {
            $scope.videos = data;
            console.log(video)
            $location.path("app.video");
          });
        }
      }
    })
    /** @ngInject */
    .controller('HomeCtrl', function ($sce, videoService, $scope) {
        this.config = {
          sources: [
            {
              src: $sce.trustAsResourceUrl('templates/video/One two three four Steps2.mp4'),
              type: "video/mp4"
            }
            // ,
            // {
            //   src: $sce.trustAsResourceUrl("http://static.videogular.com/assets/videos/videogular.webm"),
            //   type: "video/webm"
            // },
            // {
            //   src: $sce.trustAsResourceUrl("http://static.videogular.com/assets/videos/videogular.ogg"),
            //   type: "video/ogg"
            // }
          ],
          tracks: [
            {
              src: "http://www.videogular.com/assets/subs/pale-blue-dot.vtt",
              kind: "subtitles",
              srclang: "en",
              label: "English",
              default: ""
            }
          ],
          theme: "lib/videogular-themes-default/videogular.css",
          plugins: {
            poster: "templates/video/FitUp005.png"
            // poster: "http://www.videogular.com/assets/images/videogular.png"
          }
        };
      }
    );
})();
