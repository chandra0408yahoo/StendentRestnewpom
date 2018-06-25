package com.studentapp.junit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.testbase.BaseClass;
import com.studentapp.utils.ReuseableSpecifications;
import com.studentapp.utils.StudentClass;
import com.studentapp.utils.StudentSerenitySteps;
import com.studentapp.utils.utilcommon;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;



@RunWith(SerenityRunner.class)
public class SerenityStudentCrudTest extends BaseClass {

	
	static String firstname=utilcommon.randomgen()+"Smokeuser";
	static String lastname=utilcommon.randomgen()+"SmokeLastname";
	static String email=utilcommon.randomgen()+"sd@yahoo.com";
	static String programme=utilcommon.randomgen()+"ece";
	static int studentId;
	
	@Steps
	StudentSerenitySteps steps;

	@Title("posting a new value")
	@Test
	public void test001() {

		
		ArrayList<String>course= new ArrayList<String>();
		course.add("java");
		course.add("c");
		
		/*StudentClass student = new StudentClass();
		student.setFirstName(firstname);
		student.setLastName(lastname);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(course);*/
		
		steps.createStudent(firstname,lastname,email,programme,course).statusCode(201)
		.spec(ReuseableSpecifications.getGenericResponseSpec());
	}
	
	
	
	@Title("retreving value for verification")
	@Test
	public void test002() {


		HashMap<String, Object> value1	=steps.getStudentverifiabledata(firstname);
		System.out.println("the value is"+value1);
		
	studentId = (Integer) value1.get("id");
	System.out.println(value1.get("id"));
	System.out.println(studentId);
	
	
	}
	
	@Title("updating using put")
	@Test
public void test003() {

		ArrayList<String>courses= new ArrayList<String>();
		courses.add("java");
		courses.add("c");


		steps.studentupdate(studentId,firstname,lastname,email,programme,courses).statusCode(200)
		.spec(ReuseableSpecifications.getGenericResponseSpec());
	}

	
}
