package com.test.modify_student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(HttpServletRequest request) {
        // Return a student with a student number below 50 for demonstration purposes
        Student student = new Student("John Doe", 30);
        // Set the RESPONSE_BODY attribute in the request
        request.setAttribute("RESPONSE_BODY", student);
        return student;
    }
}
