describe('Category E2E Testing', function () {

	browser.driver.manage().window().maximize();

    beforeEach(function () {
        browser.addMockModule('ngCrudMock', function () {
            var mod = angular.module('ngCrudMock');
            
            mod.run(['ngCrudMock.mockRecords', function(records){
                
                records['freelancers'] = [];
                records['freelancers'].push(
                    {
                        id: 4,
                        name: 'Ernesto'
                    }
                );
                
                records['agreements'] = [];
                records['agreements'].push(
                    {
                        id: Math.floor(Math.random() * 10000), 
                        name: 'Contrato Uniandes',
                        freelancer: {
                            id: 4,
                            name: "Ernesto"
                        },
                        project: {
                            id: 1,
                            name: "Proyecto Uniandes"
                        }
                    }
                );

            }]);
        });
    });

    it('should render agreements page', function () {
        browser.get('#/agreement');
        expect(element(by.id('agreementTitle')).getText()).toBe('Agreements');
    });

});
