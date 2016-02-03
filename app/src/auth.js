(function (ng) {
    var mod = ng.module('roleModule', ['ngCrud']);
    mod.controller('roleCtrl', ['$rootScope','Restangular', function ($rootScope,Restangular) {

        $rootScope.auth = function () {
            Restangular.all("users").customGET('me').then(function (response) {
                if (response == null) {
                    $rootScope.category = false;
                    $rootScope.project = false;
                    $rootScope.projectSponsor = false;
                    $rootScope.skill = false;
                    $rootScope.freelancer = false;
                    $rootScope.status = false;
                }else {
                    var roles = $rootScope.roles = response.roles;
                    var isFreelance = false;
                    for (var i = 0; i < roles.length; i++) {
                        switch (roles[i]) {
                            case 'freelancer':
                                isFreelance = true;
                                $rootScope.skill = true;
                                $rootScope.freelancer = true;
                                $rootScope.freelancerProfile = true;
                                $rootScope.category = false;
                                $rootScope.project = false;
                                $rootScope.projectSponsor = false;
                                $rootScope.projectSponsorProfile = false;
                                $rootScope.status = false;
                                break;
                            case 'projectSponsor':
                                $rootScope.category = true;
                                $rootScope.project = true;
                                $rootScope.projectSponsor = true;
                                $rootScope.projectSponsorProfile = true;
                                $rootScope.skill = true;
                                if (isFreelance === false) {
                                    $rootScope.freelancer = false;
                                    $rootScope.freelancerProfile = false;
                                }
                                $rootScope.status = false;
                                break;
                            case 'admin':
                                $rootScope.category = true;
                                $rootScope.project = true;
                                $rootScope.projectSponsor = true;
                                $rootScope.skill = true;
                                $rootScope.freelancer = true;
                                $rootScope.status = true;
                                $rootScope.projectSponsorProfile = false;
                                $rootScope.freelancerProfile = false;
                                break;
                        }
                    }
                }


            });
        };
        $rootScope.auth();
        $rootScope.$on('logged-in', function () {

            $rootScope.auth();
        });

    }]);
})(window.angular);




