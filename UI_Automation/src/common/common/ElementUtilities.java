package common;

public class ElementUtilities {

    public static void clickOnElement(String xpath) throws Exception {
        int i = 0;
        do {
            try {
                Constant.WEBDRIVER.findElement(By.xpath(xpath)).click();
                return;
            } catch (Exception e) {
                System.out.println("Attempting to click the element");
                i += 1;
                Thread.sleep(1000);
            }
        } while (i < Constant.DEFAULT_TIMEOUT);
    }


    public static void clickOnElement(String xpath, int timeOut) throws Exception {
        int i = 0;
        do {
            try {
                Constant.WEBDRIVER.findElement(By.xpath(xpath)).click();
                return;
            } catch (Exception e) {
                System.out.println("Attempting to click the element");
                i += 1;
                Thread.sleep(1000);
            }
        } while (i < timeOut);
    }


    public static void clickOnElement(WebElement element) throws Exception {
        int i = 0;
        do {
            try {
                element.click();
                return;
            } catch (Exception e) {
                System.out.println("Attempting to click the element: " + element.getAttribute("class"));
                i += 1;
                Thread.sleep(1000);
            }
        } while (i < Constant.DEFAULT_TIMEOUT);
    }

    public static void selectDropdownByValue(WebElement element, String expectedValue) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(expectedValue);
    }

    public static void selectRandomDropdown(String xpath) {
        //Note that: getOptions will return List<WebElement>
        Select dropdown = new Select(Constant.WEBDRIVER.findElement(By.xpath(xpath)));
        Random random = new Random();
        int index = random.nextInt(dropdown.getOptions().size());
        dropdown.selectByIndex(index);
    }

    public static WebElement waitUntilElementToBeClickable(By locator, int timeout) {
        return new WebDriverWait(Constant.WEBDRIVER, timeout).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitUntilVisibilityOfElementLocated(By locator, int timeout){
        return new WebDriverWait(Constant.WEBDRIVER, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitUtilPresenceOfElementLocated(By locator, int timeout) {
        return new WebDriverWait(Constant.WEBDRIVER, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void clickUsingJs(String xpath) {
        WebElement element = Constant.WEBDRIVER.findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) Constant.WEBDRIVER;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickOnElement(By xpath, int timeout) {
        waitUntilElementToBeClickable(xpath, timeout).click();
    }
    public void clickUsingActions(By locator, int timeout) {
        WebElement element = waitUntilVisibilityOfElementLocated(locator, timeout);
        Actions builder = new Actions(Constant.WEBDRIVER);
        builder.moveToElement(element).click(element);
        builder.build().perform();

    }

    public void performSendKeys(By locator, String keyToSend, int timeout) {
        WebElement element = waitUntilVisibilityOfElementLocated(locator, timeout);
        element.clear();
        element.sendKeys(keyToSend);
    }

    public void hoverTo(String xpath) {
        WebElement element =  Constant.WEBDRIVER.findElement(By.xpath(xpath));
        Actions action = new Actions(Constant.WEBDRIVER);
        action.moveToElement(element).build().perform();
    }

    public void scrollToView(By locator) {
        WebElement element = Constant.WEBDRIVER.findElement(locator);
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }


}