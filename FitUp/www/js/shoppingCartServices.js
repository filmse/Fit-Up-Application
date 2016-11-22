/**
 * Created by Film on 9/10/2559.
 */
(function () {
  'use strict';
  angular.module('starter.services')
    .factory('shoppingListService', shoppingListService)
    .factory('shoppingUpdateService', shoppingUpdateService)
    .factory('shoppingService', shoppingService);

  /** @ngInject */
  function shoppingService($resource) {
    return $resource('http://localhost:8080/shopping', {}, {
      // authenticate: {
      method: 'POST'
      // params: {'action': 'authenticate'},
      // header: {'Content-Type': 'application/x-www-form-urlencoded'}
      //}
    })
  }

  /**@ngInject*/
  function shoppingListService($resource) {
    return $resource('http://localhost:8080/shoppingList',
      {
        query: {
          method: 'GET'
        }
      });
  }

  /**@ngInject*/
  function shoppingUpdateService($resource) {
    return $resource('http://localhost:8080/shoppingList/:id', {id: '@_id'}, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });
  }

  // /** @ngInject */
  // function shoppingService($resource) {
  //   return $resource('10.80.54.110:8080/shopping', {}, {
  //     // authenticate: {
  //     method: 'POST'
  //     // params: {'action': 'authenticate'},
  //     // header: {'Content-Type': 'application/x-www-form-urlencoded'}
  //     //}
  //   })
  // }
  //
  // /**@ngInject*/
  // function shoppingListService($resource) {
  //   return $resource('10.80.54.110:8080/shoppingList',
  //     {
  //       query: {
  //         method: 'GET'
  //       }
  //     });
  // }
  //
  // /**@ngInject*/
  // function shoppingUpdateService($resource) {
  //   return $resource('10.80.54.110:8080/shoppingList/:id', {id: '@_id'}, {
  //     update: {
  //       method: 'PUT' // this method issues a PUT request
  //     }
  //   });
  // }

})();
