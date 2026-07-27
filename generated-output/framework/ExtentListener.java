package framework;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.WebDriver;
import framework.BaseTest;
public class ExtentListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTestManager.startTest(result.getMethod().getMethodName());
        LoggerUtil.info("Starting Test : " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest().pass("Test Passed");
        LoggerUtil.info("Test Passed : " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        LoggerUtil.error("Test Failed : " + result.getMethod().getMethodName());

        ExtentTestManager.getTest().fail(result.getThrowable());

        try {
            Object currentClass = result.getInstance();
            WebDriver driver = ((BaseTest) currentClass).getDriver();

            String screenshot = ScreenshotUtil.capture(
                    driver,
                    result.getMethod().getMethodName());

            if (screenshot != null) {
                ExtentTestManager.getTest().addScreenCaptureFromPath(screenshot);
            }
        }
        catch (Exception e) {
            LoggerUtil.error("Unable to capture screenshot");
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTestManager.getTest().skip("Test Skipped");
        LoggerUtil.warning("Test Skipped : " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.getInstance().flush();
    }

}
