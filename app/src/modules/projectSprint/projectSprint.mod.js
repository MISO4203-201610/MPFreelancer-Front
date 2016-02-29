/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module('projectSprintModule', ['ngCrud']);

    mod.constant('projectSprintContext', 'projectSprints');

    mod.constant('projectSprintModel', {
        fields: [{
                name: 'profile',
                displayName: 'Profile',
                type: 'String',
                required: true
            }, {
                name: 'identification',
                displayName: 'Identification',
                type: 'String',
                required: true
            }, {
                name: 'email',
                displayName: 'Email',
                type: 'String',
                required: true
            }, {
                name: 'mobile',
                displayName: 'Mobile',
                type: 'String',
                required: true
            }]});
})(window.angular);
