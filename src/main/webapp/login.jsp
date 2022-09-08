<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>Login</title>
    <!-- CSS only -->
    <link href="./scss/custom.css" rel="stylesheet" />
    <link href="./css/style.css" rel="stylesheet" />
    <!-- JavaScript Bundle with Popper -->
    <script src="./node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="./js/login.js"></script>
  </head>
  <body style="padding: 0">
    <% if(session.getAttribute("id_user") != null){
    response.sendRedirect("index.jsp"); } %>
    <header>
      <h1 style="font-weight: 800;">Notas</h1>
    </header>
    <div class="container-fluid">
      <section class="w-100 p-4 d-flex justify-content-center pb-4">
        <div style="width: 26rem" id="loginAndRegister">
          <!-- Pills navs -->
          <nav class="nav nav-pills nav-justified">
            <button
              class="nav-link active primary"
              id="pills-home-tab"
              data-bs-toggle="pill"
              data-bs-target="#pills-login"
              type="button"
              role="tab"
              aria-controls="pills-login"
              aria-selected="true"
            >
              Iniciar Sesión
            </button>
            <button
              class="nav-link"
              id="pills-profile-tab"
              data-bs-toggle="pill"
              data-bs-target="#pills-register"
              type="button"
              role="tab"
              aria-controls="pills-register"
              aria-selected="false"
            >
              Registrase
            </button>
          </nav>
          <!-- Pills navs -->

          <!-- Pills content -->
          <div class="tab-content">
            <div
              class="tab-pane fade active show"
              id="pills-login"
              role="tabpanel"
              aria-labelledby="tab-login"
            >
              <form onsubmit="login(event,this)" action="./login" style="margin: 0">
                <p class="text-center mt-3">Por favor, ingrese a su cuenta</p>

                <!-- Email input -->
                <div class="form-floating mb-3">
                  <input
                    type="email"
                    class="form-control"
                    name="email"
                    id="loginEmail"
                    placeholder="name@example.com"
                  />
                  <label for="loginEmail">Correo Electrónico</label>
                </div>

                <!-- Password input -->
                <div class="form-floating mb-3">
                  <input
                    type="password"
                    class="form-control"
                    name="password"
                    id="loginPassword"
                    placeholder="Password"
                  />
                  <label for="loginPassword">Contraseña</label>
                </div>

                <!-- Submit button -->
                <div class="text-center">
                  <button type="submit" class="btn btn-primary btn-block">
                    Ingresar
                  </button>
                </div>
              </form>
            </div>
            <div
              class="tab-pane fade"
              id="pills-register"
              role="tabpanel"
              aria-labelledby="tab-register"
            >
              <form
                action="./api/user"
                onsubmit="register(event,this)"
                style="margin: 0"
              >
                <p class="text-center">Por favor, ingrese a sus datos</p>

                <!-- Name input -->
                <div class="form-floating mb-3">
                  <input
                    type="text"
                    class="form-control"
                    id="registerName"
                    placeholder="Nombre"
                    name="firstname"
                  />
                  <label for="registerName">Nombre</label>
                </div>

                <!-- Username input -->
                <div class="form-floating mb-3">
                  <input
                    type="text"
                    class="form-control"
                    id="registerLastname"
                    placeholder="Apellido"
                    name="lastname"
                  />
                  <label for="registerLastname">Apellido</label>
                </div>

                <!-- Email input -->
                <div class="form-floating mb-3">
                  <input
                    type="email"
                    class="form-control"
                    id="registerEmail"
                    placeholder="name@example.com"
                    name="email"
                  />
                  <label for="registerEmail">Email address</label>
                </div>

                <!-- Password input -->
                <div class="form-floating mb-3">
                  <input
                    type="password"
                    class="form-control"
                    id="registerPassword"
                    placeholder="Password"
                    name="password"
                  />
                  <label for="registerPassword">Password</label>
                </div>

                <!-- Repeat Password input -->
                <div class="form-floating mb-3">
                  <input
                    type="password"
                    class="form-control"
                    id="registerRepeatPassword"
                    placeholder="Repeat Password"
                    name="confirmPassword"
                  />
                  <label for="registerRepeatPassword">Repeat Password</label>
                </div>
                <!-- Submit button -->
                <div class="text-center">
                  <button type="submit" class="btn btn-primary btn-block">
                    Registrase
                  </button>
                </div>
              </form>
            </div>
          </div>
          <!-- Pills content -->
        </div>
      </section>
    </div>
  </body>
</html>
