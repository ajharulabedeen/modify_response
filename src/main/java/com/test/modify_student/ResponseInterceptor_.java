//package com.test.modify_student_;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//
//
//@Component
//public class ResponseInterceptor implements HandlerInterceptor {
//
//    private final ObjectMapper objectMapper;
//
//    public ResponseInterceptor(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        // Get the response body as a string
//        String responseBody = response.getOutput().toString();
//
//        // Check if the response body is not empty
//        if (responseBody != null && !responseBody.isEmpty()) {
//            try {
//                // Parse the response body string to a JsonNode
//                JsonNode jsonNode = objectMapper.readTree(responseBody);
//
//                // Check if the jsonNode is an object and contains a property named "studentNumber"
//                if (jsonNode.isObject() && jsonNode.has("studentNumber")) {
//                    // Get the studentNumber property and check if it's a number
//                    JsonNode studentNumberNode = jsonNode.get("studentNumber");
//                    if (studentNumberNode.isNumber()) {
//                        // Update the studentNumber to 50
//                        ((ObjectNode) jsonNode).put("studentNumber", 50);
//
//                        // Serialize the modified JSON back to a string
//                        String modifiedResponse = objectMapper.writeValueAsString(jsonNode);
//
//                        // Write the modified response back to the response stream
//                        response.getOutputStream().write(modifiedResponse.getBytes());
//                    }
//                }
//            } catch (Exception e) {
//                // Handle any exceptions that occur during JSON processing
//                e.printStackTrace();
//            }
//        }
//    }
//
////    @Override
////    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
////        // This method is called after the view is rendered.
////        // Here you can modify the response.
////        // For example, setting custom headers or modifying the response body.
////        Object responseBody = request.getAttribute("RESPONSE_BODY");
////        if (responseBody instanceof Student) {
////            Student student = (Student) responseBody;
////            if (student.getStudentNumber() < 50) {
////                student.setStudentNumber(50);
////                // Rewrite the response body with the modified Student object
////                response.getOutputStream().write(objectMapper.writeValueAsBytes(student));
////            }
////        }
////    }
//}
