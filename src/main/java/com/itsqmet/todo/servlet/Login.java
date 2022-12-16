package com.itsqmet.todo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itsqmet.todo.controller.LoginDAO;
import com.itsqmet.todo.controller.LoginDAOImplement;
import com.itsqmet.todo.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


@WebServlet("/login")
@MultipartConfig
public class Login extends HttpServlet {
  private static LoginDAO<User> loginDAO;

  public void init() {
    loginDAO = new LoginDAOImplement();
  }

  private static final Gson GSON = new GsonBuilder().serializeNulls().create();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    req.setCharacterEncoding("UTF-8");
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    User user = GSON.fromJson(data, User.class);
    User userLogin = loginDAO.validate(user);
    if (userLogin != null) {
      HttpSession session = req.getSession();
      session.setAttribute("id_user", userLogin.getIdUser());
    
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
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }
  // Register method
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    req.setCharacterEncoding("UTF-8");
    User userLogin = loginDAO.register();
    if (userLogin != null) {
      HttpSession session = req.getSession();
      session.setAttribute("id_user", userLogin.getIdUser());
     
      session.setMaxInactiveInterval(15 * 60);
      String firstnameStr = userLogin.getFirstname().split(" ")[0];
      String lastnameStr = userLogin.getLastname().split(" ")[0];
      Cookie firstName = new Cookie("firstName", firstnameStr);
      Cookie lastName = new Cookie("lastName", lastnameStr);
      firstName.setMaxAge(30 * 60);
      lastName.setMaxAge(30 * 60);
      res.addCookie(firstName);
      res.addCookie(lastName);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }
}
