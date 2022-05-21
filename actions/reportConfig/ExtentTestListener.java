package reportConfig;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
public class ExtentTestListener  {
//public class ExtentTestListener implements ITestListener {
//	private static ExtentReports extent = ExtentManager.createInstance();
//	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//
//	@Override
//	public synchronized void onStart(ITestContext context) {
//		System.out.println("Extent Reports Version3Test Suite started!");
//	}
//
//	@Override
//	public synchronized void onFinish(ITestContext context) {
//		System.out.println(("Extent Reports Version3Test Suite is ending!"));
//		extent.flush();
//	}
//
//	@Override
//	public synchronized void onTestStart(ITestResult result) {
//		System.out.println((result.getMethod().getMethodName() + " started!"));
//		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
//		test.set(extentTest);
//	}
//
//	@Override
//	public synchronized void onTestSuccess(ITestResult result) {
//		System.out.println((result.getMethod().getMethodName() + " passed!"));
//		test.get().pass("Test passed");
//	}
//
//	@Override
//	public synchronized void onTestFailure(ITestResult result) {
//		System.out.println((result.getMethod().getMethodName() + " failed!"));
//		test.get().fail(result.getThrowable());
//	}
//
//	@Override
//	public synchronized void onTestSkipped(ITestResult result) {
//		System.out.println((result.getMethod().getMethodName() + " skipped!"));
//		test.get().skip(result.getThrowable());
//
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		System.out.println(("onTestFailed ButhithinSuccessPercentage for" + result.getMethod().getMethodName()));
//	}
}