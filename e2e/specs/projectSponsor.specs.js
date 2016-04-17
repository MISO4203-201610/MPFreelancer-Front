describe('ProjectSponsor E2E Testing', function () {

	browser.driver.manage().window().maximize();

	var nameVarTest = 'Val' + Math.floor(Math.random() * 10000);
	var companyVarTest = 'Val' + Math.floor(Math.random() * 10000);
	var pictureVarTest = 'Val' + Math.floor(Math.random() * 10000);

    beforeEach(function () {
        browser.addMockModule('ngCrudMock', function () {
            var mod = angular.module('ngCrudMock');

            mod.run(['ngCrudMock.mockRecords', function(records){
                records['projectSponsors'] = [];
                records['projectSponsors'].push({id: Math.floor(Math.random() * 10000), name: 'nombrePrueba'});

            }]);
        });
    });

    it('should read one projectSponsor', function () {
        browser.get('#/projectSponsor');
        expect(element(by.id('0-name')).getText()).toBe('nombrePrueba');
    });

    it('should edit one projectSponsor', function () {
        element(by.id('0-edit-btn')).click();

        element(by.id('name')).clear().sendKeys('New' + nameVarTest);

        element(by.id('save-projectSponsor')).click();

        expect(element(by.id('0-name')).getText()).toBe('New' + nameVarTest);
    });

    it('should delete the projectSponsor', function () {
        element(by.id('0-delete-btn')).click();
        expect(element.all(by.id('0-name')).count()).toEqual(0);
        expect(element.all(by.id('0-company')).count()).toEqual(0);
        expect(element.all(by.id('0-picture')).count()).toEqual(0);
    });
});
