Serenity NatGeo Automation Project (SNAP)
===============================

This is the test automation framework for NatGeo using SerenityBDD and Java.

<br>

## Setup
##### MAC
1.  Download [Eclipse](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen2) or [IntelliJ](https://www.jetbrains.com/idea/download/) and install it on your computer
2. In terminal: <br>
	```/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"```
3. In terminal: <br>
	```brew cask install java```
4. In terminal: <br>
	```brew install gradle```
5. In terminal: <br>
	```brew install geckodriver```

##### PC
1.  Download [Eclipse](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen2) or [IntelliJ](https://www.jetbrains.com/idea/download/) and install it on your computer
2. Install [Java JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
3. Install [Gradle](https://gradle.org/install/)


**Install NPM**<br>
  In terminal:<br>
	```brew install npm```
	
**Install Appium searver with chromedriver**<br>
  In terminal: <br>
	```npm install -g appium --chromedriver_version="2.37"```

## Running

In a terminal prompt in the root folder of the project

Run all feature files sequentially with Chrome using the staging properties file
```
gradle clean test -Denv=staging -Dwebdriver.driver=chrome
```
<br>

Run all test in parallel with Firefox using the qa properties file
```
gradle clean runInParallel -Denv=qa -Dwebdriver.driver=firefox
```

<br>


## Eclispe Setup  ##
From the terminal, cd to the directory of the cloned project
Type: gradle cleanEclipse Eclipse

The cleanEclipse task will remove the Eclipse specific files and then the Eclipse
task will create the file needed to import the project into Eclipse.



## Basic Design principles of SNAP

In most test automation frameworks, the majority of the work comes not from creating the tests but in maintaining the tests from application updates.  In that re-guard, this framework is designed to minimize the rework from application changes.

In general SNAP, can be broken down into four sections.  The four sections are pages, scenario steps, step definitions, and features.<br>
**feature** - This is the file that describes the business objective of the test, what are we trying to accomplish.  This file take the form of a Given, When, Then syntax that tries to use plain text to describe the behavior of the test.<br>
**step definitions** - This file is used to turn that plain english in actions.  It first uses regEx to link the statements to steps that essentially are functions that perform actions on the application. <br>
**scenario steps** -  This layer is used to group functions/methods that make logical sense to be put together but are not necessary located on the same web page.  A good example of this would be a input form or wizard that has multiple cards (Home Address, Credit Card Info, Car info, etc).  They are not on the same page but for the sake of this input wizard they are grouped together.<br>
**pages** - This is where the elements of the web page are defined using css/xpath.  These elemnts are grouped together because thet are physically bound by location.

<br>

##  Properties
   ...either in the properties file or on the command line with a -D
   For a complete list of Serenity properties goto [here](http://thucydides.info/docs/serenity-staging/#_serenity_system_properties_and_configuration)

   **#### Properties of note ####**<br>
   **webdriver.base.url** - This sets the base url for the environment, usually found in the properties files
   **webdriver.driver** - This is the desired browser for the test, i.e. chrome, firefox, ...
 
   **-- Saucelabs --**<br>
   **saucelabs.url** - The accress url for suacelabs  ( It is not recommended to check this value into github )
   **saucelabs.access.key** - Access key for login to saucelabs ( It is not recommended to check this value into github ) 
   **saucelabs.user.id** - Userid for suacelabs

   **saucelabs.target.platform** - Sets the desired OS for the saucelabs VM <br>
   Examples: <br>
   * saucelabs.target.platform=OS 10.13  	( Mac OS )<br>
   * saucelabs.target.platform=WIN10		    ( Windows 10 )<br>
 
   **saucelabs.browserName** - Sets the desired browser to be used on suacelabs<br>
 
   **saucelabs.test.name** - Sets the initail name of the test running in suacelabs<br>
   **saucelabs.idleTimeout** - Sets the max idle wait time that saucelabs will wait before ending the test<br>
   **saucelabs.commandTimeout** - Sets the max time that a single command can run<br>
   **saucelabs.screenResolution** - Sets the desired desktop size for the VM<br>
   
 
 
 
   **-- SNAP Properties --**<br>
   **env** - This property is required, it is used to select which property file is loaded.  The properties files are located in src/test/resources/properties<br>
 
   **snap.applitools.key** - This is the property used to pass the applitools key<br>
   **snap.applitools.url** - This is the property used to pass the applitools url<br>
   **snap.applitools.screensize** - This is the name of the screen from ScreenSize, it sets the applitools window size<br>
   **snap.applitools.matchlevel** - This is how applitools will compare the two screen captures.  The default is STRICT.
    	                                 The other options are LAYOUT,EXACT, and CONTENT.  For a further explanation of the match levels please click [here](http://support.applitools.com/customer/portal/articles/2088359-match-levels)
 
   **snap.core.admin.user** - This is the property used to pass the Adobe Experience Manager (AEM) user name<br>
   **snap.core.admin.passwd** - This is the AEM user password.<br>
 
   **snap.parallel.number** - The is used to set the number of parallel runners when executing the "runInParallel" task<br>

 
 
 
 
 
  
  
