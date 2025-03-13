package com.example.wcdexam.controller;

import com.example.wcdexam.model.Player;
import com.example.wcdexam.model.PlayerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/players")
public class PlayerController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlayerDAO playerDAO = new PlayerDAO();
        try {
            List<Player> players = playerDAO.getAllPlayers();
            request.setAttribute("players", players);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}