package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",//to tell cucumber where is ur feature file
        glue="classpath:stepdef", // to tell cucumber where is ur step def code
        tags="@tag2", // to tell which tagged feature file to execute
        plugin = {"pretty", // to generate reports
            "html:target/html/htmlreport.html",
            "json:target/json/file.json",
            },
        monochrome=true,
        publish=true,
        dryRun=false // to tell whether to test run(true) or actual run(false)
        )

public class runner {
	

}
