import model.v2.GeneratedTestSuite;
import service.AIResponseReaderV2;
import generator.v2.SeleniumCodeGeneratorV2;
import generator.v2.TestNGGeneratorV2;
import generator.v2.WaitUtilityGeneratorV2;
import generator.v2.ConfigGeneratorV2;
import generator.v2.ConfigReaderGeneratorV2;
import model.v2.GeneratedTestCase;
import generator.v2.BasePageGeneratorV2;
import generator.v2.BaseTestGeneratorV2;
import generator.v2.ChangelogGeneratorV2;
import generator.v2.DriverFactoryGeneratorV2;
import generator.v2.ExtentListenerGeneratorV2;
import generator.v2.ExtentReportGeneratorV2;
import generator.v2.ExtentTestManagerGeneratorV2;
import generator.v2.FrameworkArchitectureGeneratorV2;
import generator.v2.FrameworkGenerationReportGeneratorV2;
import generator.v2.LoggerGeneratorV2;
import generator.v2.PageObjectGeneratorV2;
import generator.v2.PomGeneratorV2;
import generator.v2.ProjectStructureGeneratorV2;
import generator.v2.ScreenshotUtilityGeneratorV2;
import generator.v2.READMEGeneratorV2;
import generator.v2.GitIgnoreGeneratorV2;
import generator.v2.LicenseGeneratorV2;
import generator.v2.FrameworkVersionGeneratorV2;

public class MainV2 {

    public static void main(String[] args) {

        try {

            GeneratedTestSuite suite = AIResponseReaderV2.read();

            ProjectStructureGeneratorV2.generate();

            READMEGeneratorV2.generate();
            FrameworkArchitectureGeneratorV2.generate();
            ChangelogGeneratorV2.generate();
            LicenseGeneratorV2.generate();
            FrameworkGenerationReportGeneratorV2.generate(suite);

            GitIgnoreGeneratorV2.generate();
            BasePageGeneratorV2.generate();
            WaitUtilityGeneratorV2.generate();
            ScreenshotUtilityGeneratorV2.generate();
            LoggerGeneratorV2.generate();
            ExtentReportGeneratorV2.generate();
            ExtentTestManagerGeneratorV2.generate();
            ExtentListenerGeneratorV2.generate();
            DriverFactoryGeneratorV2.generate();
            BaseTestGeneratorV2.generate();
            ConfigGeneratorV2.generate();
            ConfigReaderGeneratorV2.generate();
            FrameworkVersionGeneratorV2.generate();
            PageObjectGeneratorV2.generate(suite);
            PomGeneratorV2.generate();
            TestNGGeneratorV2.generate();

            SeleniumCodeGeneratorV2.generate(suite);

            System.out.println("\n==============================");
            System.out.println(" GENERATED TEST SUITE V2");
            System.out.println("==============================");

            System.out.println("Feature      : " + suite.getFeature());
            System.out.println("Requirement  : " + suite.getRequirement());
            System.out.println("Total Tests  : " + suite.getTestCases().size());

            for (GeneratedTestCase tc : suite.getTestCases()) {

                System.out.println("--------------------------------");

                System.out.println("Scenario : " + tc.getScenario());
                System.out.println("Expected : " + tc.getExpectedResult());

                System.out.println("Email    : " + tc.getTestData().getEmail());
                System.out.println("Password : " + tc.getTestData().getPassword());
                System.out.println("Confirm  : " + tc.getTestData().getConfirmPassword());

                System.out.println("Priority : " + tc.getPriority());
                System.out.println("Category : " + tc.getCategory());

                System.out.println("Automation : " + tc.isAutomation());

                System.out.println("Tags : " + tc.getTags());

                System.out.println("Locators : " + tc.getLocators());
            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

}