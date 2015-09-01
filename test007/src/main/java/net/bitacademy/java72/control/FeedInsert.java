package net.bitacademy.java72.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.FeedDao;
import net.bitacademy.java72.domain.Feed;

@WebServlet("/feed/insert.do")
public class FeedInsert extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    ApplicationContext context = (ApplicationContext) this.getServletContext().getAttribute("beanContainer");

    FeedDao feedDao = (FeedDao) context.getBean("feedDao");
    List<Feed> feeds = null;

    try {
      feeds = feedDao.list();
      request.setAttribute("feeds", feeds);
      // JSP로 출력을 위임한다.
      RequestDispatcher rd = request.getRequestDispatcher("/feed/FacebookUI.jsp");
      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response);
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");

      // ServletRequest에 전달할 객체를 저장한다.
      request.setAttribute("error", e);

      rd.forward(request, response);
      return;
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    /*
    Map<String, String> paramMap = null;
    try {
      paramMap = MultipartDataProcessor.toParamMap("/files", request);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    */

    String[] friends = request.getParameterValues("feedFriends");
    //System.out.println(friends[0]);

    //System.out.println(friends);
    
    
    if(friends != null) {
      String friendsConcat = "";
      int i=0;
      for(String friend : friends) {
        friendsConcat += friend;
        i++;
        if(friends.length != i) {
          friendsConcat += ",";
        }
      }
      request.setAttribute("friends", friendsConcat);
    }
    
    
    doGet(request, response);
  }
}
