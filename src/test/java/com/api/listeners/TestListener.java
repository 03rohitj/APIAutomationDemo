package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger= LogManager.getLogger(TestListener.class);
    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Passed - Test : "+result.getMethod().getMethodName());
        logger.info("Description : "+result.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Failed - Test : "+result.getMethod().getMethodName());
        logger.error("Description : "+result.getMethod().getDescription());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Skipped - Test : "+result.getMethod().getMethodName());
        logger.warn("Description : "+result.getMethod().getDescription());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started!!!");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Finished!!!");
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Started : "+result.getMethod().getMethodName());
    }
}
