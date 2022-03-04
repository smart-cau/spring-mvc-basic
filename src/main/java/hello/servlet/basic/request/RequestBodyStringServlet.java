package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // byte code 형식
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // UTF_8 형식으로 Byte code를 string으로 변환

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("Ok");

    }
}
