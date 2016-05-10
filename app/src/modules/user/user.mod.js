(function (ng) {
    var mod = ng.module('userModule', ['ngCrud']);

    mod.constant('userContext', 'users');

    mod.constant('userModel', {
        fields: [{
            name: 'username',
            displayName: 'Username',
            type: 'String',
            required: true
        },{
            name: 'email',
            displayName: 'Email',
            type: 'String',
            required: true
        },{
            name: 'role',
            displayName: 'Role',
            type: 'String',
            required: true
        },{
            name: 'enabled',
            displayName: 'Enabled',
            type: 'Boolean',
            required: true
        }]
    });
})(window.angular);


