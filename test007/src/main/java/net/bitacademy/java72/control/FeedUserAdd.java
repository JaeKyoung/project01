package net.bitacademy.java72.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Board;
import net.bitacademy.java72.domain.Member;
import net.bitacademy.java72.util.MultipartDataProcessor;

@WebServlet("/feed/useradd.do")
public class FeedUserAdd extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    ApplicationContext context = 
        (ApplicationContext)this.getServletContext()
           .getAttribute("beanContainer");
    
    MemberDao memberDao = 
        (MemberDao)context.getBean("memberDao");
    List<Member> members = null;
    
    try {
      members = memberDao.list();
      request.setAttribute("members", members);
      //JSP로 출력을 위임한다.
      RequestDispatcher rd = request.getRequestDispatcher("/feed/UserAddUI.jsp");
      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response);
      
      //boardDao.insert(board);
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
      return;
    }
    //response.sendRedirect("insert.do");
  }

}






