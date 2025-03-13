package com.example.wcdexam.controller;

import com.example.wcdexam.model.Player;
import com.example.wcdexam.model.PlayerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePlayer")
public class UpdatePlayerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int playerId = Integer.parseInt(request.getParameter("playerId"));
        String name = request.getParameter("playerName");
        int age = Integer.parseInt(request.getParameter("playerAge"));
        String indexName = request.getParameter("indexName");
        float indexValue = Float.parseFloat(request.getParameter("indexValue"));

        Player player = new Player(playerId, name, age, indexName, indexValue);
        PlayerDAO playerDAO = new PlayerDAO();
        try {
            playerDAO.updatePlayer(player);
            response.sendRedirect("players");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}