package com.itsqmet.todo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itsqmet.todo.controller.DAO;
import com.itsqmet.todo.controller.TaskDAOImplement;
import com.itsqmet.todo.model.Task;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/task")
@MultipartConfig
public class TaskApi extends HttpServlet {
  private static DAO<Task> taskDAO;
  private static final Gson GSON = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();

  public void init() {
    taskDAO = new TaskDAOImplement();
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.setContentType("application/json");
    PrintWriter out = res.getWriter();
    HttpSession session = req.getSession();
    int id_table = (Integer) session.getAttribute("id_table");
    List<Task> taskList = taskDAO.read(id_table);
    String json = GSON.toJson(taskList);
    out.write(json);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
    req.setCharacterEncoding("UTF-8");
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    Task task = GSON.fromJson(data, Task.class);
    HttpSession session = req.getSession();
    task.setId_table((Integer) session.getAttribute("id_table"));
    if (taskDAO.create(task)) {
      res.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
    req.setCharacterEncoding("UTF-8");
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    Task task = GSON.fromJson(data, Task.class);
    if (taskDAO.update(task)) {
      res.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    Task task = GSON.fromJson(data, Task.class);
    if (taskDAO.delete(task)) {
      res.setStatus(HttpServletResponse.SC_OK);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }
}
