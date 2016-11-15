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
    return $resource('http://localhost:8080/passSet', {
      method: 'POST' // this method issues a POST request
    });
  }

  /**@ngInject*/
  function querypassSetService($resource) {
    return $resource('http://localhost:8080/passSetList',
      {
        query: {
          method: 'GET',// this method issues a GET request
          params: {
            name: ''
          }
        }
      });
  }

  // /**@ngInject*/
  // function PassSetService($resource) {
  //   return $resource('http://10.80.54.229:8080/passSet', {
  //     method: 'POST' // this method issues a POST request
  //   });
  // }
  //
  // /**@ngInject*/
  // function querypassSetService($resource) {
  //   return $resource('http://10.80.54.229:8080/passSetList',
  //     {
  //       query: {
  //         method: 'GET',// this method issues a GET request
  //         params: {
  //           name: ''
  //         }
  //       }
  //     });
  // }

})();
