package com.cjc; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Project 
{
public WebDriver driver ;

Properties pro=new Properties();
static Logger log=Logger.getLogger(Project.class.getName());

@BeforeSuite

public void chrome() throws IOException {
	
	FileInputStream f=new FileInputStream("I:\\class\\MavenTestNGProject\\config.properties");
	pro.load(f);
	
	System.out.println("before suit start");
	System.setProperty("webdriver.chrome.driver", pro.getProperty("browser"));
	driver = new ChromeDriver();
	System.out.println("before suite end");
}
	
@BeforeTest
public void beforeTest (){
	System.out.println("before test start");
	driver.get(pro.getProperty("url"));
	System.out.println("before test end");

}
@BeforeClass
public void beforeClass() {
	System.out.println("before class start");
	driver.manage().window().maximize();
	System.out.println("before class end");
}
@Test
public void login() {
	System.out.println("@Test method start");

	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("cjc1");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("pass1");
	driver.findElement(By.xpath("//input[@name='login']")).click();
	driver.findElement(By.linkText("SIGN-OFF")).click();
}

}


