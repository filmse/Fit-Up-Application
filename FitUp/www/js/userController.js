(function () {
  'use strict';
  angular.module('starter.controllers')

  /** @ngInject */
    .controller('LoginController', function ($ionicBackdrop, $scope, $rootScope, $location, $cookieStore, queryUserService, $state, $route, $ionicLoading, $timeout) {

      function serializeData(data) {
        if (!angular.isObject(data)) {
          return ((data == null) ? "" : data.toString());
        }
        var buffer = [];
        for (var name in data) {
          if (!data.hasOwnProperty(name)) {
            continue;
          }
          var value = data[name];
          buffer.push(
            encodeURIComponent(name) + "=" + encodeURIComponent((value == null) ? "" : value)
          );
        }
        var source = buffer.join("&").replace(/%20/g, "+");
        return (source);
      }

      $scope.login = function () {
        $ionicLoading.show({
          template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
        });
        queryUserService.get({username: $scope.username, password: $scope.password}, function (user) {

          if (user.password == $scope.password) {
            $rootScope.user = user;
            window.localStorage.setItem("Cookie", user.username);
            $timeout(function () {
              $ionicLoading.hide();
            }, 3000)
            // alert("Success!")
            $state.go('app.video');
            $ionicLoading.show({
              template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
            });
            console.log("Password is matched")
          } else {
            console.log("Invalid Password")
            alert("Wrong username or password!")
          }
        })
        $state.go('app.login');
        $ionicLoading.hide()
      }
    })
    /** @ngInject */
    .controller('registerController', function ($scope, $http, $rootScope, UserService, $ionicLoading, $timeout, $state) {

      var vm = this;
      vm.user = {};
      vm.register = function (flowFiles) {
        UserService.save(vm.user, function (data) {
          var userId = data.id;
          console.log(vm.user.username);

          if (vm.user.username == undefined) {
            alert("Null");
            $state.go('app.register');
          } else {
            flowFiles.opts.target = 'http://10.80.52.77:8080/userImage/add';
            flowFiles.opts.testChunks = false;
            flowFiles.opts.query = {userId: userId};
            flowFiles.upload();
            $rootScope.addSuccess = true;
            $ionicLoading.show({
              template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
            });
            $timeout(function () {
              $ionicLoading.hide();
            }, 3000)
            $state.go('app.login');
          }
        })
      }

    })
    /** @ngInject */
    .controller('listUserController', function ($scope, queryUserService, userService, $rootScope, $ionicLoading, $timeout) {

      $scope.queryPromise = userService.query(function (data) {
        $ionicLoading.show({
          template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
        });
        $timeout(function () {
          $ionicLoading.hide();
        }, 3000)
        $rootScope.users = data;
      }).$promise;

      $scope.searchUser = function (name) {
        queryUserService.query({name: name}, function (data) {
          $rootScope.users = data;
        });
      }

      $scope.deleteUser = function (id) {
        console.log(id)
        var answer = confirm("Are you sure?");
        if (answer) {
          userService.delete({id: id}, function () {
            $rootScope.deleteSuccess = true;
            $ionicLoading.show({
              template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
            });
            $timeout(function () {
              $ionicLoading.hide();
            }, 3000)
            //location.reload();
          })
        }
      }

      $scope.deleteUsers = function (id) {
        var answer = confirm("Are you sure?");
        if (answer) {
          userService.delete({id: id}, function () {
            $rootScope.deleteSuccess = true;
            $ionicLoading.show({
              template: '<ion-spinner class="spinner-spiral"></ion-spinner><p style="color:white">Loading...</p>'
            });
            $timeout(function () {
              $ionicLoading.hide();
            }, 3000)
            window.localStorage.clear()
            window.location.reload();
          })
        }
      }


    })
    /** @ngInject */
    .controller('editUserController', function ($route, $routeParams, $location, $rootScope, $scope, userService, $http, $state) {

      $scope.editUser = function (flowFiles) {
        var answer = confirm("Are you sure?");
        if (answer) {
          userService.update({id: $scope.user.id}, $scope.user, function () {

            var userId = $scope.user.id;
            console.log(userId)
            // set location

            flowFiles.opts.target = 'http://10.80.52.77:8080/userImage/add';
            flowFiles.opts.testChunks = false;
            flowFiles.opts.query = {userId: userId};
            flowFiles.upload();
          });
          $state.go('app.video')
        }
      };

      $scope.deleteImage = function (id) {
        var answer = confirm("Change your image?");
        if (answer) {
          $http.delete("http://10.80.52.77:8080/userImage/remove?imageId=" + id + "&userId=" + $scope.user.id).success(function (data) {
            $scope.user = data;
            // window.location.reload();
          });
        }
      }

    })
    /** @ngInject */
    .controller('selectController', function ($scope, userService, $rootScope, ChangeRole) {

      $scope.roleName = {
        roleSelected: null, availableOptions: [
          {id: 'admin', name: 'Admin'},
          {id: 'trainer', name: 'Trainer'},
          {id: 'member', name: 'Member'}
        ],
      };

      $scope.changeRole = function () {
        console.log("----------finished------------")
        ChangeRole.update({id: $scope.user.id}, $scope.roleName, function () {
          $rootScope.addSuccess = true;
          alert("success!")
          window.location.reload();
        });
      }

    })

})();
