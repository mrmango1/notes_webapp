<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <title>Mis Notas</title>
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
    <script src="./js/task.js"></script>
  </head>
  <body>
    <%@include file="templates/other/handlerSession.jsp" %> <%@include
    file="templates/other/navbar.jsp" %>
    <main class="container">
      <header>
        <h1 id="title"></h1>
        <span id="description"></span>
      </header>
      <div id="toolbar">
        <button
          type="button"
          class="btn btn-success"
          data-bs-toggle="modal"
          data-bs-target="#createModal"
        >
          <i class="fa fa-plus"></i>
          Añadir Tarea
        </button>
      </div>
      <table
        id="table"
        data-toolbar="#toolbar"
        data-locale="es-ES"
        data-url="./api/task"
        data-toggle="table"
        data-filter-control="true"
        data-pagination="true"
        data-height="550"
        data-search="true"
        class="table-bordered table-hover table-striped table-light"
      >
        <thead>
          <tr>
            <th data-field="done" data-align="center" data-valign="middle">
              Hecho
            </th>
            <th data-field="title" data-align="center" data-valign="middle">
              TAREA
            </th>
            <th
              data-field="description"
              data-align="center"
              data-valign="middle"
            >
              DESCRIPCION
            </th>
            <th
              data-field="importance"
              data-valign="middle"
              data-align="center"
            >
              IMPORTANCIA
            </th>
            <th
              data-field="limit_date"
              data-align="center"
              data-valign="middle"
            >
              FINALIZA
            </th>
            <th
              data-field="operate"
              data-formatter="operateFormatter"
              data-width="222"
              data-align="center"
              data-valign="middle"
            >
              ACCION
            </th>
          </tr>
        </thead>
      </table>
      <%@include file="templates/task.jsp" %>
    </main>
  </body>
</html>
