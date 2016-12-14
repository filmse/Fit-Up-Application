(function () {
  'use strict';
  angular.module('starter.services')

    .factory('userService', userService)
    .factory('queryUserService', queryUserService)
    .factory('UserService', UserService)
    .factory('ChangeRole', ChangeRole);

  /** @ngInject */
  function UserService($resource) {
    return $resource('/register/:action', {}, {
      // authenticate: {
        method: 'POST'
      //   params: {'action': 'authenticate'},
      //   header: {'Content-Type': 'application/x-www-form-urlencoded'}
      // }
    })
  }
  /** @ngInject */
  function userService($resource) {
    return $resource('/customer/:id', {id: '@_id'}, {
      update: {
        method: 'PUT', // this method issues a PUT request
        params: {
          id: '@id',
          username: '@username',
          email: '@email',
          password: '@password',
          passSet: '@passSet'
          // confirmEmail: '@confirmEmail',
          // confirmTime: '@confirmTime',
          // confirmMoney: '@confirmMoney',
          // confirmSecretId: '@confirmSecretId'
        }
      }
    });
  }
  /** @ngInject */
  function queryUserService($resource) {
    return $resource('/customer/login',
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
  function ChangeRole($resource) {
    return $resource('/customerRole/:id', {id: '@_id'}, {
      update: {
        method: 'PUT', // this method issues a PUT request
        params: {
          roleSelected: '@roleSelected'
        }
      }
    });
  }

})();
