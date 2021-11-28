package com.jasdhir.javalin.crud.controller;

import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

import com.jasdhir.javalin.crud.model.Student;

public class StudentController implements CrudHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private Map<String, Student> students = new HashMap<>();

    public void create(@NotNull Context context) {
        Student student = context.bodyAsClass(Student.class);
        LOGGER.info("Create a new student {}", student);
        this.students.put(student.getId(), student);
    }

    public void delete(@NotNull Context context, @NotNull String resourceId) {
        LOGGER.info("Delete the student {}", resourceId);
        this.students.remove(resourceId);
    }

    public void getAll(@NotNull Context context) {
        LOGGER.info("Get all students");
        context.json(students.values());
    }

    public void getOne(@NotNull Context context, @NotNull String resourceId) {
        LOGGER.info("Get the student {}", resourceId);
        Student student = this.students.get(resourceId);
        if (student != null) {
            context.json(student);
        }
    }

    public void update(@NotNull Context context, @NotNull String resourceId) {
        LOGGER.info("Update the student {}", resourceId);
        Student student = context.bodyAsClass(Student.class);
        this.students.put(resourceId, student);
    }
}
