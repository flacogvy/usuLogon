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
import utilesDB.utilFecha.UtlFecTime;


@WebServlet(name = "SvEditUsuario", urlPatterns = {"/SvEditUsuario"})
public class SvEditUsuario extends HttpServlet {
  
  private Controladora miControl = new Controladora();

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
  }


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    Long idPersona = Long.parseLong(request.getParameter("txtIdPer"));
    Long idUsuario = Long.parseLong(request.getParameter("txtIdUsu")) ;
    
    Persona miPersona = miControl.getPersona(idPersona);
    
    Usuario miUsuario = miControl.getUsuario(idUsuario);
    
    HttpSession laSession  = request.getSession();
    laSession.setAttribute("perEdit", miPersona);
    laSession.setAttribute("usuEdit", miUsuario);

    List<CodTabla> lisEstUsu = miControl.listTabla("EUS");
    laSession.setAttribute("lstTablaEstado", lisEstUsu);

    List<CodTabla> lisTipUsu = miControl.listTabla("TUS");
    laSession.setAttribute("lstTablaTipo", lisTipUsu);
    
    response.sendRedirect("editUsuario.jsp");
    
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    String usuActivo = (String) request.getSession().getAttribute("usuLogon");
    
    Long idEdtPersona = Long.valueOf(request.getParameter("txtIdPersona"));
    Long idEdtUsuario = Long.valueOf(request.getParameter("txtIdUsuario"));
    
    Persona perCambio = miControl.getPersona(idEdtPersona);
    Usuario usuCambio = miControl.getUsuario(idEdtUsuario);
    
    //Hacer los cambios
    perCambio.setPer_nombre(request.getParameter("txtNombre"));
    perCambio.setPer_paterno(request.getParameter("txtPaterno"));
    perCambio.setPer_materno(request.getParameter("txtMaterno"));
    perCambio.setPer_fehomodi(UtlFecTime.getFeHora());
    
    perCambio.setPer_usumodi(usuActivo);
    perCambio.setPer_modmodi("SvEditUsuario");
    
    miControl.modiPersona (perCambio);
    
    //Hacer los cambios en Usuario
    usuCambio.setUsr_estado(request.getParameter("cboEstUser"));
    usuCambio.setUsr_tipo(request.getParameter("cboTipoUser"));
    usuCambio.setUsr_fehomodi(UtlFecTime.getFeHora());
    
    usuCambio.setUsr_usumodi(usuActivo);
    usuCambio.setUsr_modmodi("SvEditUsuario");
    
    miControl.modiUsu(usuCambio);
    
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
    
    response.sendRedirect("principal.jsp");
    
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
