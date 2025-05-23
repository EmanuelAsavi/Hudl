package hudl.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
        },
        features = "src/test/java/resources/features",
        glue = "hudl/step_definitions",
        dryRun = false,
        tags = "@login",
        publish = true //generating a report with public link
)
public class CukesRunner {}

