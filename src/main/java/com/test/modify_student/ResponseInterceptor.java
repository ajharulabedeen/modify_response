package com.test.modify_student;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ResponseInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper;

    public ResponseInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // This method is called after the view is rendered.
        // Here you can modify the response.
        // For example, setting custom headers or modifying the response body.
        Object responseBody = request.getAttribute("RESPONSE_BODY");
        if (responseBody instanceof Student) {
            Student student = (Student) responseBody;
            if (student.getStudentNumber() < 50) {
                student.setStudentNumber(50);
                // Rewrite the response body with the modified Student object
                response.getOutputStream().write(objectMapper.writeValueAsBytes(student));
            }
        }
    }
}
