(function () {
  'use strict';
  angular.module('starter.services')

    .factory('InfoService', InfoService)
    .factory('infoService', infoService)
    .factory('queryInfoService', queryInfoService);

  /**@ngInject*/
  function InfoService($resource) {
    return $resource('http://localhost:8080/info', {
      method: 'POST' // this method issues a POST request
    });
  }

  /**@ngInject*/
  function infoService($resource) {
    return $resource('http://localhost:8080/info/:id', {id: '@_id'}, {
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
    return $resource('http://localhost:8080/getInfo',
      {
        query: {
          method: 'GET',// this method issues a GET request
          params: {
            name:''
          }
        }
      });
  }


  // /**@ngInject*/
  // function InfoService($resource) {
  //   return $resource('http://10.80.54.235.110:8080/info', {
  //     method: 'POST' // this method issues a POST request
  //   });
  // }
  //
  // /**@ngInject*/
  // function infoService($resource) {
  //   return $resource('http://10.80.54.235:8080/info/:id', {id: '@_id'}, {
  //     update: {
  //       method: 'PUT', // this method issues a PUT request
  //       params: {
  //         id: '@id',
  //         name: '@name',
  //         description: '@description'
  //       }
  //     }
  //   });
  // }
  //
  // /**@ngInject*/
  // function queryInfoService($resource) {
  //   return $resource('http://10.80.54.235:8080/getInfo',
  //     {
  //       query: {
  //         method: 'GET',// this method issues a GET request
  //         params: {
  //           name:''
  //         }
  //       }
  //     });
  // }


})();
