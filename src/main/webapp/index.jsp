<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <title>Mis Tablas</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="css/style.css" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
    />
    <link
      rel="stylesheet"
      href="https://unpkg.com/bootstrap-table@1.20.2/dist/bootstrap-table.min.css"
    />
    <link href="https://fonts.cdnfonts.com/css/coolvetica" rel="stylesheet" />
    <link href="./scss/custom.css" rel="stylesheet" />
    <script src="./node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
    <script src="https://unpkg.com/bootstrap-table@1.20.2/dist/bootstrap-table.min.js"></script>
    <script src="https://unpkg.com/bootstrap-table@1.20.2/dist/bootstrap-table-locale-all.min.js"></script>
    <script src="https://unpkg.com/bootstrap-table@1.20.2/dist/extensions/filter-control/bootstrap-table-filter-control.min.js"></script>
    <script src="https://unpkg.com/bootstrap-table@1.20.2/dist/extensions/filter-control/utils.min.js"></script>
    <script src="./js/table.js"></script>
  </head>
  <body>
    <%@include file="templates/other/handlerSession.jsp" %> <%@include
    file="templates/other/navbar.jsp" %>
    <main class="container">
      <header>
        <h1>Hola <%=firstName %> <i class="fa fa-chart-bar"></i></h1>
        <h3>Estas son tus tablas:</h3>
      </header>
      <div class="container-fluid">
        <button
          type="button"
          class="btn btn-secondary"
          data-bs-toggle="modal"
          data-bs-target="#createModal"
        >
          <i class="fa fa-plus"></i>
          Añadir Tabla
        </button>
        <div id="response"></div>
      </div>
    </main>
    <%@include file="templates/table.jsp" %>
  </body>
</html>
