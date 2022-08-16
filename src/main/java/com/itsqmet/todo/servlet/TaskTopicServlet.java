package com.itsqmet.todo.servlet;

import com.google.gson.Gson;
import com.itsqmet.todo.controller.DAO;
import com.itsqmet.todo.controller.TaskTopicDAOImplement;
import com.itsqmet.todo.model.TaskTopic;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/taskTopic")
@MultipartConfig
public class TaskTopicServlet extends HttpServlet {
  private static DAO<TaskTopic> topicDAO;
  private static final Gson GSON = new Gson();

  public void init() {
    topicDAO = new TaskTopicDAOImplement();
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.setContentType("application/json");
    PrintWriter out = res.getWriter();
    List<TaskTopic> taskTopicList = topicDAO.read();
    String json = GSON.toJson(taskTopicList);
    out.write(json);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
    req.setCharacterEncoding("UTF-8");
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    System.out.println(data);
    TaskTopic taskTopic = GSON.fromJson(data, TaskTopic.class);
    if (topicDAO.create(taskTopic)) {
      res.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    TaskTopic taskTopic = GSON.fromJson(data, TaskTopic.class);
    if (topicDAO.update(taskTopic)) {
      res.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    TaskTopic taskTopic = GSON.fromJson(data, TaskTopic.class);
    if (topicDAO.delete(taskTopic)) {
      res.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }
}
