package com.itsqmet.todo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itsqmet.todo.controller.CurrentDAO;
import com.itsqmet.todo.controller.CurrentDAOImplement;
import com.itsqmet.todo.model.Table;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/currentTable")
@MultipartConfig
public class CurrentTable extends HttpServlet {
  private static CurrentDAO<Table> tableDao;
  private static final Gson GSON = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();

  

  public void init() {
    tableDao = new CurrentDAOImplement();
    }
  

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.setContentType("application/json");
    PrintWriter out = res.getWriter();
    HttpSession session = req.getSession();
    int idTable = (Integer) session.getAttribute("idTable");
    Table table = tableDao.currentTable(idTable);
    String json = GSON.toJson(table);
    out.write(json);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    res.setContentType("text/html");
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    Table table = GSON.fromJson(data, Table.class);
    HttpSession session = req.getSession();
    session.setAttribute("idTable", table.getIdTable());
    session.setMaxInactiveInterval(15 * 60);
  }
}