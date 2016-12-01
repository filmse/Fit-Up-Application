(function () {
  'use strict';

  // var API_PREFIX = 'http://localhost:8080';
  var API_PREFIX = 'http://10.80.52.77:8080';

  /** @ngInject */
  angular.module('ngResource+apiPrefix', [
    'ngResource'
  ]).decorate('$resource', function ($delegate) {

    return function decoratedResource() {
      arguments[0] = API_PREFIX + arguments[0];
      return $delegate.apply(this, arguments);
    };

  });
})();