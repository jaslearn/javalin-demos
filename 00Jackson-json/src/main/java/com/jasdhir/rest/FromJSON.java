package com.jasdhir.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FromJSON {
public static void main(String[] args) {
	String student="{\"id\":1,\"name\":\"Jasdhir\",\"age\":42}";
	ObjectMapper om = new ObjectMapper();
	Student s1 = null;
	try {
		s1 = om.readValue(student, Student.class);
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println(s1);
}

}
