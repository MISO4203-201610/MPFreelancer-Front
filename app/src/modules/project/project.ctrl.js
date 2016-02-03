(function (ng) {
    var mod = ng.module('projectModule');

    mod.controller('projectCtrl', ['CrudCreator', '$scope',
        'projectContext', 'projectModel',
        function (ngCrud, $scope, url, model) {
            ngCrud.extendController({
                name: 'project',
                displayName: 'Project',
                ctrl: this,
                scope: $scope,
                model: model,
                url: url
            });
            this.loadRefOptions();
            this.fetchRecords();
        }]);

    mod.controller('ProjectsexpectedskillsCtrl', ['CrudCreator', '$scope',
        'skillModel', 'skillContext', 'projectContext',
        function (ngCrud, $scope, model, url, parentUrl) {
            ngCrud.extendAggChildCtrl({
                name: 'expectedskills',
                displayName: 'Expectedskills',
                parentUrl: parentUrl,
                listUrl: url,
                ctrl: this,
                scope: $scope,
                model: model
            });
        }]);

    mod.controller('projectListCtrl', ['$scope','Restangular', function ($scope,Restangular) {
            $scope.getProjectList = function () {
            Restangular.all("projectSponsors").getList().then(function (response) {
                $scope.projects = response;
            });

            Restangular.all("users").customGET('me').then(function (response) {
                $scope.user = response;
            });
        };

            //$scope.getProjectList();

        }]);
})(window.angular);
