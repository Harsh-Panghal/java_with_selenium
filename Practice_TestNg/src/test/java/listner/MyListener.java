package listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("[SUITE START] Test Execution Started...");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[TEST START] test case started... " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[TEST PASS] Congrates! Test pass... " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[TEST FAIL] Oops! Test fail..." + result.getName());
        System.out.println(" (Reason): " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[TEST SKIP] Test case skipped... " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("[SUITE FINISH] Test Execution Completed.");
    }
}
