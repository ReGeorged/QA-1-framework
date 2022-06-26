package pages;

import base.*;
import data.JsonReader;
import org.openqa.selenium.By;
import utils.ElementUtils;

public class WebTablesPageQa extends BaseForm {
    public WebTablesPageQa() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Web Tables')]"),"web elements banner"), "web elements");

    }

    private BaseButton addBtn = new BaseButton(By.xpath("//button[@id=\"addNewRecordButton\"]"),"add button");
    private BaseTextField firstName= new BaseTextField(By.xpath("//input[@id=\"firstName\"]"),"first name field");
    private BaseTextField lastName= new BaseTextField(By.xpath("//input[@id=\"lastName\"]"),"first name field");
    private BaseTextField email= new BaseTextField(By.xpath("//input[@id=\"userEmail\"]"),"first name field");
    private BaseTextField age= new BaseTextField(By.xpath("//input[@id=\"age\"]"),"first name field");
    private BaseTextField salary= new BaseTextField(By.xpath("//input[@id=\"salary\"]"),"first name field");
    private BaseTextField department= new BaseTextField(By.xpath("//input[@id=\"department\"]"),"first name field");
    private BaseButton submitBtn = new BaseButton(By.xpath("//button[@id=\"submit\"]"),"submit Button");
    private BaseButton delete4thOne= new BaseButton(By.xpath("//span[@id=\"delete-record-4\"]"),"delete 4th element in list");
    private BaseButton delete5thOne= new BaseButton(By.xpath("//span[@id=\"delete-record-5\"]"),"delete 4th element in list");
    private BaseField registrationForm = new BaseField(By.xpath("//div[@id=\"registration-form-modal\"]"),"registration form");
    private BaseField userslist = new BaseField(By.xpath("//div[@class=\"rt-tbody\"]"),"users list");
    public boolean checkRegForm(){
        return registrationForm.isDisplayed();
    }
    public void clickOnAddBtn(){
        ElementUtils.scrollToElement(addBtn.findElement());
        addBtn.click();
    }
    public void clickOn5thBtn(){
        delete5thOne.click();
    }
    public void clickOn4thBtn(){
        delete4thOne.click();
    }
    public boolean check4thBtn(){
        return delete4thOne.isDisplayed();
    }
    public void fillInfo1(){
        firstName.sendText(firstName.getElementLocator(), JsonReader.returnFromTestDataJson("1name"));
        lastName.sendText(lastName.getElementLocator(), JsonReader.returnFromTestDataJson("1fname"));
        email.sendText(email.getElementLocator(), JsonReader.returnFromTestDataJson("1mail"));
        age.sendText(age.getElementLocator(), JsonReader.returnFromTestDataJson("1age"));
        salary.sendText(salary.getElementLocator(), JsonReader.returnFromTestDataJson("1salary"));
        department.sendText(department.getElementLocator(), JsonReader.returnFromTestDataJson("1department"));
        submitBtn.click();
    }
    public void fillInfo2(){
        firstName.sendText(firstName.getElementLocator(), JsonReader.returnFromTestDataJson("2name"));
        lastName.sendText(lastName.getElementLocator(), JsonReader.returnFromTestDataJson("2fname"));
        email.sendText(email.getElementLocator(), JsonReader.returnFromTestDataJson("2mail"));
        age.sendText(age.getElementLocator(), JsonReader.returnFromTestDataJson("2age"));
        salary.sendText(salary.getElementLocator(), JsonReader.returnFromTestDataJson("2salary"));
        department.sendText(department.getElementLocator(), JsonReader.returnFromTestDataJson("2department"));
        submitBtn.click();
    }
}
