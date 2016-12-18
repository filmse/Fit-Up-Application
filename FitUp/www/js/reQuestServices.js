/**
 * Created by Film on 5/11/2559.
 */
(function () {
  'use strict';
  angular.module('starter.services')

    .factory('RequestService', RequestService)
    .factory('requestService', requestService)
    .factory('queryRequestService', queryRequestService);

  /**@ngInject*/
  function RequestService($resource) {
    return $resource('/addRequest', {
      method: 'POST' // this method issues a POST request
    });
  }

  /** @ngInject */
  function requestService($resource) {
    return $resource('/getRequest/:id', {id: '@_id'}, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });
  }

  /**@ngInject*/
  function queryRequestService($resource) {
    return $resource('/requestList', {
      query: {
        method: 'GET'// this method issues a GET request
      }
    });
  }

})();
