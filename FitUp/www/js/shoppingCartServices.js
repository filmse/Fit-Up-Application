/**
 * Created by Film on 9/10/2559.
 */
(function () {
  'use strict';
  angular.module('starter.services')
    .factory('shoppingListService', shoppingListService)
    .factory('shoppingUpdateService', shoppingUpdateService)
    .factory('shoppingAddUserService', shoppingAddUserService)
    .factory('shoppingService', shoppingService);

  /** @ngInject */
  function shoppingService($resource) {
    return $resource('/shopping', {}, {
      // authenticate: {
      method: 'POST'
      // params: {'action': 'authenticate'},
      // header: {'Content-Type': 'application/x-www-form-urlencoded'}
      //}
    })
  }

  /** @ngInject */
  function shoppingAddUserService($resource) {
    return $resource('/shoppingAddUser/:id', {id: '@_id'}, {
      // authenticate: {
      method: 'PUT'
      // params: {'action': 'authenticate'},
      // header: {'Content-Type': 'application/x-www-form-urlencoded'}
      //}
    })
  }

  /**@ngInject*/
  function shoppingListService($resource) {
    return $resource('/shoppingList',
      {
        query: {
          method: 'GET'
        }
      });
  }

  /**@ngInject*/
  function shoppingUpdateService($resource) {
    return $resource('/shoppingList/:id', {id: '@_id'}, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });
  }

})();
