/**
 * Created by Film on 9/10/2559.
 */
(function () {
  'use strict';
  angular.module('starter.controllers')

  /** @ngInject */
    .controller('shoppingListController', function ($scope, shoppingListService) {

      $scope.queryPromise = shoppingListService.query(function (data) {
        $scope.shoppingCarts = data;
      }).$promise;
    })

    .controller('dateController', function ($scope) {
      $scope.today = new Date();
    });

})();
