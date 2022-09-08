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
    <script src="./js/script.js"></script>
  </head>
  <body>
    <style>
      h1 {
        font-family: "Coolvetica", cursive;
        font-size: 50px;
      }
      h3{
        font-size: 2.5rem;
        font-weight: 600;
        margin: 1.5rem 0;
      }
      h4{
        font-weight: 700;
      }
    </style>
    <%@include file="templates/other/handlerSession.jsp" %> <%@include
    file="templates/other/navbar.jsp" %>
    <main class="container">
      <header>
        <h1>Acerca de:</h1>
        <h3>Este projecto.</h3>
      </header>
      <div class="container-fluid" style="display: flex; align-items: center;justify-content: space-around;">
        <div>
          <h4>OBJETIVO GENERAL</h4>
          <p>
            Diseñar y programar una aplicación web para generar check list de
            tareas.
          </p>
          <h4>OBJETIVOS ESPECÍFICOS</h4>
          <ul>
            <li>
              Diagramar la funcionalidad de la aplicación y de su arquitectura
            </li>
            <li>
              Utilizar javascript para realizar tareas en el lado del frontend
            </li>
            <li>
              Utilizar html, css y boostrap para estilizar la aplicación web
            </li>
            <li>
              Usar java servlets en el lado del backend aplicando el modelo MVC
            </li>
            <li>Usar mysql para la persistencia de datos</li>
          </ul>
          <h4>INTEGRANTES</h4>
          <ul>
            <li>Bravo Ramirez Luis David</li>
            <li>Guerrero Jara María Paula</li>
            <li>Grefa Sanchez Anderson Julio</li>
          </ul>
        </div>
        <div>
          <figure>
            <img
              src="assets/logo2.png"
              alt="Logo"
              style="width: 200px; margin: 50px"
            />
          </figure>
        </div>
      </div>
    </main>
  </body>
</html>
