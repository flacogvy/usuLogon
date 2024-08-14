<%@page import="logica.RegPrincipal"%>
<%@page import="utilesDB.utilFechFMT.FechFmto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <%@include file="/componentes/header.jsp" %>
  <%@include file="/componentes/body.jsp" %>
  <div id="layoutSidenav_content">
    <%      String mensaje = (String) request.getSession().getAttribute("txtMensa");
      if (mensaje == null) {
        mensaje = "";
      }

      request.getSession().setAttribute("txtMensa", "");
      //List<Usuario> lstUsuarios = (List<Usuario>) request.getSession().getAttribute("lstUsuarios");
      ArrayList<RegPrincipal> lista = (ArrayList<RegPrincipal>) request.getSession().getAttribute("lstUsuarios");

    %>
    <main>
      <div class="container-fluid px-4">
        <h1 class="mt-4">Gestion de Usuarios</h1>
        <% if (mensaje.length() != 0) { %>
        <div id="zmensa">
          <% if (mensaje.substring(0, 3).equals("ERR")) {%>
          <p style="background-color: red"> <%= mensaje.substring(4)%> </p>
          <% } else {%>
          <p style="background-color: cyan"> <%= mensaje.substring(4)%> </p>
          <% }      %>
        </div>
        <% } %>
        <ol class="breadcrumb mb-4">
          <li class="breadcrumb-item active">Usuarios</li>
        </ol>
        <div class="card mb-4">
          <div class="card-header">
            <form name="frmNuevo" method="GET" action="SrvCargaInfo">
              <i class="fas fa-table me-2"></i>
              Detalle de Usuarios &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <button type="submit" class="btn btn-primary">Nuevo Usuario</button>
            </form>
          </div>
          <div class="card-body">
            <table id="datatablesSimple">
              <thead>
                <tr>
                  <th>Alias</th>
                  <th>Tipo Doc</th>
                  <th>Num Doc</th>
                  <th>Nombre</th>
                  <th>Tipo Usuario</th>
                  <th>Estado</th>
                  <th>Ultimo Logon</th>
                  <th>&nbsp;</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Alias</th>
                  <th>Tipo Doc</th>
                  <th>Num Doc</th>
                  <th>Nombre</th>
                  <th>Tipo Usuario</th>
                  <th>Estado</th>
                  <th>Ultimo Logon</th>
                  <th>&nbsp;</th>
                </tr>
              </tfoot>
              <tbody>
                <%
                  for (RegPrincipal miReg : lista) {
                %>
                <tr>
                  <td><%= miReg.getAliasUsu()%></td>
                  <td><%= miReg.getTipoDoc()%></td>
                  <td><%= miReg.getNumDoc()%></td>
                  <td><%= miReg.getNombreUsu()%></td>
                  <td><%= miReg.getTipoUus()%></td>
                  <td><%= miReg.getEstadoUsu()%></td>
                  <td><%= FechFmto.feHoraPnt(miReg.getUltLogonUsu())%></td>
                  <td style="display:flex; width: 230px;">
                    <table>
                      <tr>
                        <td>
                      <form name="eliminar" method="GET" action="SvElimUsuario">
                        <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: #dc3545; margin-right: 5px" title="Eliminar">
                          <i class="fas fa-trash-alt"></i> 
                        </button>
                        <input type="hidden" name="txtIdPer" value="<%= miReg.getIdPersona()%>">
                        <input type="hidden" name="txtIdUsu" value="<%= miReg.getIdUsuario()%>">
                      </form>
                        </td><td>
                      <form name="modificar" method="GET" action="SvEditUsuario">
                        <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px" title="Modificar">
                          <i class="fas  fa-pen-alt"></i> 
                        </button>
                        <input type="hidden" name="txtIdPer" value="<%= miReg.getIdPersona()%>">
                        <input type="hidden" name="txtIdUsu" value="<%= miReg.getIdUsuario()%>">
                      </form>
                      </td></tr>
                    </table>
                  </td>
                </tr>

                <%
                  }
                %>


              </tbody>
            </table>
          </div>
        </div>
      </div>
    </main>
    <footer class="py-4 bg-light mt-auto">
      <div class="container-fluid px-4">
        <div class="d-flex align-items-center justify-content-between small">
          <div class="text-muted">Copyright &copy; Your Website 2023</div>
          <div>
            <a href="#">Privacy Policy</a>
            &middot;
            <a href="#">Terms &amp; Conditions</a>
          </div>
        </div>
      </div>
    </footer>
  </div>

  <%@include file="/componentes/footer.jsp" %>
</html>