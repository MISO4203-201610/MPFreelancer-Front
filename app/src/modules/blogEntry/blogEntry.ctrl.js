/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module('blogEntryModule');

    mod.controller('blogEntryCtrl', ['CrudCreator', '$scope',
        'blogEntryContext', 'blogEntryModel',
        function (ngCrud, $scope, url, model) {
            ngCrud.extendController({
                name: 'blogEntry',
                displayName: 'BlogEntry',
                ctrl: this,
                scope: $scope,
                model: model,
                url: url
            });
            this.fetchRecords();
        }]);
})(window.angular);
