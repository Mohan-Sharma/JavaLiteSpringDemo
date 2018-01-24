(function (angular) {
    "use strict";
    var app= angular.module('javaLiteApp', []);

    app.factory("studentFactory", function($http){
        return {
            allStudents: function(){
                return $http.get("/javalitespring/student/allstudents");
            },
             studentByRollNumber: function(rollNumber){
                            return $http.get("/javalitespring/student/findbyrollnumber?rollNumber=" + rollNumber);
             }
        }
    });

    app.controller('javaLiteController', ['$scope', 'studentFactory', function($scope, studentFactory) {
        $scope.students = [];
        studentFactory
            .allStudents()
            .then(function(response){
                    $scope.students = response.data;
                 }, function(error){});
        $scope.name = "Voldemort";
    }])
})(angular);