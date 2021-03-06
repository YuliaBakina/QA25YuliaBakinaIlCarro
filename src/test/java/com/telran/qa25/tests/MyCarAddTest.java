package com.telran.qa25.tests;

import com.telran.qa25.objects.Car;
import com.telran.qa25.objects.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyCarAddTest extends TestBase {

    @BeforeMethod(enabled = true)
    public void ensurePreconditions(){

        if(appManager.getUser().isUserLoggedIn()){
            appManager.getUser().logOut();
        }
    }

   @Test(dataProvider="validCarFromFile",dataProviderClass = DataProviders.class,enabled = true)
    public void myCarAddByLoggedInUserPositiveFromFileTest(Car car) throws InterruptedException {

        //Login user
        appManager.getHeader().clickLoginTabOnHeader();
        appManager.getUser().fillLoginUserForm(new User()
                    .setEmail("yb_mail10@gmail.com")
                    .setPassword("J20i12s13"));
        appManager.getCar().clickSubmitForm();

        appManager.getCar().delay(1000);

        //Let the car work link opening
        appManager.getHeader().clickAddCarTabOnHeader();
        appManager.getHeader().isAddCarFormPresent();

        //Fill all the fields with correct details
        appManager.getCar().fillCarAddingForm(car);

        //upload photo

        //click submit button
        appManager.getCar().clickSubmitForm();

        appManager.getCar().delay(2000);

        //check the car was added
        //Don't know how to read status and message from browser console log
        Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());

     }

    @Test(dataProvider="invalidCarFromFile",dataProviderClass = DataProviders.class,enabled = true)
    public void myCarAddByLoggedInUserNegativeFromFileTest(Car car) throws InterruptedException {

        //Login user
        appManager.getHeader().clickLoginTabOnHeader();
        appManager.getUser().fillLoginUserForm(new User()
                .setEmail("yb_mail10@gmail.com")
                .setPassword("J20i12s13"));
        appManager.getCar().clickSubmitForm();

        appManager.getCar().delay(1000);

        //Let the car work link opening
        appManager.getHeader().clickAddCarTabOnHeader();
        appManager.getHeader().isAddCarFormPresent();

        //Fill all the fields with correct details
        appManager.getCar().fillCarAddingForm(car);

        //upload photo

        //click submit button
        appManager.getUser().clickSubmitForm();

        appManager.getCar().delay(2000);

        //check the car was added
        //Don't know how to read status and message from browser console log
        Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());

    }


    //////////////////////////////////////////////////////////////////////////////

  @Test(enabled = false)
    public void myCarAddByLoggedInUserPositiveTest() throws InterruptedException {

        //Login user
        appManager.getHeader().clickLoginTabOnHeader();
        appManager.getUser().fillLoginUserForm(new User()
                    .setEmail("yb_mail10@gmail.com")
                    .setPassword("J20i12s13"));
        appManager.getCar().clickSubmitForm();

        appManager.getCar().delay(1000);

        //Let the car work link opening
        appManager.getHeader().clickAddCarTabOnHeader();
        appManager.getHeader().isAddCarFormPresent();

        //Fill all the fields with correct details
        appManager.getCar().fillCarAddingForm(new Car()
                .setCountry("Israel").setAddress("Netanya, Herzl, 13, 2").setDistance("500")
                .setSerialNumber("129-11-736").setMake("Honda").setModel("Civic").setYear("2015")
                .setEngine("HC123456789HC").setFurlConsumption("6.5").setFuelType("petrol")
                .setGear("full drive").setWheelsDrive("4WD").setHorsePower("149").setTorque("120")
                .setDoors("5").setSeats("5").setCarClass("C")
                .setAbout("Very good car").setFeatures("new one, non smoking, navigator, baby chair").setPricePerDay("55"));

        //upload photo

        //click submit button
        appManager.getCar().clickSubmitForm();

       appManager.getCar().delay(2000);

        //check the car was added
        //Don't know how to read status and message from browser console log
        Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());

     }

    @Test(enabled = false)
    public void myCarAddUserLogoutPositiveTest() throws InterruptedException {

        //Let the car work link opening
        appManager.getHeader().clickAddCarTabOnHeader();
        appManager.getHeader().isAddCarFormPresent();

        //Fill all the fields with correct details
        appManager.getCar().fillCarAddingForm(new Car()
                .setCountry("Israel").setAddress("Netanya, Herzl, 13, 2").setDistance("500")
                .setSerialNumber("777-22-130").setMake("Honda").setModel("Civic").setYear("2015")
                .setEngine("HC123456789HC").setFurlConsumption("6.5").setFuelType("petrol")
                .setGear("full drive").setWheelsDrive("4WD").setHorsePower("149").setTorque("120")
                .setDoors("5").setSeats("5").setCarClass("C")
                .setAbout("Very good car").setFeatures("new one, non smoking, navigator, baby chair").setPricePerDay("55"));

        //upload photo

        //click submit button
        appManager.getUser().clickSubmitForm();

        appManager.getCar().delay(2000);

        //check the car was added
        //Don't know how to read status and message from browser console log
        Assert.assertTrue(appManager.getHeader().isLoginFormPresent());

    }


    @Test(enabled = false)
    public void myCarAddTheSameSerialNumberTest() throws InterruptedException {

        //Login user
        appManager.getHeader().clickLoginTabOnHeader();
        appManager.getUser().fillLoginUserForm(new User()
                .setEmail("yb_mail10@gmail.com")
                .setPassword("J20i12s13"));
        appManager.getCar().clickSubmitForm();

        appManager.getCar().delay(1000);

        //Let the car work link opening
        appManager.getHeader().clickAddCarTabOnHeader();
        appManager.getHeader().isAddCarFormPresent();

        //Fill all the fields with correct details
        appManager.getCar().fillCarAddingForm(new Car()
                .setCountry("Israel").setAddress("Netanya, Herzl, 13, 2").setDistance("500")
                .setSerialNumber("123-11-777").setMake("Honda").setModel("Civic").setYear("2015")
                .setEngine("HC123456789HC").setFurlConsumption("6.5").setFuelType("petrol")
                .setGear("full drive").setWheelsDrive("4WD").setHorsePower("149").setTorque("120")
                .setDoors("5").setSeats("5").setCarClass("C")
                .setAbout("Very good car").setFeatures("new one, non smoking, navigator, baby chair").setPricePerDay("55"));

        //upload photo

        //click submit button
        appManager.getUser().clickSubmitForm();

        appManager.getCar().delay(2000);

        //check the car was added
        //Don't know how to read status and message from browser console log
        Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());

    }

    @Test(enabled = false)
    public void myCarAddWithoutDoorsTest() throws InterruptedException {

        //Login user
        appManager.getHeader().clickLoginTabOnHeader();
        appManager.getUser().fillLoginUserForm(new User()
                .setEmail("yb_mail10@gmail.com")
                .setPassword("J20i12s13"));
        appManager.getCar().clickSubmitForm();

        appManager.getCar().delay(1000);

        //Let the car work link opening
        appManager.getHeader().clickAddCarTabOnHeader();
        appManager.getHeader().isAddCarFormPresent();

        //Fill all the fields with correct details
        appManager.getCar().fillCarAddingForm(new Car().setCountry("Israel").setAddress("Netanya, Herzl, 13, 2").setDistance("500")
                .setSerialNumber("444-00-999").setMake("Honda").setModel("Civic").setYear("2015")
                .setEngine("HC123456789HC").setFurlConsumption("6.5").setFuelType("petrol")
                .setGear("full drive").setWheelsDrive("4WD").setHorsePower("149").setTorque("120")
                .setSeats("5").setCarClass("C")
                .setAbout("Very good car").setFeatures("new one, non smoking, navigator, baby chair").setPricePerDay("55"));

        //upload photo

        //click submit button
        appManager.getUser().clickSubmitForm();

        //check the car was added
        //Don't know how to read status and message from browser console log
        Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());

    }

}
