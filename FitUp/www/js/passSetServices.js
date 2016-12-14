/**
 * Created by Film on 5/11/2559.
 */
(function () {
  'use strict';
  angular.module('starter.services')

    .factory('PassSetService', PassSetService)
    .factory('passSetService', passSetService)
    .factory('querypassSetService', querypassSetService);

  /**@ngInject*/
  function PassSetService($resource) {
    return $resource('/passSet', {
      method: 'POST' // this method issues a POST request
    });
  }

  /**@ngInject*/
  function querypassSetService($resource) {
    return $resource('/passSetList', {
      query: {
        method: 'GET'// this method issues a GET request
      }
    });
  }

  /** @ngInject */
  function passSetService($resource) {
    return $resource('/passSet/:id', {id: '@_id'}, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });
  }

})();
