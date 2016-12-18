/**
 * Created by Film on 9/10/2559.
 */
(function () {
  'use strict';
  angular.module('starter.services')
    .factory('shoppingListService', shoppingListService)
    .factory('shoppingUpdateService', shoppingUpdateService)
    .factory('transactionService', transactionService)
    .factory('transactionListService', transactionListService)
    .factory('purchasedService', purchasedService)
    .factory('shoppingService', shoppingService);

  /** @ngInject */
  function shoppingService($resource) {
    return $resource('/shopping', {}, {
      method: 'POST'
    })
  }

  /** @ngInject */
  function transactionService($resource) {
    return $resource('/transaction', {}, {
      method: 'POST'
    })
  }

  /** @ngInject */
  function purchasedService($resource) {
    return $resource('/purchased', {}, {
      method: 'POST'
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
        method: 'PUT', // this method issues a PUT request
        params: {
          id: '@id',
          confirmEmail: '@confirmEmail',
          confirmTime: '@confirmTime',
          confirmMoney: '@confirmMoney',
          confirmSecretId: '@confirmSecretId'
        }
      }
    });
  }

  /**@ngInject*/
  function transactionListService($resource) {
    return $resource('/transactionList',
      {
        query: {
          method: 'GET'
        }
      });
  }

})();
