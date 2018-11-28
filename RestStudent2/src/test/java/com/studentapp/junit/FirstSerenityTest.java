package com.studentapp.junit;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.studentapp.testbase.BaseClass;
import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;




@RunWith(SerenityRunner.class)
public class FirstSerenityTest extends BaseClass{

	
	
	
	
	@Test
	@Title("Get all data")
	public  void test001() {
		
		SerenityRest.given().when().get("/list").
		then().log().all().statusCode(200);
	}
	
	/*@Title("verify error test")
	@Test
	public  void test002() {
		
		RestAssured.given().when().get("/student/list").
		then().log().all().statusCode(300);
	}
	
	@Ignore
	@Title("third data")
	@Test
	public  void test003() {
	System.out.println("third test");	
	}
	
	@Pending
	@Title("fourth test")
	@Test
	public  void test004() {
		System.out.println("fourth test");	
	}
	
	@Manual
	@Title("Fifth test")
	@Test
	public  void test005() {
		System.out.println("fifth test");
		
	}
	
	
*/	
}
