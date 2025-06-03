package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "pages"},   // <-- look here for step defs & hooks
        tags     = "@automated",              // ONLY run scenarios tagged @automated
        plugin = {
                "pretty",
                "summary",
                "html:target/cucumber-report.html"
        },
        monochrome = true,
        dryRun = false
)
public class TestRunnerTest { }