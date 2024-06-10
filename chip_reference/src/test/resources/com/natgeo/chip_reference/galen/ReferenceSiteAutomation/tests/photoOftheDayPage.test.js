load("init.js");
load("pages/photoOfTheDayPage.js");
load("pages/homePage.js");

testOnAllDevices("Photo of the Day Page", "/", function(driver, device){

    var home = new homePage(driver);
    home.waitForIt();
    home.cookiesBtn.click();
    home.photoOftheDay.click();
    new photoOfTheDayPage(driver).waitForIt();
    checkLayout(driver, "specs/photoOfTheDayPage.gspec", device.tags);

});
