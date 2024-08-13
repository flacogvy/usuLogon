<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Logon Administrador</title>
    <link href="css/styles.css" rel="stylesheet" />
    <script src="./js/all.js" crossorigin="anonymous"></script>
  </head>
  <body class="bg-primary">
    <div id="layoutAuthentication">
      <div id="layoutAuthentication_content">
        <main>
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-lg-5">
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                  <div class="card-header"><h3 class="text-center font-weight-light my-4">Logon Inicio</h3></div>
                  <div class="card-body">
                    <form name="frmLogon" method="POST" action="SrvValidar" >
                      <div class="form-floating mb-3">
                        <input class="form-control" id="txtUsuario" name="txtUsuario" type="text" placeholder="Nombre Usuario" required />
                        <label for="txtUsuario">Nombre Usuario:</label>
                      </div>
                      <div class="form-floating mb-3">
                        <input class="form-control" id="txtPassword" name="txtPassword" type="password" placeholder="Password" required />
                        <label for="txtPassword">Contraseña:</label>
                      </div>
                      <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                        <a class="small" href="#"></a>
                        <!--<a class="btn btn-primary" href="#">Ingresar</a>-->
                        <button class="btn btn-primary" >Ingresar</button>
                      </div>
                    </form>
                  </div>
                  <div class="card-footer text-center py-3">
                    <div class="small"><a href="#">Need an account? Sign up!</a></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </main>
      </div>
      <div id="layoutAuthentication_footer">
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
    </div>
    <script src="./js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="./js/scripts.js"></script>
  </body>
</html>
