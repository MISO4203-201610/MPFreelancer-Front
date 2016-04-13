(function (ng) {
    var mod = ng.module('agreementModule');

    mod.controller('agreementCtrl', ['CrudCreator', '$scope',
        'agreementContext', 'agreementModel', 'Restangular',
        function (ngCrud, $scope, url, model, Restangular) {
            ngCrud.extendController({
                name: 'agreement',
                displayName: 'Agreement',
                ctrl: this,
                scope: $scope,
                model: model,
                url: url
            });
            this.fetchRecords();
            Restangular.all("agreements").getList().then(function (response) {
                $scope.agreements = response;
            });
        }]);
})(window.angular);
