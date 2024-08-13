<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Control de Usuarios</title>
  </head>
  <body>
    <%
      HttpSession sesValidacion = request.getSession();
      String usuValido = (String) sesValidacion.getAttribute("usuLogon");
      if (usuValido == null) {
        response.sendRedirect("logon.jsp");
      } else {
        // todo bien
      }

    %>

    <h1>Ingresando al sistema....</h1>
    <form name="frmNada" id="frmNada" action="SrvUsuarios" method="GET">
      <input type="hidden" name="txtFiltroUsu" id="txtFiltroUsu" value="" />
    </form>
  </body>
  <script>
    document.frmNada.submit();
  </script>
</html>
