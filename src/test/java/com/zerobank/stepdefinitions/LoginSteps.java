package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginSteps {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        LoginPage loginPage= new LoginPage();
        loginPage.login(username,password);


    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String linkType) {
        switch (linkType){
            case "Savings":
                Driver.get().findElement(By.xpath("//a[@href='/bank/account-activity.html?accountId=1']")).click();
                break;
            case "Brokerage":
                Driver.get().findElement(By.xpath("//a[.='Brokerage']")).click();
                break;
            case "Checking":
                Driver.get().findElement(By.xpath("//a[.='Checking']")).click();
                break;
            case "Credit Card":
                Driver.get().findElement(By.xpath("//a[.='Credit Card']")).click();
                break;
            case "Loan":
                Driver.get().findElement(By.xpath("//a[.='Loan']")).click();
                break;


    }}
    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        WebElement expectedResult=Driver.get().findElement(By.xpath("//a[.='Account Activity']"));
        BrowserUtils.verifyElementDisplayed(expectedResult);

    }
    @And("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String selectedType) {
        WebElement dropdown= Driver.get().findElement(By.id("aa_accountId"));
        Select accountDropdown= new Select(dropdown);
        switch (selectedType){
            case "Savings":
                WebElement Savings = accountDropdown.getFirstSelectedOption();
                String expectedResult=Savings.getText();
                String actualResult="Savings";
                Assert.assertEquals("verify if displayed Savings",expectedResult,actualResult);
                break;
            case "Brokerage":
                accountDropdown.selectByValue("6");
                WebElement Brokerage = accountDropdown.getFirstSelectedOption();
                String expectedBrokerage=Brokerage.getText();
                String actualBrokerage="Brokerage";
                Assert.assertEquals(expectedBrokerage,actualBrokerage);
                break;
            case "Checking":
                accountDropdown.selectByValue("2");
                WebElement Checking = accountDropdown.getFirstSelectedOption();
                String expectedChecking=Checking.getText();
                String actualChecking="Checking";
                Assert.assertEquals(expectedChecking,actualChecking);
                break;
            case "Credit Card":
                accountDropdown.selectByValue("5");
                WebElement CreditCard = accountDropdown.getFirstSelectedOption();
                String expectedCreditCard=CreditCard.getText();
                String actualCreditCard="Credit Card";
                Assert.assertEquals(expectedCreditCard,actualCreditCard);
                break;
            case "Loan":
                accountDropdown.selectByValue("4");
                WebElement Loan = accountDropdown.getFirstSelectedOption();
                String expectedLoan=Loan.getText();
                String actualLoan="Loan";
                Assert.assertEquals(expectedLoan,actualLoan);
                break;
        }
    }

}
