package com.test.modify_student;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class ResponseInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Intercept the response and modify it if necessary
        ContentCaptureResponseWrapper responseWrapper = new ContentCaptureResponseWrapper(response);

        // Pass the wrapped response to the next interceptor or the servlet
        responseWrapper.flushBuffer();
    }

    private static class ContentCaptureResponseWrapper extends HttpServletResponseWrapper {
        private ByteArrayOutputStream content;

        public ContentCaptureResponseWrapper(HttpServletResponse response) {
            super(response);
            content = new ByteArrayOutputStream();
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return new PrintWriter(content);
        }

        @Override
        public void flushBuffer() throws IOException {
            super.flushBuffer();
            byte[] byteArray = content.toByteArray();
            String responseBody = new String(byteArray);

            // Modify the response body as needed
            // For simplicity, let's just print the original and modified response body here
            System.out.println("Original Response Body: " + responseBody);

            // Modify the response body
            String modifiedResponseBody = modifyResponseBody(responseBody);
            System.out.println("Modified Response Body: " + modifiedResponseBody);

            // Write the modified response body to the output stream
            getResponse().getOutputStream().write(modifiedResponseBody.getBytes());
        }

        private String modifyResponseBody(String responseBody) {
            // Your logic to modify the response body goes here
            // For example, you can use regex or JSON parsing to locate and modify specific values
            // Remember, in this example, responseBody is a string representation of the response content
            // You need to parse it as JSON and modify the studentNumber property accordingly
            // Then, serialize it back to a string
            return responseBody.replace("\"studentNumber\":30", "\"studentNumber\":50");
        }
    }
}
