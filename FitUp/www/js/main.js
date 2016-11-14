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
        $state.go("app.videoExpand");
      }

    })
})();
