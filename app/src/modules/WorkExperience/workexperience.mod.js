(function (ng) {
    var mod = ng.module('workExperienceModule', ['ngCrud']);

    mod.constant('workExperienceContext', 'experiences');

    mod.constant('workExperienceModule', {
        fields: [{
                name: 'projectName',
                displayName: 'Project Name',
                type: 'String',
                required: true
            }, {
                name: 'projectDescription',
                displayName: 'Description',
                type: 'String',
                required: true
            }, {
                name: 'startDate',
                displayName: 'Start Date',
                type: 'Date',
                required: true
            }, {
                name: 'endDate',
                displayName: 'End Date',
                type: 'Date',
                required: true
            }, {
                name: 'sponsorCompany',
                displayName: 'Sponsor Company',
                type: 'String',
                required: true
            },{
                name: 'price',
                displayName: 'Price',
                type: 'Integer',
                required: true
            },{
                name: 'rate',
                displayName: 'Rate',
                type: 'Double',
                required: true
            },{
                name: 'url',
                displayName: 'URL',
                type: 'String',
                required: true
            }


        ]});
})(window.angular);



