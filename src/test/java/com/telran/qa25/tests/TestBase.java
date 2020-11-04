package com.telran.qa25.tests;

import com.telran.qa25.helpers.ApplicationManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase{

    protected static ApplicationManager appManager = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp(){
       appManager.init();
    }


    @BeforeMethod
    public void startTest(Method m, Object[] p)
    {
        logger.info("Start test: " + m.getName());
        logger.info(" --> With data: " + Arrays.asList(p));

    }

    @AfterSuite(enabled = true)
    public void tearDown() {
         appManager.stop();
    }


    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED: Test method --> " + result.getMethod().getMethodName());
        }else{
            logger.error("FAILED: Test method --> " + result.getMethod().getMethodName());
            logger.info("Screenshot: " + appManager.getHeader().takeScreenShot());
        }

        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("======================================================");
    }


}
