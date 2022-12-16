package com.itsqmet.todo.servlet;

import java.io.IOException;

import com.google.gson.Gson;
import com.itsqmet.todo.controller.DAO;
import com.itsqmet.todo.controller.TaskTopicDAOImplement;
import com.itsqmet.todo.model.TaskTopic;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/taskTopic")
@MultipartConfig
public class TaskTopicApi extends HttpServlet {
	private static DAO<TaskTopic> topicDAO;
	private static final Gson GSON = new Gson();
	private String formatDate = "[\\[\\]]";
	

	@Override
	public void init() {
		topicDAO = new TaskTopicDAOImplement();
	}

	@Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
	 
    req.setCharacterEncoding("UTF-8");
    String data = GSON.toJson(req.getParameterMap());

    data = data.replaceAll(formatDate, "");
    System.out.println(data);
    TaskTopic taskTopic = GSON.fromJson(data, TaskTopic.class);
    if (topicDAO.create(taskTopic)) {
      res.setStatus(HttpServletResponse.SC_CREATED);
    } else {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String data = GSON.toJson(req.getParameterMap());
		data = data.replaceAll(formatDate, "");
		TaskTopic taskTopic = GSON.fromJson(data, TaskTopic.class);
		if (topicDAO.update(taskTopic)) {
			res.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String data = GSON.toJson(req.getParameterMap());
		data = data.replaceAll(formatDate, "");
		TaskTopic taskTopic = GSON.fromJson(data, TaskTopic.class);
		if (topicDAO.delete(taskTopic)) {
			res.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
