<%@page import="java.util.ArrayList"%>
<%@page import="logica.CodTabla"%>
<%@page import="java.util.List"%>
<%@page import="logica.ControlCodTabla"%>
<%@page import="logica.Usuario"%>
<%@page import="logica.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <%@include file="/componentes/header.jsp" %>
  <%@include file="/componentes/body.jsp" %>

  <%    HttpSession miSesion = request.getSession();

    Persona editPersona = (Persona) miSesion.getAttribute("perEdit");
    Usuario editUsuario = (Usuario) miSesion.getAttribute("usuEdit");

    String tipDoc = editPersona.getPer_tipdoc() + "-"
            + ControlCodTabla.getDescTabla("TDC", editPersona.getPer_tipdoc());

    //lista de tipos de DOcumento
    List<CodTabla> lisEstUsu = (List<CodTabla>) miSesion.getAttribute("lstTablaEstado");
    ArrayList<CodTabla> lstEstUsu = new ArrayList<>(lisEstUsu);
    List<CodTabla> lisTipUsu = (List<CodTabla>) miSesion.getAttribute("lstTablaTipo");
    ArrayList<CodTabla> lstTipUsu = new ArrayList<>(lisTipUsu);

  %>

  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-7">
        <div class="card shadow-lg border-0 rounded-lg mt-5">
          <div class="card-header"><h3 class="text-center font-weight-light my-4">Crear Usuario</h3></div>
          <div class="card-body">
            <form name="frmEditUsuario" method="POST" action="SvEditUsuario">
              <input name="txtIdPersona" id="txtIdPersona" type="hidden" value="<%= editPersona.getPer_id()  %>"  />
              <input name="txtIdUsuario" id="txtIdUsuario" type="hidden" value="<%= editUsuario.getUsr_id() %>"  />
              <div class="row mb-3">
                <div class="col-md-6">
                  Tipo Documento:
                  <br>
                  <input class="form-control" type="text" value="<%= tipDoc%>" disabled="true"/>
                </div>
                <div class="col-md-6">
                  Numero Documento:  <br>
                  <input class="form-control" type="text" value="<%= editPersona.getPer_numcod()%>" disabled="true"/>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-6">
                  <div class="form-floating mb-3 mb-md-0">
                    <input class="form-control" id="txtNombre" name="txtNombre" type="text" 
                           placeholder="Ingrese Nombre" value="<%= editPersona.getPer_nombre() %>"/>
                    <label for="txtNombre">Nombre</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-floating">
                    <input class="form-control" id="txtPaterno" name="txtPaterno" type="text" 
                           placeholder="Ingrese Paterno" value="<%= editPersona.getPer_paterno() %>" />
                    <label for="txtPaterno">Paterno</label>
                  </div>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-6">
                  <div class="form-floating mb-3 mb-md-0">
                    <input class="form-control" id="txtMaterno" name="txtMaterno" type="text" 
                           placeholder="Ingese Materno" value="<%= editPersona.getPer_materno() %>" />
                    <label for="inputFirstName">Materno</label>
                  </div>
                </div>
                <div class="col-md-6">
                  Alias:   <br>
                  <input class="form-control" type="text" value="<%= editUsuario.getUsr_alias() %>" disabled="true"/>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-6">
                  Tipo de Usuario:
                  <select id="cboTipoUser" name="cboTipoUser" class="form-select">
                    <option <% if (editUsuario.getUsr_tipo().equals("")) {  %> selected
                      <% } %> >Seleccione un Tipo</option>
                    <% for (CodTabla miItem : lstTipUsu) {%>
                    <option value="<%= miItem.getCtaOpcion()%>" 
                            <% if (editUsuario.getUsr_tipo().equals(miItem.getCtaOpcion())) { %>
                            selected
                            <%  } %>
                            >
                      <%= miItem.getCtaDescripcion()%>
                    </option>
                    <% } %>
                  </select>

                </div>
                <div class="col-md-6">
                  Estado Usuario:
                  <select id="cboEstUser" name="cboEstUser" class="form-select">
                    <option <% if (editUsuario.getUsr_estado().equals(""))  { %>>
                      selected   
                      <%  } %>
                      Seleccione un Estado</option>
                    <% for (CodTabla miItem : lstEstUsu) {%>
                    <option value="<%= miItem.getCtaOpcion()%>"  
                            <% if (editUsuario.getUsr_estado().equals(miItem.getCtaOpcion())) { %> 
                            selected
                            <% } %>
                            >
                      <%= miItem.getCtaDescripcion()%>
                    </option>
                    <% }%>
                  </select>
                </div>
              </div>

              <div class="mt-4 mb-0">
                <div class="d-grid">
                  <button class="btn btn-primary btn-block" type="button" onclick="validaForm()"> Modificar Usuario </button>
                </div>
              </div>
            </form>
          </div>
          <div class="card-footer text-center py-3">
            <div class="small"><a href="login.html">Have an account? Go to login</a></div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <%@include file="/componentes/footer.jsp" %>

  <script>
    function validaForm() {
      if (document.frmEditUsuario.txtNombre.value === "") {
        alert("Debe llenar el campo Nombre");
        document.frmCreaUsuario.txtNombre.focus();
        return;
      }
      if (document.frmEditUsuario.txtPaterno.value === "") {
        alert("Debe llenar el campo Paterno");
        document.frmCreaUsuario.txtPaterno.focus();
        return;
      }
      if (document.frmEditUsuario.cboTipoUser.value === "") {
        alert("Debe llenar el campo Tipo Usuario");
        document.frmCreaUsuario.cboTipoUser.focus();
        return;
      }
      if (document.frmEditUsuario.cboEstUser.value === "") {
        alert("Debe llenar el campo Estado");
        document.frmCreaUsuario.cboEstUser.focus();
        return;
      }

      document.frmEditUsuario.submit();

    }
  </script>

</html>
