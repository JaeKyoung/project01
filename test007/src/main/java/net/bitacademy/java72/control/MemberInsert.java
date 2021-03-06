package net.bitacademy.java72.control;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;
import net.bitacademy.java72.util.MultipartDataProcessor;

public class MemberInsert extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {

    // 필터로 대체한다.
    //request.setCharacterEncoding("UTF-8");
    
    ApplicationContext context = 
        (ApplicationContext)this.getServletContext()
           .getAttribute("beanContainer");
    
    MemberDao memberDao = 
        (MemberDao)context.getBean("memberDao");
    Map<String, String> paramMap = null;
    
    try {
      paramMap = MultipartDataProcessor.toParamMap("/files", request);
    } catch (Exception e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
    
    Member member = new Member();
    member.setName(paramMap.get("name"));
    member.setEmail(paramMap.get("email"));
    member.setTel(paramMap.get("tel"));
    member.setPassword(paramMap.get("password"));
    member.setPhoto(paramMap.get("photo"));

    try {
      memberDao.insert(member);
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/error");

      //ServletRequest에 전달할 객체를 저장한다.
      request.setAttribute("error", e);
      
      rd.forward(request, response);
      return;
    }
    
    response.sendRedirect("list.do");
  }

}
