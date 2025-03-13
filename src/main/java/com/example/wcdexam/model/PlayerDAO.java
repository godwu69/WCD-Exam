package com.example.wcdexam.model;

import com.example.wcdexam.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    private Connection conn;

    public PlayerDAO() {
        try {
            conn = DatabaseUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void addPlayer(Player player) throws SQLException {
        String sql = "INSERT INTO player (name, age, index_id) VALUES (?, ?, (SELECT index_id FROM indexer WHERE name = ?))";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getAge());
            pstmt.setString(3, player.getIndexName());
            pstmt.executeUpdate();
        }
    }

    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT p.player_id, p.name, p.age, i.name AS index_name, pi.value " +
                "FROM player p " +
                "JOIN player_index pi ON p.player_id = pi.player_id " +
                "JOIN indexer i ON pi.index_id = i.index_id";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                players.add(new Player(
                        rs.getInt("player_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("index_name"),
                        rs.getFloat("value")
                ));
            }
        }
        return players;
    }

    public Player getPlayerById(int playerId) throws SQLException {
        String sql = "SELECT p.player_id, p.name, p.age, i.name AS index_name, pi.value " +
                "FROM player p " +
                "JOIN player_index pi ON p.player_id = pi.player_id " +
                "JOIN indexer i ON pi.index_id = i.index_id " +
                "WHERE p.player_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, playerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Player(
                            rs.getInt("player_id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("index_name"),
                            rs.getFloat("value")
                    );
                }
            }
        }
        return null;
    }

    public void updatePlayer(Player player) throws SQLException {
        String sql = "UPDATE player SET name = ?, age = ? WHERE player_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getAge());
            pstmt.setInt(3, player.getId());
            pstmt.executeUpdate();
        }

        sql = "UPDATE player_index SET value = ? WHERE player_id = ? AND index_id = (SELECT index_id FROM indexer WHERE name = ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setFloat(1, player.getIndexValue());
            pstmt.setInt(2, player.getId());
            pstmt.setString(3, player.getIndexName());
            pstmt.executeUpdate();
        }
    }

    public void deletePlayer(int playerId) throws SQLException {
        String sql = "DELETE FROM player_index WHERE player_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, playerId);
            pstmt.executeUpdate();
        }

        sql = "DELETE FROM player WHERE player_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, playerId);
            pstmt.executeUpdate();
        }
    }
}