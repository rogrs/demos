  var app = angular.module("MyApp", []);

        app.controller("PostsCtrl", function($scope, $http) {
          $http.get('rs/v1/users').
            success(function(data, status, headers, config) {
              $scope.posts = data;
            }).
            error(function(data, status, headers, config) {
            	alert( "Falha: " + JSON.stringify({data: data}));
            });
        });

        