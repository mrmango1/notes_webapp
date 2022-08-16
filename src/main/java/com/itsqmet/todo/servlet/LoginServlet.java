package com.itsqmet.todo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itsqmet.todo.controller.LoginDAO;
import com.itsqmet.todo.controller.LoginDAOImplement;
import com.itsqmet.todo.model.Person;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
@MultipartConfig
public class LoginServlet extends HttpServlet {
  private static LoginDAO<Person> personDAO;

  public void init() {
    personDAO = new LoginDAOImplement();
  }

  private static final Gson GSON = new GsonBuilder().serializeNulls().create();

  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    req.setCharacterEncoding("UTF-8");
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    Person person = GSON.fromJson(data, Person.class);
    Person userLogin = personDAO.validate(person);
    if (userLogin != null) {
      HttpSession session = req.getSession();
      session.setAttribute("person_id", userLogin.getId_person());
      //setting session to expiry in 30 mins
      session.setMaxInactiveInterval(15 * 60);
      Cookie firstName = new Cookie("firstName", userLogin.getFirstname());
      Cookie lastName = new Cookie("lastName", userLogin.getLastname());
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
