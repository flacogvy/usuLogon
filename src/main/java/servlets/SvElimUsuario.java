package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Persona;
import logica.RegPrincipal;
import logica.Usuario;


@WebServlet(name = "SvElimUsuario", urlPatterns = {"/SvElimUsuario"})
public class SvElimUsuario extends HttpServlet {
  
  Controladora miControl = new Controladora();

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    
  }

  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    Long idPersona = Long.parseLong(request.getParameter("txtIdPer"));
    Long idUsuario = Long.parseLong(request.getParameter("txtIdUsu")) ;
    
    System.out.println("idPersona: " + idPersona + "-idUsuario:" + idUsuario);
    
    Persona miPersona = miControl.getPersona(idPersona);
    
    Usuario miUsuario = miControl.getUsuario(idUsuario);
    
    
    HttpSession laSession  = request.getSession();
    laSession.setAttribute("perElim", miPersona);
    laSession.setAttribute("usuElim", miUsuario);
    
    response.sendRedirect("elimUsuario.jsp");
    
  }

  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    Long idUsuario = Long.parseLong(request.getParameter("txtIdUsu")) ;
    // se elimina el Usuario y no la persona
    miControl.elimUsuario (idUsuario);
    
    // datos para pantalla
    List<Usuario> lisUsuarios = miControl.getUsuFiltro ("");
    
    /*armar la informacion para reporte*/
    ArrayList<RegPrincipal> lstRegistro = new ArrayList<>() ;
    
    for (Usuario usuTmp : lisUsuarios) {
      String nombre = miControl.getNombrePer(usuTmp.getPer_id());
      Persona perLocal = miControl.getPersona (usuTmp.getPer_id());
      
      lstRegistro.add(new RegPrincipal (usuTmp.getUsr_id(), usuTmp.getPer_id(), 
              usuTmp.getUsr_alias(), perLocal.getPer_tipdoc(), perLocal.getPer_numcod(),
              nombre, usuTmp.getUsr_estado(), usuTmp.getUsr_tipo(),
      usuTmp.getUsr_ultlogon()));
      
    }
    
    HttpSession miSesion = request.getSession();
    
    miSesion.setAttribute("lstUsuarios", lstRegistro);
    miSesion.setAttribute("txtMensa", "EXI-Usuario Eliminado (Registro de Persona activo aun.)");
    
    response.sendRedirect("principal.jsp");
    
  }

  
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
