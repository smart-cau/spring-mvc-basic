package hello.servlet.basic.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // [Status Line]
        response.setStatus(HttpServletResponse.SC_OK); // 200 대신 상수 사용

        // [Response Headers]
//        response.setHeader("Content-Type", "text/plain;charset=utf-8"); // content() 메서드와 같은 역할
        response.setHeader("Cache-Control", "no-cache, no-store, muset-revalidate");
        response.setHeader("Pragma", "no-cache"); // cache 무효화 -> HTTP 강의 참고
        response.setHeader("my-header", "hello");

        // [Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);

        // [Message Body]
        PrintWriter writer = response.getWriter();
        writer.println("Ok");
    }

    // Content 편의 메서드
    private void content(HttpServletResponse response) {
        // Content-Type: text/plain;charset=utf-8
        // Content-Length: 2
        // response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        // response.setContentLength(2); //(생략시 자동 생성)
    }


    // Cookie 편의 메서드
    private void cookie(HttpServletResponse response) {
        // Set-Cookie: myCookie=good; Max-Age=600;
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    // Redirect 편의 메서드
    private void redirect(HttpServletResponse response) throws IOException {
        // Status Code 302
        // Location: /basic/hello-form.html
//         response.setStatus(HttpServletResponse.SC_FOUND); // 302
//         response.setHeader("Location", "/basic/hello-form.html");

        // 위 두 줄의 역할을 함
        response.sendRedirect("/basic/hello-form.html");
    }

}
