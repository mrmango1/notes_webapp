<style>
  nav {
      box-shadow:  0 2px 10px #929395;
      font-weight: 500;
      z-index: 10;
  }
  nav div > ul a:hover {
      color: #fff;
      background-color: #209fb5;
  }
</style>
<nav class="navbar navbar-expand-sm bg-overlay  fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">
      <img src="assets/logo.png" alt="logo" height="30px">
    </a>
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#collapsibleNavbar"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">Tablas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="task.jsp">Notas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="about.jsp">Acerca de</a>
        </li>
      </ul>
    </div>
    <li class="d-flex nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><%=firstName%> <%=lastName%></a>
      <ul class="dropdown-menu">
        <li><a class="dropdown-item" href="#">Detalles</a></li>
        <li><a class="dropdown-item" href="#">Configuracion</a></li>
        <li><a class="dropdown-item" href="./logout">Cerrar Sesion</a></li>
      </ul>
    </li>
  </div>
</nav>

