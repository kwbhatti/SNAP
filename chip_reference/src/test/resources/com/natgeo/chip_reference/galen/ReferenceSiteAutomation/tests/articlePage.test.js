load("init.js");
load("pages/articlePage.js");
load("pages/homePage.js");

testOnAllDevices("Article Page", "/", function(driver, device){

    var home = new homePage(driver);
    home.waitForIt();
    home.cookiesBtn.click();
    home.articlePromocard.click();
    new articlePage(driver).waitForIt();
    checkLayout(driver, "specs/articlePage.gspec", device.tags);

});
