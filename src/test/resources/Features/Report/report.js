$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/facebooklogin.feature");
formatter.feature({
  "name": "Facebook login verification",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Facebook login credentials verification",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user is on facebook login page",
  "keyword": "Given "
});
formatter.step({
  "name": "user should enter \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user should click the login button",
  "keyword": "And "
});
formatter.step({
  "name": "user should verify the success message",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "Jerlin",
        "Jerlin@123"
      ]
    },
    {
      "cells": [
        "Jeyam",
        "Jerlin@123"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Facebook login credentials verification",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user is on facebook login page",
  "keyword": "Given "
});
formatter.match({
  "location": "Facebook.user_is_on_facebook_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should enter \"Jerlin\" and \"Jerlin@123\"",
  "keyword": "When "
});
formatter.match({
  "location": "Facebook.user_should_enter_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should click the login button",
  "keyword": "And "
});
formatter.match({
  "location": "Facebook.user_should_click_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should verify the success message",
  "keyword": "Then "
});
formatter.match({
  "location": "Facebook.user_should_verify_the_success_message()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Facebook login credentials verification",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user is on facebook login page",
  "keyword": "Given "
});
formatter.match({
  "location": "Facebook.user_is_on_facebook_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should enter \"Jeyam\" and \"Jerlin@123\"",
  "keyword": "When "
});
formatter.match({
  "location": "Facebook.user_should_enter_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should click the login button",
  "keyword": "And "
});
formatter.match({
  "location": "Facebook.user_should_click_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should verify the success message",
  "keyword": "Then "
});
formatter.match({
  "location": "Facebook.user_should_verify_the_success_message()"
});
formatter.result({
  "status": "passed"
});
});