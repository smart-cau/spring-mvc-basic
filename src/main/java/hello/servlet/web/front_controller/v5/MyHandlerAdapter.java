package hello.servlet.web.front_controller.v5;

import hello.servlet.web.front_controller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    // handler adapter 목록에서 처리할 수 있는 adapter를 발견하면 true, 그렇지 못하면 false
    boolean supports(Object handler); // handler는 controller를 말함.

    // 실제 컨트롤러를 호출하고, 그 결과로 ModelView를 반환
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
