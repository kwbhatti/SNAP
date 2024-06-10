
//require('dotenv').config()

/*@@ set 
    sauceKey        Danigeme15@
    sauceUser       daniel.alvarez@wizeline.com
    gridLogin       ${sauceUser}:${sauceKey}
    gridUrl         http://${gridLogin}@ondemand.saucelabs.com:80/wd/hub
    website         http://chip-dev-elb-1927620335.us-east-1.elb.amazonaws.com/
@@ table browsers
| browserName   | gridArgs                                                               |
| Safari on Mac | --browser "safari" --version 6   --dc.platform "OS X 10.8"             |
| Opera         | --browser "opera" --version 12   --dc.platform "Linux"                 |
| Firefox       | --browser "firefox" --version 34 --dc.platform "Linux"                 |
| Chrome        | --browser "chrome" --version 39 --dc.platform "Linux"                  |
| IE 11         | --browser "internet explorer" --version 11 --dc.platform "Windows 8.1" |


@@ parameterized using browsers
Home page on ${browserName} browser
selenium grid ${gridUrl} --page ${website} ${gridArgs}
check homePage.spec
*/

var x = browser.params.users.sauceLabsUser.user;
//var y = process.env.User;
var sauceKey    =    "ce6f90f1-65f4-4334-8249-fdddc3625874";
var sauceUser   =    "DannyACM";
var gridLogin   =    "${sauceUser}:${sauceKey}";
var gridUrl     =    "http://DannyACM:ce6f90f1-65f4-4334-8249-fdddc3625874@ondemand.saucelabs.com:80/wd/hub";
var website     =    "http://chip-dev-elb-1927620335.us-east-1.elb.amazonaws.com/";
console.log(x)
test("SauceLabs test for homepage on Safari", function () {
    var driver = createGridDriver(gridUrl, {
        browser: "safari",
        desiredCapabilities: {
            platform: "macOS 10.13",
            version: "11.0",
            
        }
    });

    driver.get("http://chip-dev-elb-1927620335.us-east-1.elb.amazonaws.com/");
    checkLayout(driver, "specs/homePage.gspec", "desktop");
});
