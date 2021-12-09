package com.jasdhir.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ToJSON {
public static void main(String[] args) {
	Student s=new Student(1,"Jasdhir",42);
	ObjectMapper om = new ObjectMapper();
    try {
        System.out.println(om.writeValueAsString(s));
    } catch(Exception e) {
        e.printStackTrace();
    }
}
}
