(function (ng) {
    var mod = ng.module('artifactModule', ['ngCrud']);

    mod.constant('artifactContext', 'artifacts');

    mod.constant('artifactModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'description',
                displayName: 'Description',
                type: 'String',
                required: true
            }, {
                name: 'path',
                displayName: 'Path',
                type: 'String',
                required: true
            }]});
})(window.angular);
