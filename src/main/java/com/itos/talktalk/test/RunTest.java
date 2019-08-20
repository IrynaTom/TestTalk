package com.itos.talktalk.test;

import cucumber.api.CucumberOptions;


import io.cucumber.junit.Cucumber;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Feature")
public class RunTest {

}
