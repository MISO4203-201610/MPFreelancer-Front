(function (ng) {
    var mod = ng.module('roleModule', ['ngCrud']);
    mod.controller('roleCtrl', ['$rootScope', 'Restangular', function ($rootScope, Restangular) {

        $rootScope.auth = function () {
                Restangular.all("users").customGET('me').then(function (response) {
                    if (response == null) {
                        $rootScope.category = false;
                        $rootScope.project = false;
                        $rootScope.projectSponsor = false;
                        $rootScope.skill = false;
                        $rootScope.freelancer = false;
                        $rootScope.status = false;
                        $rootScope.projectSponsorProfile = false;
                        $rootScope.invitations = false;
                        $rootScope.candidates = false;
                        $rootScope.freelancerDetails = false;
                        $rootScope.freelancerProfile = false;
                        $rootScope.projectSprint = true;
                        $rootScope.agreement = false;
                    } else {
                        var roles = $rootScope.roles = response.roles;
                        var isFreelance = false;
                        if (roles.indexOf("freelancer") !== -1) {
                            isFreelance = true;
                            $rootScope.skill = true;
                            $rootScope.curriculum = true;
                            $rootScope.projectSprint = true;
                            $rootScope.freelancer = true;
                            $rootScope.freelancerProfile = true;
                            $rootScope.category = false;
                            $rootScope.project = false;
                            $rootScope.projectSponsor = false;
                            $rootScope.projectSponsorProfile = false;
                            $rootScope.invitations = false;
                            $rootScope.candidates = false;
                            $rootScope.freelancerDetails = false;
                            $rootScope.status = false;
                            $rootScope.agreement = true;
                        }
                        if (roles.indexOf("projectSponsor") !== -1) {
                            $rootScope.category = true;
                            $rootScope.project = true;
                            $rootScope.projectSponsor = true;
                            $rootScope.projectSponsorProfile = true;
                            $rootScope.invitations = true;
                            $rootScope.candidates = true;
                            $rootScope.freelancerDetails = true;
                            $rootScope.skill = true;
                            if (isFreelance === false) {
                                $rootScope.freelancer = false;
                                $rootScope.freelancerProfile = false;
                            }
                            $rootScope.status = false;
                            $rootScope.projectSprint = true;
                            $rootScope.agreement = false;
                        }
                        if (roles.indexOf("admin") !== -1) {
                            $rootScope.category = true;
                            $rootScope.project = false;
                            $rootScope.projectSponsor = true;
                            $rootScope.skill = true;
                            $rootScope.freelancer = true;
                            $rootScope.status = true;
                            $rootScope.projectSponsorProfile = false;
                            $rootScope.invitations = false;
                            $rootScope.candidates = false;
                            $rootScope.freelancerDetails = false;
                            $rootScope.freelancerProfile = false;
                            $rootScope.projectSprint = true;
                            $rootScope.agreement = false;
                        }
                    }
                });
            };
        $rootScope.auth();
        $rootScope.$on('logged-in', function () {

            $rootScope.auth();
        });

        $rootScope.$on('logged-out', function () {

            $rootScope.auth();
        });

    }]);
})(window.angular);




