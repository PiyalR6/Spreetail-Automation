package pageObjects;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.util.UtilsMethods;
import coreClasses.BasePageObject;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;

public class ProductListingPage extends BasePageObject {

    public ProductListingPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub

    }

    WebDriverWait wait = new WebDriverWait(driver, 10);

    //	List<WebElement> outOfStock = driver.findElements(By.xpath("//span[contains(text(),'Currently out of stock')]"));
    By productName = By.className("LinesEllipsis  ");
    By propName = By.xpath("//span[@itemprop='name']");
    By outOfStockButton = By.xpath("//div[@class='Product__ProductListingWrapper-o90kst-0 cACWNG']/button[@class='Buttons__PrimaryButton-sc-17gamhm-0 jlrgrD']");


    List<WebElement> priceOfAllProducts = driver.findElements(By.xpath("//div[@class='Typography__DivText-rz6iur-4 Typography__MBodyDiv-rz6iur-21 price-label Typography__FieldLabel-rz6iur-27 jyUzOj']/span[2]"));


    // public void clickOnProductsLink() throws IOException {
    UtilsMethods utilmethods = new UtilsMethods();
    int randomNumbers = utilmethods.RandomSelect(1, 3);
    int i = 1;
    //By RandomProduct = By.xpath("(//div[@id='product-title'])[" + i+ "]");

    // click(By.xpath("//a[@class='title text-truncate']"));

    public void clickGrill() throws IOException {
        click(By.xpath("//div[contains(text(),'$37.99')]"));

    }

    public void clickOnFirstProduct() throws IOException, InterruptedException {
        //scrollDown();
        timeinterval(3);
        click(By.xpath("//span[contains(text(),'14.99')]"));
        timeinterval(10);
    }

    public boolean verifyProductName() throws IOException, InterruptedException {
        return getText(By.xpath("//span[@class='ProductTitleLabel-xvc4q8-0 cULlju']")).contains("Icon");

    }

    public void clickOnRandomProduct() throws IOException, InterruptedException {


        List<WebElement> products = getlistofelement(By.className("LinesEllipsis  "));
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
        Random random = new Random();
        int randomIndex = random.nextInt(products.size());
        String url = driver.getCurrentUrl();
        wait.until(ExpectedConditions.elementToBeClickable(products.get(randomIndex))).click();

        Thread.sleep(1000);

//        if (!driver.findElement(outOfStockButton).isEnabled()) {
//            do {
//                driver.get(url);
//                products = getlistofelement(By.className("LinesEllipsis  "));
//                wait.until(ExpectedConditions.visibilityOfAllElements(products));
//                randomIndex = random.nextInt(products.size());
//                wait.until(ExpectedConditions.elementToBeClickable(products.get(randomIndex)));
//                products.get(randomIndex).click();
//            } while (!driver.findElement(outOfStockButton).isEnabled());
//        }

    }


    public void clickOnItemFromFilterTitle(String title) throws IOException, InterruptedException {
        By filteringTitle = By.xpath("//div[@class='filter-section']//span[contains(text(),'" + title + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(filteringTitle)).click();
//
//        List<WebElement> hiddenDropdown= driver.findElements(By.xpath("//div[@class='filter-section']//span[contains(text(),'"+title+"')]/../../../../div[@class='hidden']"));
//        Assert.assertTrue(hiddenDropdown.size()==0,title+" is not clicked");
    }

    public void clickOnItemFromFilterSubTitle(String subTitle) throws IOException, InterruptedException {
        By filteringSubTitle = By.xpath("//div[@class='filter-section']//div[contains(text(),'" + subTitle + "')]");
        click(filteringSubTitle);
    }

    public void verifyAllProductsSortedLowToHigh() {
        List<Integer> pricesFromList = new ArrayList<>();
        for (WebElement el : priceOfAllProducts) {
            int i = Integer.parseInt(el.getText().replace(",", "").replace(".", ""));
            pricesFromList.add(i);
        }

        System.out.println(pricesFromList.toString());
        boolean sorted = true;
        for (int i = 1; i < pricesFromList.size(); i++) {
            if (pricesFromList.get(i - 1).compareTo(pricesFromList.get(i)) > 0) sorted = false;
        }
        List<WebElement> pages = driver.findElements(By.xpath("//div[@class='Paginator__Pagination-p45g2g-0 fglzgB']/button"));

        if (pages.size() != 0) {
            for (WebElement page : pages) {
                if (page.getText().equals("2")) {
                    page.click();
                    break;
                }
            }
            List<Integer> pricesFromList2 = new ArrayList<>();

            List<WebElement> priceOfAllProducts2 = driver.findElements(By.xpath("//div[@class='Typography__DivText-rz6iur-4 Typography__MBodyDiv-rz6iur-21 price-label Typography__FieldLabel-rz6iur-27 jyUzOj']/span[2]"));


            wait.until(ExpectedConditions.visibilityOfAllElements(priceOfAllProducts2));

            for (WebElement el : priceOfAllProducts2) {
                int i = Integer.parseInt(el.getText().replace(",", "").replace(".", ""));
                pricesFromList2.add(i);
            }

            System.out.println(pricesFromList2.toString());
            boolean sorted2 = true;
            Assert.assertTrue(sorted2,"Second Page Listing is not Low to High");
        }


        Assert.assertTrue(sorted, "Listing is not Low to High");
    }

    public void verifyAllProductsSortedHighToLow() {
        List<Integer> pricesFromList = new ArrayList<>();
        for (WebElement el : priceOfAllProducts) {
            int i = Integer.parseInt(el.getText().replace(",", "").replace(".", ""));
            pricesFromList.add(i);
        }

        System.out.println(pricesFromList.toString());
        boolean sorted = true;
        for (int i = 1; i < pricesFromList.size(); i++) {
            if (pricesFromList.get(i - 1).compareTo(pricesFromList.get(i)) < 0) sorted = false;
        }

        List<WebElement> pages = driver.findElements(By.xpath("//div[@class='Paginator__Pagination-p45g2g-0 fglzgB']/button"));

        if (pages.size() != 0) {
            for (WebElement page : pages) {
                if (page.getText().equals("2")) {
                    page.click();
                    break;
                }
            }
            List<Integer> pricesFromList2 = new ArrayList<>();

           List<WebElement> priceOfAllProducts2 = driver.findElements(By.xpath("//div[@class='Typography__DivText-rz6iur-4 Typography__MBodyDiv-rz6iur-21 price-label Typography__FieldLabel-rz6iur-27 jyUzOj']/span[2]"));


            wait.until(ExpectedConditions.visibilityOfAllElements(priceOfAllProducts2));

            for (WebElement el : priceOfAllProducts2) {
                int i = Integer.parseInt(el.getText().replace(",", "").replace(".", ""));
                pricesFromList2.add(i);
            }

            System.out.println(pricesFromList2.toString());
            boolean sorted2 = true;
            for (int i = 1; i < pricesFromList2.size(); i++) {
                if (pricesFromList2.get(i - 1).compareTo(pricesFromList2.get(i)) < 0) sorted2 = false;
            }

            Assert.assertTrue(sorted2,"Second Page Listing is not High to Low");

        }
        Assert.assertTrue(sorted, "Listing is not High to Low");
    }

    public void verifyProductBrand(String brandNames) {
        String[] brandNamesArr = brandNames.split(", ");

        List<WebElement> productListingBrandNames = driver.findElements(By.xpath("//div[@class='columns is-tablet is-multiline']//span[@id='product-title']//b"));

        for (WebElement productBrand : productListingBrandNames) {
            Assert.assertTrue(Arrays.asList(brandNamesArr).contains(productBrand.getText()), productBrand.getText() + "is not in selected Brands :" + brandNames.toString());
        }

        List<WebElement> pages = driver.findElements(By.xpath("//div[@class='Paginator__Pagination-p45g2g-0 fglzgB']/button"));

        if (pages.size() != 0) {
            for (WebElement page : pages) {
                if (page.getText().equals("2")) {
                    page.click();
                    break;
                }
            }
        }

        productListingBrandNames = driver.findElements(By.xpath("//div[@class='columns is-tablet is-multiline']//span[@id='product-title']//b"));

        for (WebElement productBrand : productListingBrandNames) {
            Assert.assertTrue(Arrays.asList(brandNamesArr).contains(productBrand.getText()), productBrand.getText() + "is not in selected Brands :" + brandNames.toString());
        }


    }


    public void selectsRandomBrandFromFilter() {

        List<WebElement> brandFilterOptions = driver.findElements(By.xpath("//div[@class='filter-section']//span[contains(text(),'Brand')]/../../../..//div[2]/div/label[@class='Inputs__CheckboxInput-wc22x0-3 bEDUa']"));

            Random rndm = new Random();
            int index = rndm.nextInt(brandFilterOptions.size());
            String text = brandFilterOptions.get(index).getText();
            brandFilterOptions.get(index).click();

            List<WebElement>brandsSelectedText = driver.findElements(By.xpath("//div[@class='filter-section']//span[contains(text(),'Brand')]/../../span"));
            String[] brandsSelected = (brandsSelectedText.get(0).getText().split(", "));
            Assert.assertTrue(Arrays.asList(brandsSelected).contains(text), "Selected brand does not match with what is shown under brand");



    }


    public void verifyAllProductsAreSelectedBrand() {
        List<WebElement> brandsSelectedText = driver.findElements(By.xpath("//div[@class='filter-section']//span[contains(text(),'Brand')]/../../span"));

        Assert.assertTrue(brandsSelectedText.size() != 0, "There is no selected brand");

        String[] brandsSelected = (brandsSelectedText.get(0).getText().split(", "));

        List<WebElement> productListingBrandNames = driver.findElements(By.xpath("//div[@class='columns is-tablet is-multiline']//span[@id='product-title']//b"));

        for (WebElement productBrand : productListingBrandNames) {
            System.out.println(brandsSelected.toString() + " product brand");
            Assert.assertTrue(Arrays.asList(brandsSelected).contains(productBrand.getText()), productBrand.getText() + "is not in selected Brands :" + brandsSelected.toString());
        }

        List<WebElement> pages = driver.findElements(By.xpath("//div[@class='Paginator__Pagination-p45g2g-0 fglzgB']/button"));

        if (pages.size() != 0) {
            for (WebElement page : pages) {
                if (page.getText().equals("2")) {
                    page.click();
                    break;
                }
            }

            productListingBrandNames = driver.findElements(By.xpath("//div[@class='columns is-tablet is-multiline']//span[@id='product-title']//b"));

            for (WebElement productBrand : productListingBrandNames) {
                Assert.assertTrue(Arrays.asList(brandsSelected).contains(productBrand.getText()), productBrand.getText() + "is not in selected Brands :" + brandsSelected.toString());
            }
        }


    }


}