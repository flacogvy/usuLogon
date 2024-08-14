<%@page import="logica.ControlCodTabla"%>
<%@page import="logica.Usuario"%>
<%@page import="logica.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <%@include file="/componentes/header.jsp" %>
  <%@include file="/componentes/body.jsp" %>

  <%    HttpSession miSesion = request.getSession();
    //Datos del Usuario

    Persona eliPersona = (Persona) miSesion.getAttribute("perElim");
    String tipDoc = eliPersona.getPer_tipdoc() + "-"
            + ControlCodTabla.getDescTabla("TDC", eliPersona.getPer_tipdoc());

    Usuario eliUsuari = (Usuario) miSesion.getAttribute("usuElim");
    String tipoUsu = eliUsuari.getUsr_tipo() + "-"
            + ControlCodTabla.getDescTabla("TUS", eliUsuari.getUsr_tipo());
    String estUsu = eliUsuari.getUsr_estado() + "-"
            + ControlCodTabla.getDescTabla("EUS", eliUsuari.getUsr_estado());


  %>

  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-7">
        <div class="card shadow-lg border-0 rounded-lg mt-5">
          <div class="card-header"><h3 class="text-center font-weight-light my-4">Eliminar Usuario</h3></div>
          <div class="card-body">
            <form name="frmEliUsuario" method="POST" action="SvElimUsuario">
              <input type="hidden" name="txtIdPer" value="<%= eliPersona.getPer_id() %>"/>
              <input type="hidden" name="txtIdUsu" value="<%= eliUsuari.getUsr_id() %>"/>
              <div class="row mb-3">
                <div class="col-md-6">
                  Tipo Documento:
                  <br>
                  <input class="form-control" value="<%= tipDoc%>" 
                         disabled="true"/>
                </div>
                <div class="col-md-6">
                  Numero Documento: <br> 
                  <input class="form-control" value="<%= eliPersona.getPer_numcod()%>" disabled="true"/>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-6">
                  Nombre: <br> 
                  <input class="form-control" value="<%= eliPersona.getPer_nombre()%>" disabled="true"/>
                </div>
                <div class="col-md-6">
                  Paterno: <br> 
                  <input class="form-control" value="<%= eliPersona.getPer_paterno()%>" disabled="true"/>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-6">
                  Materno: <br>
                  <input class="form-control" value="<%= eliPersona.getPer_materno()%>" disabled="true"/>
                </div>
                <div class="col-md-6">
                  Alias: <br>
                  <input class="form-control" value="<%= eliUsuari.getUsr_alias()%>" disabled="true"/>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-6">
                  Tipo de Usuario:
                  <BR>
                  <input class="form-control" value="<%= tipoUsu %>" disabled="true"/>
                </div>
                <div class="col-md-6">
                  Estado Usuario:
                  <BR>
                  <input class="form-control" value="<%= estUsu %>" disabled="true"/>
                </div>
              </div>
              <div class="mt-4 mb-0">
                <div class="d-grid">
                  <button class="btn btn-primary btn-block" type="submit" style="background-color: #dc3545;"> Eliminar Usuario </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <%@include file="/componentes/footer.jsp" %>

</html>
