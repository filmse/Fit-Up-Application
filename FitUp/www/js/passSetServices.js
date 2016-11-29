/**
 * Created by Film on 5/11/2559.
 */
(function () {
  'use strict';
  angular.module('starter.services')

    .factory('PassSetService', PassSetService)
    .factory('querypassSetService', querypassSetService);

  /**@ngInject*/
  function PassSetService($resource) {
    return $resource('/passSet', {
      method: 'POST' // this method issues a POST request
    });
  }

  /**@ngInject*/
  function querypassSetService($resource) {
    return $resource('/passSetList',
      {
        query: {
          method: 'GET',// this method issues a GET request
          params: {
            name: ''
          }
        }
      });
  }

})();
