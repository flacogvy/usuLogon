package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SrvSalir", urlPatterns = {"/SrvSalir"})
public class SrvSalir extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    
  }

  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    HttpSession miSession = request.getSession();
    //request.getSession().invalidate();
    miSession.setAttribute("usuLogon", "");
    response.sendRedirect("logon.jsp");
  }

  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  
  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
