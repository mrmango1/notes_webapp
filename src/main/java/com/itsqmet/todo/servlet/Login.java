package com.itsqmet.todo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itsqmet.todo.controller.LoginDAO;
import com.itsqmet.todo.controller.LoginDAOImplement;
import com.itsqmet.todo.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
@MultipartConfig
public class Login extends HttpServlet {
  private static LoginDAO<User> loginDAO;

  public void init() {
    loginDAO = new LoginDAOImplement();
  }

  private static final Gson GSON = new GsonBuilder().serializeNulls().create();

  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    req.setCharacterEncoding("UTF-8");
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    User user = GSON.fromJson(data, User.class);
    User userLogin = loginDAO.validate(user);
    if (userLogin != null) {
      HttpSession session = req.getSession();
      session.setAttribute("id_user", userLogin.getId_user());
      //setting session to expiry in 30 mins
      session.setMaxInactiveInterval(15 * 60);
      String firstnameStr = userLogin.getFirstname().split(" ")[0];
      String lastnameStr = userLogin.getLastname().split(" ")[0];
      Cookie firstName = new Cookie("firstName", firstnameStr);
      Cookie lastName = new Cookie("lastName", lastnameStr);
      firstName.setMaxAge(30 * 60);
      lastName.setMaxAge(30 * 60);
      res.addCookie(firstName);
      res.addCookie(lastName);
      res.sendRedirect("index.jsp");
    } else {
      RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/login.html");
      PrintWriter out = res.getWriter();
      out.println("<font color=red>Either user name or password is wrong.</font>");
      rd.include(req, res);

//    if (personDAO.create(person)) {
//      res.setStatus(HttpServletResponse.SC_CREATED);
//    } else {
//      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
//    }
    }
  }
  // Register method
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    req.setCharacterEncoding("UTF-8");
    User userLogin = loginDAO.register();
    System.out.println(userLogin);
    if (userLogin != null) {
      HttpSession session = req.getSession();
      session.setAttribute("id_user", userLogin.getId_user());
      //setting session to expiry in 30 mins
      session.setMaxInactiveInterval(15 * 60);
      String firstnameStr = userLogin.getFirstname().split(" ")[0];
      String lastnameStr = userLogin.getLastname().split(" ")[0];
      Cookie firstName = new Cookie("firstName", firstnameStr);
      Cookie lastName = new Cookie("lastName", lastnameStr);
      firstName.setMaxAge(30 * 60);
      lastName.setMaxAge(30 * 60);
      res.addCookie(firstName);
      res.addCookie(lastName);
      res.sendRedirect("index.jsp");
    } else {
      RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/login.html");
      PrintWriter out = res.getWriter();
      out.println("<font color=red>Either user name or password is wrong.</font>");
      rd.include(req, res);

//    if (personDAO.create(person)) {
//      res.setStatus(HttpServletResponse.SC_CREATED);
//    } else {
//      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
//    }
    }
  }
}
