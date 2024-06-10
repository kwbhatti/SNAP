var domain = "chip-dev-elb-1927620335.us-east-1.elb.amazonaws.com";
//var domain = "chip.dev.nationalgeographic.com:8888"
var devices = {

    desktop:{
        size: "1280x800",
        deviceName:"desktop"
    },

    tablet: {
        size: "1024x768",
        deviceName: "tablet"
    },
    mobile: {
        size: "400x700",
        deviceName: "mobile"
    },
};

var TEST_USER = {
    username: "chip",
    password: "CHIPPOC2017"
};

function openDriver(url, size){
    var driver = createDriver(null, size);
    session.put("driver", driver);

    // Checking if url is actually a uri or a full url
    if (url != null) {
        if (url.indexOf("http://") != 0 && url.indexOf("https://") != 0) {
            url = "http://" + domain + url;
        }
        driver.get(url);
    }
    else {
        driver.get(domain);
    }
    return driver;
}

afterTest(function (test){
    var driver = session.get("driver");
    if (driver != null){
        if (test.isFailed()){
            session.report().info("Screenshot").withAttachment("Screenshot", takeScreenshot(driver));
        }
       driver.quit();
    }
});

function _test(testNamePrefix, url, callback){
    test(testNamePrefix + " on ${deviceName} device, size: ${size}", function (device){
        var driver = openDriver(url, device.size);
        callback.call(this, driver, device);
    });
}

function testOnAllDevices(testNamePrefix, url, callback){
    forAll(devices, function (){
        _test( testNamePrefix, url, callback);
    });
}

function testOnDevice(testNamePrefix, url, callback){
    forOnly(devies, function (){
        _test( testNamePrefix, url, callback);
    });
}

(function (export) {
    export.devices = devices;
    export.openDriver = openDriver;
    export.testOnAllDevices = testOnAllDevices;
    export.TEST_USER = TEST_USER;
})(this);