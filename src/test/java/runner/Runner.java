package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/WebOrder.feature"},
        glue = {"stepdefinationfile"},
        tags = "@TestCase3",
        plugin = {"pretty"}
)
public class Runner {
}
