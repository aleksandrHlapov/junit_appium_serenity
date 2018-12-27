# SerenityBDD-Appium-Cross-Platform-Testing-Solution
This is the code for the demo that was presented by QualiTest and Sauce Labs in the webinar "One Test to Rule Them All - Conquer Android and iOS with One Script" 

The main folders and files in this repository:

src/test/resources/serenity.android.properties - The serenity bdd property file with Android configuraton

src/test/resources/serenity.iOS.properties - The serenity bdd property file with the configuration to be used to connect to sauce labs and run iOS simulator. This is a template and an example file. Values should be added to saucelabs.user.id, saucelabs.access.key, saucelabs.url and the appium keys.

Page Object Model - Layers of abstraction
1. Tests - define what you are going to do. 
src/test/resources/features.login/login.feature - the bdd feature file with one login scenario
2. Step Definitions. src/test/Java/com/qualitestgroup/serenity/cucumber/features/stepdefinitions folder 
3. Step - define how you are going to do it. src/test/Java/com/qualitestgroup/serenity/cucumber/features/steps folder 
4. Pages - contain the elements that define how to find the real elements and how to interact with them. src/test/Java/com/qualitestgroup/serenity/cucumber/features/pages folder 
