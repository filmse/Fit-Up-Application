/**
 * Created by Film on 23/9/2559.
 */
(function () {
  'use strict';
  angular.module('starter.services')

    .factory('VideoService', VideoService)
    .factory('videoService', videoService)
    .factory('getToFavoriteIdService', getToFavoriteIdService)
    .factory('getToFavoriteService', getToFavoriteService)
    .factory('addToFavoriteService', addToFavoriteService)
    .factory('queryVideoService', queryVideoService);

  /** @ngInject */
  function VideoService($resource) {
    return $resource('http://localhost:8080/video', {}, {
      method: 'POST'
    })
  }

  /** @ngInject */
  function videoService($resource) {
    return $resource('http://localhost:8080/video/:id', {id: '@_id'}, {
      update: {
        method: 'PUT', // this method issues a PUT request
        params: {
          id: '@id',
          name: '@name',
          description: '@description',
          price: '@price'
        }
      }
    });
  }

  /** @ngInject */
  function queryVideoService($resource) {
    return $resource('http://localhost:8080/videoName',
      {
        query: {
          method: 'GET', // this method issues a GET request
          params: {
            name: ''
          }
        }
      });
  }

  /** @ngInject */
  function addToFavoriteService($resource) {
    return $resource('http://localhost:8080/addToFavorite', {}, {
      // authenticate: {
      method: 'POST'
      // params: {'action': 'authenticate'},
      // header: {'Content-Type': 'application/x-www-form-urlencoded'}
      //}
    })
  }

  /** @ngInject */
  function getToFavoriteService($resource) {
    return $resource('http://localhost:8080/getToFavorite',
      {
        query: {
          method: 'GET' // this method issues a GET request
          // params: {
          //   name: ''
          // }
        }
      });
  }

  /** @ngInject */
  function getToFavoriteIdService($resource) {
    return $resource('http://localhost:8080/getToFavoriteIdService/:id', {id: '@_id'}, {
      update: {
        method: 'PUT', // this method issues a PUT request
        params: {
          id: '@id'
        }
      }
    });
  }

})();
