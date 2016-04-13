(function (ng) {
    //https://github.com/wprl/baucis/blob/master/examples/angular-example-restangular.html
    //http://stackoverflow.com/questions/18585010/restangular-post-form-data-in-json-format-in-angular-js
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
            var freelancerResource = Restangular.all("freelancers");
            freelancerResource.customGET('current').then(function (response) {
                $scope.freelancer = response;
                var freelancerId = response.id;
                console.log('consultando agreements del freelancer' + freelancerId);
                var resource = Restangular.all("agreements/" + freelancerId + "/agreementsStatus1");
                resource.getList().then(function (agreementResponse) {
                    $scope.agreements = agreementResponse;
                });
            });

            $scope.formData = {};
            $scope.add = function () {
                console.log('proyecto aceptado');
                console.log($scope.formData.proyectoSeleccionado);
                console.log($scope.formData.monto);
                console.log($scope.freelancer.id);
                //var postRequest = Restangular.all('accounts');
                //resource.post($scope.formData);
            };
            $scope.cancel = function () {
                console.log('cancelar');
                //                resource.post($scope.formData).then(function (newResource) {
                //                    $scope.agreements.push(newResource);
                //                });
            };
        }]);
})(window.angular);
