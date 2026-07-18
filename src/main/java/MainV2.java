import model.v2.GeneratedTestSuite;
import service.AIResponseReaderV2;
import generator.v2.SeleniumCodeGeneratorV2;
import model.v2.GeneratedTestCase;
import generator.v2.PageObjectGeneratorV2;

public class MainV2 {

    public static void main(String[] args) {

        try {

            GeneratedTestSuite suite = AIResponseReaderV2.read();

            SeleniumCodeGeneratorV2.generate(suite);

            PageObjectGeneratorV2.generate(suite);

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