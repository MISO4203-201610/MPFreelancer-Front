(function (ng) {
    var mod = ng.module('userModule');

    mod.controller('userCtrl', ['CrudCreator', '$scope',
        'userContext', 'userModel',
        function (ngCrud, $scope, url, model) {
            ngCrud.extendController({
                name: 'user',
                displayName: 'User',
                ctrl: this,
                scope: $scope,
                model: model,
                url: url
            });
            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
