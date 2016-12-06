(function () {
  'use strict';
  angular.module('starter.services')

    .factory('InfoService', InfoService)
    .factory('infoService', infoService)
    .factory('queryInfoService', queryInfoService);

  /**@ngInject*/
  function InfoService($resource) {
    return $resource('/info', {
      method: 'POST' // this method issues a POST request
    });
  }

  /**@ngInject*/
  function infoService($resource) {
    return $resource('/info/:id', {id: '@_id'}, {
      update: {
        method: 'PUT', // this method issues a PUT request
        params: {
          id: '@id',
          name: '@name',
          description: '@description'
        }
      }
    });
  }

  /**@ngInject*/
  function queryInfoService($resource) {
    return $resource('/getInfo',
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
