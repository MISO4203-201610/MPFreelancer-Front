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
                var resource = Restangular.all("agreements/" + freelancerId + "/agreementsFreelancer");
                resource.getList().then(function (agreementResponse) {
                    var arrayLength = agreementResponse.length;
                    for (var i = 0; i < arrayLength; i++) {
                        var agreement = agreementResponse[i];
                        switch (agreement.status) {
                            case 1:
                                agreement.status = 'Invited';
                                break;
                            case 2:
                                agreement.status = 'Accepted';
                                break;
                            case 3:
                                agreement.status = 'Rejected';
                                break;
                            case 4:
                                agreement.status = 'Selected';
                                break;
                            default:
                                agreement.status = 'Unknown';
                                break;
                        }
                    }
                    $scope.agreements = agreementResponse;
                });
            });
            $scope.formData = {};
            $scope.add = function () {
                var agreementId = $scope.formData.proyectoSeleccionado;
                var monto = $scope.formData.monto;
                console.log('proyecto aceptado');
                //Restangular.all("agreements/" + agreementId + "/" + monto + "/agreementsAceptd");
                Restangular.all("agreements/" + agreementId + "/" + monto + "/agreementsAcept").customPUT();

            };
            $scope.cancel = function () {
                var agreementId = $scope.formData.proyectoSeleccionado;
                Restangular.all("agreements/" + agreementId + "/agreementsReject").customPUT();
            }
            ;
        }]);
})(window.angular);
