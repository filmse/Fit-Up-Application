/**
 * Created by Film on 9/10/2559.
 */
(function () {
  'use strict';
  angular.module('starter.controllers')

  /** @ngInject */
    .controller('shoppingListController', function ($scope, shoppingUpdateService) {

      $scope.Confirm = function () {
        console.log("Success!!");
      };

      $scope.queryPromise = shoppingUpdateService.query(function (data) {
        $scope.shoppingCarts = data;
        console.log($scope.shoppingCarts);
      }).$promise;
    })
    /** @ngInject */
    .controller('dateController', function ($scope) {
      $scope.today = new Date();
    });

})();
