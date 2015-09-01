package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

public class BoardList extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    ApplicationContext context = 
        (ApplicationContext)this.getServletContext()
           .getAttribute("beanContainer");
    
    BoardDao boardDao = 
        (BoardDao)context.getBean("boardDao");
    
    List<Board> boards = null;
    try {
      boards = boardDao.list();

      //보관소 
      request.setAttribute("boards", boards);
      
      //JSP로 출력을 위임한다.
      RequestDispatcher rd = request.getRequestDispatcher("/board/BoardList.jsp");
      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response);
      
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/error");
      
      //ServletRequest에 전달할 객체를 저장한다.
      request.setAttribute("error", e);
      
      rd.forward(request, response);
      return;
    }
  }
}



