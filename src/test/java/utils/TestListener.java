package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;

public class TestListener implements ITestListener {

    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        System.out.println("=== EXTENT STARTED ===");

        ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = ExtentManager.getInstance()
                .createTest(result.getMethod().getMethodName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().log(
                Status.PASS,
                "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("===== TEST FAILURE DETECTED =====");

        Object currentClass = result.getInstance();

        WebDriver driver = ((BaseTest) currentClass)
                .getDriver();

        String screenshotPath = ScreenshotUtil.captureScreenshot(
                driver,
                result.getMethod().getMethodName());

        System.out.println("Screenshot Path: " + screenshotPath);

        test.get().fail(result.getThrowable());

        if (screenshotPath != null) {

            try {

                System.out.println("Attaching screenshot to report...");

                test.get()
                        .addScreenCaptureFromPath(
                                screenshotPath);

            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {

            System.out.println("Screenshot path is NULL");
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("EXTENT REPORT GENERATED");

        ExtentManager.getInstance().flush();
    }
}