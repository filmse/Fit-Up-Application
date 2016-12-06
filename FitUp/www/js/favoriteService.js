/**
 * Created by Film on 3/12/2559.
 */
(function () {
  'use strict';
  angular.module('starter.services')

    .factory('addToFavoriteService', addToFavoriteService)
    .factory('getToFavoriteService', getToFavoriteService);
  // .factory('getToFavoriteIdService', getToFavoriteIdService);

  /** @ngInject */
  function addToFavoriteService($resource) {
    return $resource('/addToFavorite', {}, {
      // authenticate: {
      method: 'POST'
      // params: {'action': 'authenticate'},
      // header: {'Content-Type': 'application/x-www-form-urlencoded'}
      //}
    })
  }

  /** @ngInject */
  function getToFavoriteService($resource) {
    return $resource('/getToFavorite',
      {
        query: {
          method: 'GET' // this method issues a GET request
          // params: {
          //   name: ''
          // }
        }
      });
  }

  // /** @ngInject */
  // function getToFavoriteIdService($resource) {
  //   return $resource('/getToFavoriteIdService/:id', {id: '@_id'}, {
  //     update: {
  //       method: 'PUT', // this method issues a PUT request
  //       params: {
  //         id: '@id'
  //       }
  //     }
  //   });
  // }

})();
