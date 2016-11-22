/**
 * Created by Film on 13/11/2559.
 */
(function () {
  'use strict';
  angular.module('starter.controllers')

  /** @ngInject */
    .controller('ctrlController', function ($scope, $state) {

      $scope.videoClicks = function () {
        $state.go("app.videoExpand");
      }
      $scope.InfoClicks = function () {
        $state.go("app.board");
      }
      $scope.aboutUsClicks = function () {
        $state.go("app.aboutUs");
      }

      $scope.uploadVideo = function () {
        $state.go("app.addVideo");
      }
      $scope.VideoHis = function () {
        $state.go("app.listVideo");
      }
      $scope.UploadInfo = function () {
        $state.go("app.addInformation");
      }
      $scope.InfoHis = function () {
        $state.go("app.listInformation");
      }
    })

})();
