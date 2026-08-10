package config;

public class FrameworkConstants {

    private FrameworkConstants() {
        // Prevent instantiation
    }

    public static final String CONFIG_FILE = "config.properties";

    public static final String AI_RESPONSE_FILE = "src/main/resources/ai-response.txt";

    public static final String GENERATED_PROMPT_FILE = "generated-prompt.txt";

    public static final String EXCEL_FILE = "StructuredTestCases.xlsx";

    public static final String TESTNG_XML = "testng.xml";

    public static final String TEST_DESIGN_PROMPT = "src/main/resources/prompts/test-design-prompt.txt";

    public static final String AI_RESPONSE_JSON = "src/main/resources/ai-response-v2.json";

    public static final String GENERATED_OUTPUT_FOLDER = "generated-output";

    public static final String GENERATED_TEST_OUTPUT = GENERATED_OUTPUT_FOLDER + "/RegistrationTests.java";

    public static final String BASE_URL = "file:///C:/Users/lenovo/.gemini/antigravity-ide/scratch/AI-Test-Design-POC/sample-registration-app/index.html";

    public static final String GITIGNORE_FILE = ".gitignore";

    // =========================
    // Project Information
    // =========================
    public static final String FRAMEWORK_NAME = "AI Test Design Framework Generator";
    public static final String FRAMEWORK_VERSION = "2.0";
    public static final String FRAMEWORK_AUTHOR = "Jayadev M.M";

    // =========================
    // Package Names
    // =========================
    public static final String FRAMEWORK_PACKAGE = "framework";
    public static final String PAGE_PACKAGE = "pages";
    public static final String TEST_PACKAGE = "tests";
    public static final String CONFIG_PACKAGE = "config";
    public static final String UTILS_PACKAGE = "utils";

    // =========================
    // Generated Class Names
    // =========================
    public static final String PAGE_CLASS = "RegistrationPage";
    public static final String TEST_CLASS = "RegistrationTests";
    public static final String DRIVER_FACTORY_CLASS = "DriverFactory";
    public static final String BASE_TEST_CLASS = "BaseTest";
    public static final String BASE_PAGE_CLASS = "BasePage";
    public static final String CONFIG_READER_CLASS = "ConfigReader";
    public static final String WAIT_UTIL_CLASS = "WaitUtil";
    public static final String LOGGER_UTIL_CLASS = "LoggerUtil";
    public static final String SCREENSHOT_UTIL_CLASS = "ScreenshotUtil";

    // =========================
    // Output Files
    // =========================
    public static final String README_FILE = "README.md";
    public static final String CHANGELOG_FILE = "CHANGELOG.md";
    public static final String LICENSE_FILE = "LICENSE";
    public static final String ARCHITECTURE_FILE = "FrameworkArchitecture.md";
    public static final String GENERATION_REPORT_FILE = "FrameworkGenerationReport.html";

    // =========================
    // Reports
    // =========================
    public static final String REPORT_FOLDER = "reports";
    public static final String SCREENSHOT_FOLDER = "reports/screenshots";
    public static final String EXTENT_REPORT = "reports/ExtentReport.html";
}