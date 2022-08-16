package com.itsqmet.todo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itsqmet.todo.controller.DAO;
import com.itsqmet.todo.controller.TopicDAOImplement;
import com.itsqmet.todo.model.Topic;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/topic")
@MultipartConfig
public class TopicServlet extends HttpServlet {
  private static DAO<Topic> topicDAO;
  private static final Gson GSON = new GsonBuilder().serializeNulls().create();

  public void init() {
    topicDAO = new TopicDAOImplement();
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.setContentType("application/json");
    PrintWriter out = res.getWriter();
    List<Topic> tableList = topicDAO.read();
    String json = GSON.toJson(tableList);
    out.write(json);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
    req.setCharacterEncoding("UTF-8");
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    System.out.println(data);
    Topic topic = GSON.fromJson(data, Topic.class);
    if (topicDAO.create(topic)) {
      res.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    Topic topic = GSON.fromJson(data, Topic.class);
    if (topicDAO.update(topic)) {
      res.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String data = GSON.toJson(req.getParameterMap());
    data = data.replaceAll("[\\[\\]]", "");
    Topic topic = GSON.fromJson(data, Topic.class);
    if (topicDAO.delete(topic)) {
      res.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }
}
