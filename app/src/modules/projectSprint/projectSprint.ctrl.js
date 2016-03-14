/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module('projectSprintModule');

    mod.controller('projectSprintCtrl', ['CrudCreator', '$scope',
        'projectSprintContext', 'projectSprintModel',
        function (ngCrud, $scope, url, model) {
            ngCrud.extendController({
                name: 'projectSprint',
                displayName: 'Project Sprints',
                ctrl: this,
                scope: $scope,
                model: model,
                url: url
            });
            this.fetchRecords();
        }]);
})(window.angular);
