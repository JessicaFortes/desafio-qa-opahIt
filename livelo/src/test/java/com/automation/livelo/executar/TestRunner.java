package com.automation.livelo.executar;

import org.junit.runner.RunWith;

import com.automation.livelo.drivers.DriverChrome;
import com.automation.livelo.utils.ReportTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", //
		glue = { "com.automation.livelo.steps", "com.automation.livelo.executar" }, //
		tags = { "@sprint1" }, //
		strict = true)

public class TestRunner {

	@Before
	public static void inciarTeste(Scenario scenario)  {
		ReportTest.startRelatorio();
		ReportTest.startCenario(scenario.getName());
	}
	


	@After
	public static void fecharNavegador() {
		ReportTest.endRelatorio();
		DriverChrome.finalizarDriver();
	}

}