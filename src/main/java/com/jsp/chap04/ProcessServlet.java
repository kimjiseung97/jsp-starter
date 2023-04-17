package com.jsp.chap04;

import com.jsp.repository.DancerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dancer/process")
public class ProcessServlet extends HttpServlet {
    //댄서 저장소를 의존해야한다

    private final DancerRepository repository = new DancerRepository();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // form에서 넘어온 데이터 읽기 (클라이언트 데이터 처리 : controller)
        //form에서 전송한데이터 한글처리
        request.setCharacterEncoding("UTF-8");

        // DancerRegisterViewServlet에서 전달된 파라미터 읽기
        String name = request.getParameter("name");
        String crewName = request.getParameter("crewName");
        String danceLevel = request.getParameter("danceLevel");
        String[] genresArray = request.getParameterValues("genres");




        //Dancer개체를 생성, 입력값 세팅 (business logic : model(자바객체))
        //데이터베이스에 저장 (business logic : model(자바객체)) -> 위임
        repository.save(name,crewName,danceLevel,genresArray);

        //댄서 목록을 브라우저에 출력(jsp : view) - 뷰 포워딩

    }
}
