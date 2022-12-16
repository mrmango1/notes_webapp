package com.itsqmet.todo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/topic")
@MultipartConfig
public class TopicApi extends HttpServlet {
	private static DAO<Topic> topicDAO;
	private static final Gson GSON = new GsonBuilder().serializeNulls().create();


	public void init() {
		topicDAO = new TopicDAOImplement();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		int idTable = (Integer) session.getAttribute("idTable");
		List<Topic> tableList = topicDAO.read(idTable);
		String json = GSON.toJson(tableList);
		out.write(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("UTF-8");
		String data = GSON.toJson(req.getParameterMap());
		data = data.replaceAll("[a[*]c]", "");
		Topic topic = GSON.fromJson(data, Topic.class);
		HttpSession session = req.getSession();
		topic.setIdTable((Integer) session.getAttribute("id_table"));
		if (topicDAO.create(topic)) {
			res.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	@Override
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

	@Override
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
