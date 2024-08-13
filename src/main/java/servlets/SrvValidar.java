package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;
import utilesDB.utilFecha.UtlFecTime;

@WebServlet(name = "SrvValidar", urlPatterns = {"/SrvValidar"})
public class SrvValidar extends HttpServlet {
  
  Controladora miControl = new Controladora();

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
  }


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String valUsuario = request.getParameter("txtUsuario");
    String valPassword = request.getParameter("txtPassword");
    
    //boolean validado = false;
    
    Usuario valUsu = miControl.validaUsuAdmin (valUsuario, valPassword);
    
    if (valUsu == null) {
      //error
      response.sendRedirect("errorLogon.jsp");
    } else {
      //Actualizar e lultimo logon del Usuario
      valUsu.setUsr_ultlogon(UtlFecTime.getFeHora());
      miControl.modiUsu (valUsu);
      
      
      HttpSession miSession = request.getSession(true);
      miSession.setAttribute("usuLogon", valUsu.getUsr_alias());
      response.sendRedirect("redirnomas.jsp");
    }
    
    //processRequest(request, response);
  }


  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
