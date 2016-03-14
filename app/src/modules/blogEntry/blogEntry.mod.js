/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module('blogEntryModule', ['ngCrud']);

    mod.constant('blogEntryContext', 'blogEntrys');

    mod.constant('blogEntryModel', {
        fields: [{
                name: 'title',
                displayName: 'title',
                type: 'String',
                required: true
            }, {
                name: 'subject',
                displayName: 'subject',
                type: 'String',
                required: true
            }, {
                name: 'description',
                displayName: 'description',
                type: 'String',
                required: true
            }, {
                name: 'content',
                displayName: 'content',
                type: 'String',
                required: true
            }, {
                name: 'publicationDate',
                displayName: 'publicationDate',
                type: 'Date',
                required: true
            }]});
})(window.angular);
