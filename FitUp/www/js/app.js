(function () {
  'use strict';

  // angular.module('ngResource+apiPrefix', ['ngResource'])
  angular.module('starter.controllers', []);
  angular.module('starter.services', []);
  angular.module('starter', ['ionic',
    'ngCookies',
    'LocalStorageModule',
    'ngResource+apiPrefix',
    'cgBusy',
    'ngRoute',
    'flow',
    'ngResource',
    'ui.router',
    'ngAnimate',
    'starter.controllers',
    'ui.router',
    "ngSanitize",
    "com.2fdevs.videogular",
    "com.2fdevs.videogular.plugins.controls",
    "com.2fdevs.videogular.plugins.overlayplay",
    "com.2fdevs.videogular.plugins.poster",
    'starter.services'])

  /** Run */
    .run(function ($ionicPlatform) {
      $ionicPlatform.ready(function () {
        // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
        // for form inputs)
        if (window.cordova && window.cordova.plugins.Keyboard) {
          cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
          cordova.plugins.Keyboard.disableScroll(true);

        }
        if (window.StatusBar) {
          // org.apache.cordova.statusbar required
          StatusBar.styleDefault();
        }
      });
    })
    /** Run */
    .run(function ($rootScope, $location, $cookies, queryUserService, $timeout, $ionicLoading) {
      var removeErrorMsg = $rootScope.$on('$viewContentLoaded', function () {
        delete $rootScope.error;
      });
      removeErrorMsg();

      $rootScope.hasRole = function (role) {
        if ($rootScope.user == undefined) {
          return false;
        }

        if ($rootScope.user.roles[0].roleName == undefined) {
          return false;
        }
        if ($rootScope.user.roles[0].roleName == role) {
          return $rootScope.user.roles[0].roleName
        }
        return false;
      }

      $rootScope.logout = function () {
        var answer = confirm("Are you sure?");
        if (answer) {
          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
          });
          window.localStorage.clear();
          delete $rootScope.user;
          $timeout(function () {
            $ionicLoading.hide();
          }, 1000);
          window.location.reload();
          // delete $rootScope.authToken
          // $cookies.remove('authToken');
          //$location.path("/")
        }
      }

      // /* Try getting valid user from cookie or go to login page */
      // var originalPath = $location.path();
      // $location.path("/");
      // var authToken = $cookies.get('authToken');
      // if (authToken != undefined) {
      //   $rootScope.authToken = authToken;
      //   UserService.get(function (user) {
      //     $rootScope.user = user;
      //     $location.path(originalPath);
      //   })
      // }
      // $rootScope.initialzed = true;

      /* Try getting valid user from cookie or go to login page */
      var cookie = window.localStorage.getItem("Cookie");
      if (cookie != undefined) {
        delete $rootScope.user;
        //console.log(cookie);
        queryUserService.get({username: cookie}, function (user) {
          window.localStorage.clear();
          $rootScope.user = user;
          $ionicLoading.show({
            template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
          });
          $timeout(function () {
            window.localStorage.setItem("Cookie", user.username);
            $ionicLoading.hide();
            $location.path("app.video");
          }, 1000)

        })
      } else {
        $location.path("app.video");
      }
      $rootScope.initialzed = true;

    })
    /** Run */
    .run(function ($log) {
      //$log.debug('runBlock end');
    })

    /** Config */
    .config(function ($stateProvider, $urlRouterProvider) {
      $stateProvider

        .state('app', {
          url: '/app',
          abstract: true,
          templateUrl: 'templates/menu.html'
        })

        .state('app.aboutUs', {
          url: '/aboutUs',
          views: {
            'menuContent': {
              templateUrl: 'templates/aboutUs.html'
            }
          }
        })

        .state('app.board', {
          url: '/board',
          views: {
            'menuContent': {
              templateUrl: 'templates/Information.html',
              controller: 'showsNewInfoController'
            }
          }
        })

        .state('app.register', {
          url: '/register',
          views: {
            'menuContent': {
              templateUrl: 'templates/register.html',
              controller: 'registerController',
              controllerAs: 'vm'
            }
          }
        })

        .state('app.reQuest', {
          url: '/reQuest',
          views: {
            'menuContent': {
              templateUrl: 'templates/reQuest.html',
              controller: 'addRequestController',
              controllerAs: 'vm'
            }
          }
        })

        .state('app.video', {
          url: '/video',
          views: {
            'menuContent': {
              templateUrl: 'templates/video.html',
              controller: 'ctrlController'
            }
          }
        })

        .state('app.videoExpand', {
          url: '/videoExpand',
          views: {
            'menuContent': {
              templateUrl: 'templates/videoExpand.html'
            }
          }
        })

        .state('app.edituser', {
          url: '/edituser',
          views: {
            'menuContent': {
              templateUrl: 'templates/edituser.html',
              controller: 'editUserController'
            }
          }
        })

        /** For Trainer*/

        .state('app.addVideo', {
          url: '/addVideo',
          views: {
            'menuContent': {
              templateUrl: 'templates/Trainer/addVideo.html',
              controller: 'addVideoController',
              controllerAs: 'vm'
            }
          }
        })

        .state('app.listVideo', {
          url: '/listVideo',
          views: {
            'menuContent': {
              templateUrl: 'templates/Trainer/listVideo.html'
            }
          }
        })

        .state('app.addInformation', {
          url: '/addInformation',
          views: {
            'menuContent': {
              templateUrl: 'templates/Trainer/addInformation.html',
              controller: 'addInfoController',
              controllerAs: 'vm'
            }
          }
        })

        .state('app.editInformation/:id', {
          url: '/editInformation/:id',
          views: {
            'menuContent': {
              templateUrl: 'templates/Trainer/editInformation.html',
              controller: 'editInfoController'
            }
          }
        })

        .state('app.informationExpand/:id', {
          url: '/informationExpand/:id',
          views: {
            'menuContent': {
              templateUrl: 'templates/InformationExpand.html',
              controller: 'editInfoController'
            }
          }
        })

        .state('app.listInformation', {
          url: '/listInformation',
          views: {
            'menuContent': {
              templateUrl: 'templates/Trainer/listInformation.html',
              controller: 'listInfoController'
            }
          }
        })

        .state('app.editVideo/:id', {
          url: '/editVideo/:id',
          views: {
            'menuContent': {
              templateUrl: 'templates/Trainer/editVideo.html',
              controller: 'editVideoController'
            }
          }
        })

        /** For Admin*/

        .state('app.checkConfirm', {
          url: '/checkConfirm',
          views: {
            'menuContent': {
              templateUrl: 'templates/Admin/checkConfirm.html',
              controller: 'shoppingListController'
            }
          }
        })

        .state('app.management', {
          url: '/management',
          views: {
            'menuContent': {
              templateUrl: 'templates/Admin/management.html'
            }
          }
        })

        .state('app.checkRequest', {
          url: '/checkRequest',
          views: {
            'menuContent': {
              templateUrl: 'templates/Admin/checkRequest.html',
              controller: 'listRequestController'
            }
          }
        })

        .state('app.userlist', {
          url: '/userlist',
          views: {
            'menuContent': {
              templateUrl: 'templates/Admin/userlist.html',
              controller: 'listUserController',
              controllerAs: 'vm'
            }
          }
        })

        .state('app.information', {
          url: '/information',
          views: {
            'menuContent': {
              templateUrl: 'templates/Admin/informationlist.html',
              controller: 'showsNewInfoController'
            }
          }
        })

        /** For User*/

        .state('app.payments/:id', {
          url: '/payments/:id',
          views: {
            'menuContent': {
              templateUrl: 'templates/payments.html',
              controller: 'shoppingListController'
            }
          }
        })

        .state('app.payment', {
          url: '/payment',
          views: {
            'menuContent': {
              templateUrl: 'templates/payment.html'
            }
          }
        })

        .state('app.favorite', {
          url: '/favorite',
          views: {
            'menuContent': {
              templateUrl: 'templates/favorite.html'
            }
          }
        })

        .state('app.login', {
          url: '/login',
          views: {
            'menuContent': {
              templateUrl: 'templates/login.html'
            }
          }
        });

      // if none of the above states are matched, use this as the fallback
      $urlRouterProvider.otherwise('/app/video');
    })
    /** Config */
    .config(configCompilerProvider)
    /** Config */
    .config(configFlowFactoryProvider)
    /** Config */
    .config(configFailRequestRedirect);

  /** @ngInject */
  function configFlowFactoryProvider(flowFactoryProvider) {
    flowFactoryProvider.defaults = {
      target: 'app.video',
      permanentErrors: [404, 500, 501],
      maxChunkRetries: 1,
      chunkSize: 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 10241024 * 2014 * 1024 * 1024 * 1024 * 1024 * 1024,
      progressCallbacksInterval: 3000,
      testChunks: false,
      chunkRetryInterval: 5000,
      simultaneousUploads: 4,
      singleFile: false
    };
    // flowFactoryProvider.on('catchAll', function ($log) {
    //   console.log('catchAll', arguments);
    // });
    // Can be used with different implementations of Flow.js
    // flowFactoryProvider.factory = fustyFlowFactory;
  }

  /** @ngInject */
  function configCompilerProvider($compileProvider) {
    $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|file|chrome-extension):/);
    $compileProvider.imgSrcSanitizationWhitelist(/^\s*(https?|local|data):/);
  }

  /** @ngInject */
  function configFailRequestRedirect($locationProvider, $httpProvider) {
    /* Register error provider that shows message on failed requests or redirect to login page on
     * unauthenticated requests */
    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
      return {
        'responseError': function (rejection) {
          var status = rejection.status;
          var config = rejection.config;
          var method = config.method;
          var url = config.url;

          if (status == 401) {
            alert("Wrong username or password")
            $location.path("app.video");
          } else {
            $rootScope.error = method + " on " + url + " failed with status " + status;
          }
          return $q.reject(rejection);
        }
      }
    });

    /* Registers auth token interceptor, auth token is either passed by header or by query parameter
     * as soon as there is an authenticated user */
    var exampleAppConfig = {
      /* When set to false a query parameter is used to pass on the auth token.
       * This might be desirable if headers don't work correctly in some
       * environments and is still secure when using https. */

      useAuthTokenHeader: true
    };

    $httpProvider.interceptors.push(function ($q, $rootScope) {
      return {
        'request': function (config) {
          if (angular.isDefined($rootScope.authToken)) {
            var authToken = $rootScope.authToken;
            if (exampleAppConfig.useAuthTokenHeader) {
              config.headers['X-Auth-Token'] = authToken;
            } else {
              config.url = config.url + "?token=" + authToken;
            }
          }
          return config || $q.when(config);
        }
      }
    })
  }

})();
