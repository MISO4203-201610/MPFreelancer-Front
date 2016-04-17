describe('Freelancer E2E Testing', function () {

	browser.driver.manage().window().maximize();

	var nameVarTest = 'Val' + Math.floor(Math.random() * 10000);
	var rateVarTest = Math.floor(Math.random() * 10000).toString();
	var pictureVarTest = 'Val' + Math.floor(Math.random() * 10000);

    beforeEach(function () {
        browser.addMockModule('ngCrudMock', function () {
            var mod = angular.module('ngCrudMock');

            mod.run(['ngCrudMock.mockRecords', function(records){
                records['freelancers'] = [];
                records['freelancers'].push({id: Math.floor(Math.random() * 10000), name: 'nombrePrueba'});

            }]);
        });
    });

    it('should read one freelancer', function () {
        browser.get('#/freelancer');
        expect(element(by.id('0-name')).getText()).toBe('nombrePrueba');
    });

    it('should edit one freelancer', function () {
        element(by.id('0-edit-btn')).click();

        element(by.id('name')).clear().sendKeys('New' + nameVarTest);
	
        element(by.id('save-freelancer')).click();

        expect(element(by.id('0-name')).getText()).toBe('New' + nameVarTest);
    });

    it('should delete the freelancer', function () {
        element(by.id('0-delete-btn')).click();
        expect(element.all(by.id('0-name')).count()).toEqual(0);
        expect(element.all(by.id('0-rate')).count()).toEqual(0);
        expect(element.all(by.id('0-bithday')).count()).toEqual(0);
        expect(element.all(by.id('0-picture')).count()).toEqual(0);
    });
});
