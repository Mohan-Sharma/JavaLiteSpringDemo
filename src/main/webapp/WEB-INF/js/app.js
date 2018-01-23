(function (angular) {
    "use strict";
    var app= angular.module('javaLiteApp', []);

    app.factory("studentFactory", function($http){
        return {
            allStudents: function(){
                $http
                    .get("/beginningjavalite/student/allstudents")
                    .success(function(response, status, headers, config) {
                    })
                    .error(function(response, status, headers, config){});
            }
        }
    });

    app.controller('javaLiteController', ['$scope', 'studentFactory', function($scope, studentFactory) {
        $scope.students = [];
        studentFactory.allStudents().then(function(response) {
            $scope.students = response;
        })
        $scope.name = "Voldemort";
    }])
})(angular);