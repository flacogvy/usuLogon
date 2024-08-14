<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body class="sb-nav-fixed">
  <%
    HttpSession sesValidacion = request.getSession();
    String usuValido = (String) sesValidacion.getAttribute("usuLogon");
    if (usuValido == null || usuValido.equals("")) {
      response.sendRedirect("logon.jsp");
    } else {
      // todo bien
    }

  %>
  <script>
    function mandar () {
      document.frmSalir.submit();
    }
  </script>
  <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="index.html">Gestion de Usuarios</a>
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
    <!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
      <div class="input-group">
      </div>
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
        
        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
          <li><a class="dropdown-item" href="#">Salir</a></li>
        </ul>
        
      </li>
    </ul>
  </nav>
  <div id="layoutSidenav">
    <div id="layoutSidenav_nav">
      <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
          <div class="nav">
            <div class="sb-sidenav-menu-heading">Acciones</div>
            <form name="frmSalir" action="SrvSalir" method="GET">
            <a class="nav-link" href="javascript: mandar ();">
              <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
              Salir
            </a>
            </form>
          </div>
        </div>
        <div class="sb-sidenav-footer">
          <div class="small">Logeado como:</div>
          <%=usuValido %>
        </div>
      </nav>
    </div>
