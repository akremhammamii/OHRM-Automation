package com.OHRM.runner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")  // ✅ si ton dossier s'appelle "features" directement sous src/test/resources

@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "com.OHRM.stepdefinitions,com.OHRM.hooks"
)
@ConfigurationParameter(
        key = Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty, html:target/cucumber-report.html, json:target/cucumber-report.json, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
)
@ConfigurationParameter(
        key = Constants.FILTER_TAGS_PROPERTY_NAME,
        value = "not @wip"
)
@ConfigurationParameter(
        key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,
        value = "false"
)
public class TestRunner {
}
