(function () {
  'use strict';
  angular.module('starter.services')

    .factory('userService', userService)
    .factory('queryUserService', queryUserService)
    .factory('UserService', UserService)
    .factory('ChangeRole', ChangeRole);

  /** @ngInject */
  function UserService($resource) {
    return $resource('http://localhost:8080/register/:action', {}, {
      // authenticate: {
      method: 'POST'
      // params: {'action': 'authenticate'},
      // header: {'Content-Type': 'application/x-www-form-urlencoded'}
      //}
    })
  }

  /** @ngInject */
  function userService($resource) {
    return $resource('http://localhost:8080/customer/:id', {id: '@_id'}, {
      update: {
        method: 'PUT', // this method issues a PUT request
        params:{
          id: '@id',
          username:'@username',
          email: '@email',
          password: '@password',
          passSet: '@passSet'
        }
      }
    });
  }

  /** @ngInject */
  function queryUserService($resource) {
    return $resource('http://localhost:8080/customer/login',
      {
        query: {
          method: 'GET', // this method issues a GET request
          params: {
            name:''
          }
        }
      });
  }

  /** @ngInject */
  function ChangeRole($resource) {
    return $resource('http://localhost:8080/customerRole/:id', {id: '@_id'}, {
      update: {
        method: 'PUT', // this method issues a PUT request
        params: {
          roleSelected: '@roleSelected'
        }
      }
    });
  }

})();
