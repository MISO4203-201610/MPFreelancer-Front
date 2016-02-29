/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module('artifactModule');

    mod.controller('artifactCtrl', ['CrudCreator', '$scope',
        'artifactContext', 'artifactModel',
        function (ngCrud, $scope, url, model) {
            ngCrud.extendController({
                name: 'artifact',
                displayName: 'Artefactos',
                ctrl: this,
                scope: $scope,
                model: model,
                url: url
            });
            this.fetchRecords();
        }]);
})(window.angular);
