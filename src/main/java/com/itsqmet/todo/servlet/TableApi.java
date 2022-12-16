package com.itsqmet.todo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itsqmet.todo.controller.DAO;
import com.itsqmet.todo.controller.TableDAOImplement;
import com.itsqmet.todo.model.Table;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/table")
@MultipartConfig
public class TableApi extends HttpServlet {
  private static DAO<Table> tableDAO;
  
  private String fDate = "[\\\\[\\\\]]";

  public void init() {
    tableDAO = new TableDAOImplement();
  }
  private static final Gson GSON = new GsonBuilder().serializeNulls().create();


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.setContentType("application/json");
    PrintWriter out = res.getWriter();
    HttpSession session = req.getSession();
    int idUser = (Integer) session.getAttribute("idUser");
    List<Table> tableList = tableDAO.read(idUser);
    String json = GSON.toJson(tableList);
    out.write(json);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
    req.setCharacterEncoding("UTF-8");
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll(fDate, "");
    Table table = GSON.fromJson(data, Table.class);
    HttpSession session = req.getSession(); 
    table.setIdUser((Integer) session.getAttribute("idUser"));
    if (tableDAO.create(table)) {
      res.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll(fDate, "");
    Table table = GSON.fromJson(data, Table.class);
    if (tableDAO.update(table)) {
      res.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll(fDate, "");
    Table table = GSON.fromJson(data, Table.class);
    if (tableDAO.delete(table)) {
      res.setStatus(HttpServletResponse.SC_OK);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }
}