/**
 * @author Daniel Álvarez del Castillo MArtinez <daniel.alvarez@wizeline.com>
 * @description Configuration File.
 */
//var Jasmine2HtmlReporter = require('protractor-jasmine2-html-reporter')
//var SpecReporter = require('jasmine-spec-reporter').SpecReporter
//var pages = require('../pageObjects/pages/Pages.js')
require('dotenv').config({})


exports.config = {
    // docker hub Address.
    // seleniumAddress: "http://192.168.99.100:4444/wd/hub",
    //seleniumAddress: 'http://localhost:4444/wd/hub',
    // Uncomment this line if you want to test locally
    // directConnect: true,
    params: {
      users: {
        sauceLabsUser: {
          user: process.env.USER,
          key: process.env.KEY
        }
    }
    },
    
    global.dvr = browser.driver
    


}