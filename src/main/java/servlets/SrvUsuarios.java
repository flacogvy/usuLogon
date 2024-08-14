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
import logica.CodTabla;
import logica.Controladora;
import logica.Persona;
import logica.RegPrincipal;
import logica.Usuario;


@WebServlet(name = "SrvUsuarios", urlPatterns = {"/SrvUsuarios"})
public class SrvUsuarios extends HttpServlet {
  
  private Controladora miControl = new Controladora();


  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    
  }

  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String strFiltro = request.getParameter("txtFiltroUsu");
    
    List<Usuario> lisUsuarios = miControl.getUsuFiltro (strFiltro.toUpperCase());
    
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
    
    response.sendRedirect("principal.jsp");
    
  }

  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    //ALTA DE USUARIOS******************
    String tipDoc = request.getParameter("cboTipoDoc");
    String numDoc = request.getParameter("txtNumDoc");
    String nomUsu = request.getParameter("txtNombre");
    String patUsu = request.getParameter("txtPaterno");
    String matUsu = request.getParameter("txtMaterno");
    String aliUsu = request.getParameter("txtAlias");
    String tipUsu = request.getParameter("cboTipoUser");
    String estUsu = request.getParameter("cboEstUser");
    String pasUsu = request.getParameter("txtPassword");
    
    Usuario miUsu = null;
    String  zMensa  = miControl.creaUsuPer (tipDoc, numDoc, nomUsu, patUsu, matUsu,
            aliUsu, tipUsu, estUsu, pasUsu, miUsu);
    
    HttpSession miSes = request.getSession();
    if (miUsu == null )  {
      miSes.setAttribute("txtMensa", zMensa);
    } else {
      miSes.setAttribute("txtMensa", "EXI-Usuario Creado con Exito");
    }
    
    List<Usuario> listaUsu = miControl.getUsuFiltro("");
    ArrayList<RegPrincipal> lstUsu = new ArrayList<> ();
    
    for (Usuario usuTmp : listaUsu) {
      String nombre = miControl.getNombrePer(usuTmp.getPer_id());
      Persona perLocal = miControl.getPersona (usuTmp.getPer_id());
      
      lstUsu.add(new RegPrincipal (usuTmp.getUsr_id(), usuTmp.getPer_id(), 
              usuTmp.getUsr_alias(), perLocal.getPer_tipdoc(), perLocal.getPer_numcod(),
              nombre, usuTmp.getUsr_estado(), usuTmp.getUsr_tipo(),
      usuTmp.getUsr_ultlogon()));
      
    }
    
    miSes.setAttribute("lstUsuarios", lstUsu);
    
    response.sendRedirect("principal.jsp");
    
  }

  
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
