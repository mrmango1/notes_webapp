package com.itsqmet.todo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itsqmet.todo.controller.DAO;
import com.itsqmet.todo.controller.UserDAOImplement;
import com.itsqmet.todo.model.User;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/user")
@MultipartConfig
public class UserApi extends HttpServlet {
	private static DAO<User> userDAO;
	private String formatDate = "[\\[\\]]";

	public void init() {
		userDAO = new UserDAOImplement();
	}

	private static final Gson GSON = new GsonBuilder().serializeNulls().create();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		int idUser = (Integer) session.getAttribute("id_user");
		List<User> listControl = userDAO.read(idUser);
		String json = GSON.toJson(listControl);
		out.write(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("UTF-8");
		String data = GSON.toJson(req.getParameterMap());
		data = data.replaceAll(formatDate, "");
		User user = GSON.fromJson(data, User.class);
		if (userDAO.create(user)) {
			res.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String data = GSON.toJson(req.getParameterMap());
		data = data.replaceAll(formatDate, "");
		User user = GSON.fromJson(data, User.class);
		if (userDAO.update(user)) {
			res.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String data = GSON.toJson(req.getParameterMap());
		data = data.replaceAll(formatDate, "");
		User user = GSON.fromJson(data, User.class);
		if (userDAO.delete(user)) {
			res.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
