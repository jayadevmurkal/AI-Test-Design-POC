package ai.framework.generator.framework;

import ai.framework.model.FrameworkProject;

public class FrameworkGeneratorV3 {

    private final FrameworkWriterV3 writer;

    public FrameworkGeneratorV3(String outputDirectory) {

        this.writer = new FrameworkWriterV3(outputDirectory);

    }

    public void generate(FrameworkProject project) throws Exception {

        // Framework Core
        BasePageGeneratorV3 basePageGenerator = new BasePageGeneratorV3();
        BaseTestGeneratorV3 baseTestGenerator = new BaseTestGeneratorV3();
        DriverFactoryGeneratorV3 driverFactoryGenerator = new DriverFactoryGeneratorV3();

        // Utilities
        LoggerGeneratorV3 loggerGenerator = new LoggerGeneratorV3();
        ScreenshotGeneratorV3 screenshotGenerator = new ScreenshotGeneratorV3();
        WaitUtilGeneratorV3 waitUtilGenerator = new WaitUtilGeneratorV3();

        // Configuration
        ConfigReaderGeneratorV3 configReaderGenerator = new ConfigReaderGeneratorV3();
        ConfigGeneratorV3 configGenerator = new ConfigGeneratorV3();

        // Reporting
        ExtentManagerGeneratorV3 extentManagerGenerator = new ExtentManagerGeneratorV3();
        ExtentTestManagerGeneratorV3 extentTestManagerGenerator = new ExtentTestManagerGeneratorV3();
        ExtentListenerGeneratorV3 extentListenerGenerator = new ExtentListenerGeneratorV3();

        // Automation
        PageGeneratorV3 pageGenerator = new PageGeneratorV3();
        TestGeneratorV3 testGenerator = new TestGeneratorV3();

        // Project Files
        PomGeneratorV3 pomGenerator = new PomGeneratorV3();
        TestNGGeneratorV3 testNGGenerator = new TestNGGeneratorV3();
        READMEGeneratorV3 readmeGenerator = new READMEGeneratorV3();

        // Generate Framework Files
        basePageGenerator.generate(project);
        baseTestGenerator.generate(project);
        driverFactoryGenerator.generate(project);

        loggerGenerator.generate(project);
        screenshotGenerator.generate(project);
        waitUtilGenerator.generate(project);

        configReaderGenerator.generate(project);
        configGenerator.generate(project);

        extentManagerGenerator.generate(project);
        extentTestManagerGenerator.generate(project);
        extentListenerGenerator.generate(project);

        pageGenerator.generate(project);
        testGenerator.generate(project);

        pomGenerator.generate(project);
        testNGGenerator.generate(project);
        readmeGenerator.generate(project);

        // Write all generated files
        writer.writeAll(project.getFiles());

    }

}