package com.example.wcdexam.controller;

import com.example.wcdexam.model.Player;
import com.example.wcdexam.model.PlayerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editPlayer")
public class EditPlayerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int playerId = Integer.parseInt(request.getParameter("id"));
        PlayerDAO playerDAO = new PlayerDAO();
        try {
            Player player = playerDAO.getPlayerById(playerId);
            request.setAttribute("player", player);
            request.getRequestDispatcher("/editPlayer.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}