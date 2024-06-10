importClass(org.openqa.selenium.interactions.Actions);

this.homePage = function(driver){
    GalenPages.extendPage(this, driver, "Home Page", {
        navBar: ".ng-contextual-navigation"
    
    },{

        cookiesBtn: ".Cookies__footer__accept___1RPL-",
        articlePromocard: ".mt_div-link",
        photoOftheDay: ".PhotoOfTheDay__gallery___3kwHb"
    });
}