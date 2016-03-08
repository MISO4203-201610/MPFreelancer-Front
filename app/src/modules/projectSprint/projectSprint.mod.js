/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module('projectSprintModule', ['ngCrud']);

    mod.constant('projectSprintContext', 'sprints');

    mod.constant('projectSprintModel', {
        fields: [{
                name: 'name',
                displayName: 'Nombre',
                type: 'String',
                required: true
            }, {
                name: 'description',
                displayName: 'Descripcion',
                type: 'String',
                required: true
            }, {
                name: 'price',
                displayName: 'Price',
                type: 'Integer',
                required: true
            }, {
                name: 'startDate',
                displayName: 'Fecha de inicio',
                type: 'Date',
                required: true
            },{
                name: 'deadLine',
                displayName: 'Dead Line',
                type: 'Date',
                required: true
            }]});
})(window.angular);
