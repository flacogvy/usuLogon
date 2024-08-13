package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.CodTabla;
import logica.Controladora;

@WebServlet(name = "SrvCargaInfo", urlPatterns = {"/SrvCargaInfo"})
public class SrvCargaInfo extends HttpServlet {

  Controladora miControl = new Controladora();

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    HttpSession miSesion = request.getSession();

    // cargando datos de listas
    List<CodTabla> lisTipoDoc = miControl.listTabla("TDC");
    miSesion.setAttribute("lstTablaTipDoc", lisTipoDoc);

    List<CodTabla> lisEstUsu = miControl.listTabla("EUS");
    miSesion.setAttribute("lstTablaEstado", lisEstUsu);

    List<CodTabla> lisTipUsu = miControl.listTabla("TUS");
    miSesion.setAttribute("lstTablaTipo", lisTipUsu);

    response.sendRedirect("altaUsuario.jsp");

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
