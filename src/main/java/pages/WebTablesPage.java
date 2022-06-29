package pages;

import base.*;
import data.JsonReader;
import org.openqa.selenium.By;
import utils.Log4jUtil;

public class WebTablesPage extends BaseForm {
    public WebTablesPage() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Web Tables')]"), "web elements banner"), "web elements");
    }

    private BaseButton addBtn = new BaseButton(By.xpath("//button[@id=\"addNewRecordButton\"]"), "add button");
    private BaseTextField firstName = new BaseTextField(By.xpath("//input[@id=\"firstName\"]"), "first name field");
    private BaseTextField lastName = new BaseTextField(By.xpath("//input[@id=\"lastName\"]"), "first name field");
    private BaseTextField email = new BaseTextField(By.xpath("//input[@id=\"userEmail\"]"), "first name field");
    private BaseTextField age = new BaseTextField(By.xpath("//input[@id=\"age\"]"), "first name field");
    private BaseTextField salary = new BaseTextField(By.xpath("//input[@id=\"salary\"]"), "first name field");
    private BaseTextField department = new BaseTextField(By.xpath("//input[@id=\"department\"]"), "first name field");
    private BaseButton submitBtn = new BaseButton(By.xpath("//button[@id=\"submit\"]"), "submit Button");
    private BaseButton delete4thOne = new BaseButton(By.xpath("//span[@id=\"delete-record-4\"]"), "delete 4th element in list");
    private BaseButton delete5thOne = new BaseButton(By.xpath("//span[@id=\"delete-record-5\"]"), "delete 4th element in list");
    private BaseField registrationForm = new BaseField(By.xpath("//div[@id=\"registration-form-modal\"]"), "registration form");

    public boolean checkRegForm() {
        return registrationForm.isDisplayed();
    }

    public void clickOnAddBtn() {
        addBtn.scrollToElement();
        addBtn.click();
    }

    public void clickOn5thBtn() {
        delete5thOne.click();
    }

    public void clickOn4thBtn() {
        delete4thOne.click();
    }

    public boolean check4thBtn() {
        return delete4thOne.isDisplayed();
    }

    public void fillInfoUniversal(String whichSetToGet) {
        Log4jUtil.log4J.info("Filling info from " + whichSetToGet + "Set");
        firstName.sendText(JsonReader.getName(whichSetToGet));
        lastName.sendText(JsonReader.getfName(whichSetToGet));
        email.sendText(JsonReader.getMail(whichSetToGet));
        age.sendText(JsonReader.getAge(whichSetToGet));
        salary.sendText(JsonReader.getSalary(whichSetToGet));
        department.sendText(JsonReader.getDepartment(whichSetToGet));
        submitBtn.click();
    }
}
