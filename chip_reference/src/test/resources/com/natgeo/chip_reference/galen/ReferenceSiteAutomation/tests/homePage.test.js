load("init.js");
load("pages/homePage.js");

testOnAllDevices("Home page", "/", function(driver, device){
    new homePage(driver).waitForIt();
    checkLayout(driver, "specs/homePage.gspec", device.tags);
});


/*
forAll(devices, function(){
    test("Home page test on ${deviceName} on ${size} size", function(device){
    // this is the body of the test

    // Instantiating the WebDriver, loading the page and changing the size of the browser window
    var driver = createDriver("http://chip-dev-elb-1927620335.us-east-1.elb.amazonaws.com/", device.size);
    

    // Checking layout on the page
    checkLayout(driver, "specs/home-page.spec", "desktop");

    // Quiting the browser
    driver.close();
    driver.quit();

    });
});

test("Home page test", function () {
    // this is the body of the test

    // Instantiating the WebDriver, loading the page and changing the size of the browser window
    var driver = createDriver("http://chip-dev-elb-1927620335.us-east-1.elb.amazonaws.com/" , "1024x768");
    

    // Checking layout on the page
    checkLayout(driver, "specs/home-page.spec", "desktop");

    // Quiting the browser
    driver.quit();
});*/