package common;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;

import java.util.Calendar;


import Constant.Constant;
import core.driver_wrapper.management.Driver;
import core.driver_wrapper.management.DriverManagement;

import java.io.File;
import java.lang.Math;
public class Utilities{
    private final static String ALPHA_NUMERIC_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }


    public static String getRandomString(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int index = (int)(ALPHA_NUMERIC_STRING.length() * Math.random());
            sb.append(ALPHA_NUMERIC_STRING .charAt(index));
        }
        return sb.toString();
    }

    public static String getDateWithTimeMils() {
        String parse = String.valueOf(System.currentTimeMillis());
        return parse;
    }

    public static String getDateNow(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getDateNowWithDayPlus(String format, int dayPlus) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, dayPlus);
        Date currentDateAfterPlus = c.getTime();
        return dateFormat.format(currentDateAfterPlus);
    }

    public static void acceptAlert() {
        switchTo().accept();
    }
    public static Alert switchTo() {
        new WebDriverWait(Constant.WEBDRIVER, Constant.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.alertIsPresent());
        // Switching to Alert
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        return alert;
    }
    public static void dismissAlert() {
        switchTo().dismiss();
    }

    public static String getCurrentURL() {
        return Constant.WEBDRIVER.getCurrentUrl();
    }
    public static void openNewTab(String url) {
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(Constant.WEBDRIVER.getWindowHandles());
        Constant.WEBDRIVER.switchTo().window(tabs.get(1));
        Constant.WEBDRIVER.get(url);
    }

    public static void closeCurrentTab() {
        Constant.WEBDRIVER.close();
        ArrayList<String> tabs = new ArrayList<String>(Constant.WEBDRIVER.getWindowHandles());
        Constant.WEBDRIVER.switchTo().window(tabs.get(0));
    }
    public static void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<String>(Constant.WEBDRIVER.getWindowHandles());
        Constant.WEBDRIVER.switchTo().window(tabs.get(1));
    }
    public static void switchToSpecificTab(int index) {
        ArrayList<String> tabs = new ArrayList<String>(Constant.WEBDRIVER.getWindowHandles());
        Constant.WEBDRIVER.switchTo().window(tabs.get(index));
    }

    public static int getRandomNumber(int range) {
        Random random = new Random();
        int index = random.nextInt(range);
        return index;
    }

    public static String captureScreenShot(String filename, String filepath) throws Exception {
        String path = "";
        try {
            // Convert web driver object to capture screenshot
            TakesScreenshot scrShot = ((TakesScreenshot) DriverManagement.getDriver());

            // Call getScreenshotAs method to create image file
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

            // Move image file to new destination
            File DestFile = new File(filepath + File.separator + filename + ".png");

            // Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);
            path = DestFile.getAbsolutePath();
        } catch (Exception e) {
            System.err.println("An error occurred when capturing screen shot: " + e.getMessage());
        }
        return path;
    }
}