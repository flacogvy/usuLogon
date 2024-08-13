
<%@page import="java.util.ArrayList"%>
<%@page import="logica.CodTabla"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <%@include file="/componentes/header.jsp" %>
  <%@include file="/componentes/body.jsp" %>

  <%
  HttpSession miSesion = request.getSession();
  //lista de tipos de DOcumento
  List <CodTabla> lisTipD = (List <CodTabla>) miSesion.getAttribute("lstTablaTipDoc");
  ArrayList<CodTabla> lstTipD = new ArrayList<> (lisTipD);
  List <CodTabla> lisEstUsu = (List <CodTabla>) miSesion.getAttribute("lstTablaEstado");
  ArrayList<CodTabla> lstEstUsu = new ArrayList<> (lisEstUsu);
  List <CodTabla> lisTipUsu = (List <CodTabla>) miSesion.getAttribute("lstTablaTipo");
  ArrayList <CodTabla> lstTipUsu = new ArrayList<> (lisTipUsu);
  
  %>
  
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-7">
        <div class="card shadow-lg border-0 rounded-lg mt-5">
          <div class="card-header"><h3 class="text-center font-weight-light my-4">Crear Usuario</h3></div>
          <div class="card-body">
            <form name="frmCreaUsuario" method="POST" action="SrvUsuarios">
              <div class="row mb-3">
                <div class="col-md-6">
                    Tipo Documento:
                    <br>
                    <select id="cboTipoDoc" name="cboTipoDoc" class="form-select">
                      <option value="">Seleccione Tipo Documento</option>
                      <% for (CodTabla miItem : lstTipD) { %>
                      <option value="<%= miItem.getCtaOpcion()  %>"><%= miItem.getCtaDescripcion() %></option>
                      <% } %>
                    </select>
                </div>
                <div class="col-md-6">
                  <div class="form-floating">
                    <input class="form-control" id="txtNumDoc" name="txtNumDoc" type="number" placeholder="Numero de Documento" />
                    <label for="txtNumDoc">Numero Documento:</label>
                  </div>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-6">
                  <div class="form-floating mb-3 mb-md-0">
                    <input class="form-control" id="txtNombre" name="txtNombre" type="text" placeholder="Ingrese Nombre" />
                    <label for="txtNombre">Nombre</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-floating">
                    <input class="form-control" id="txtPaterno" name="txtPaterno" type="text" placeholder="Ingrese Paterno" />
                    <label for="txtPaterno">Paterno</label>
                  </div>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-6">
                  <div class="form-floating mb-3 mb-md-0">
                    <input class="form-control" id="txtMaterno" name="txtMaterno" type="text" placeholder="Ingese Materno" />
                    <label for="inputFirstName">Materno</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-floating">
                    <input class="form-control" id="txtAlias" name="txtAlias" type="text" placeholder="Ingrese Alias" />
                    <label for="txtAlias">Alias</label>
                  </div>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-6">
                    Tipo de Usuario:
                    <select id="cboTipoUser" name="cboTipoUser" class="form-select">
                      <option selected>Seleccione un Tipo</option>
                      <% for (CodTabla miItem : lstTipUsu) { %>
                      <option value="<%= miItem.getCtaOpcion()  %>"><%= miItem.getCtaDescripcion() %></option>
                      <% } %>
                    </select>

                </div>
                <div class="col-md-6">
                  Estado Usuario:
                  <select id="cboEstUser" name="cboEstUser" class="form-select">
                      <option selected>Seleccione un Estado</option>
                      <% for (CodTabla miItem : lstEstUsu) { %>
                      <option value="<%= miItem.getCtaOpcion()  %>"><%= miItem.getCtaDescripcion() %></option>
                      <% } %>
                    </select>
                </div>
              </div>
                    
              <div class="row mb-3">
                <div class="col-md-6">
                  <div class="form-floating mb-3 mb-md-0">
                    <input class="form-control" id="txtPassword" name="txtPassword" type="password" placeholder="Password" />
                    <label for="txtPassword">Password</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-floating mb-3 mb-md-0">
                    <input class="form-control" id="txtConfPass" name="txtConfPass" type="password" placeholder="Confirma password" />
                    <label for="txtConfPass">Confirm Password</label>
                  </div>
                </div>
              </div>
              <div class="mt-4 mb-0">
                <div class="d-grid">
                  <button class="btn btn-primary btn-block" type="button" onclick="validaForm()"> Crear Usuario </button>
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
    function validaForm () {
      if (document.frmCreaUsuario.cboTipoDoc.value == "") {
        alert ("Debe llenar el campo Tipo Documento");
        document.frmCreaUsuario.cboTipoDoc.focus();
        return ;
      }
      if (document.frmCreaUsuario.txtNumDoc.value == "") {
        alert ("Debe llenar el campo Numero Documento");
        document.frmCreaUsuario.txtNumDoc.focus();
        return ;
      }
      if (document.frmCreaUsuario.txtNombre.value == "") {
        alert ("Debe llenar el campo Nombre");
        document.frmCreaUsuario.txtNombre.focus();
        return ;
      }
      if (document.frmCreaUsuario.txtPaterno.value == "") {
        alert ("Debe llenar el campo Paterno");
        document.frmCreaUsuario.txtPaterno.focus();
        return ;
      }
      if (document.frmCreaUsuario.txtAlias.value == "") {
        alert ("Debe llenar el campo Alias");
        document.frmCreaUsuario.txtAlias.focus();
        return ;
      }
      if (document.frmCreaUsuario.cboTipoUser.value == "") {
        alert ("Debe llenar el campo Tipo Usuario");
        document.frmCreaUsuario.cboTipoUser.focus();
        return ;
      }
      if (document.frmCreaUsuario.cboEstUser.value == "") {
        alert ("Debe llenar el campo Estado");
        document.frmCreaUsuario.cboEstUser.focus();
        return ;
      }
      if (document.frmCreaUsuario.txtPassword.value == "" || 
              document.frmCreaUsuario.txtPassword.value != document.frmCreaUsuario.txtConfPass.value) {
        alert ("Los campos Password deben ser iguales y no vacios");
        document.frmCreaUsuario.txtPassword.focus();
        return ;
              }
      
    document.frmCreaUsuario.submit();
      
    }
  </script>
  
</html>
