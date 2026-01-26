package com.gymmanagement.database;

import com.gymmanagement.model.Member; // Важный импорт
import java.sql.*;

public class MemberDAO {

    public void insertMember(Member member) {
        // Убедись, что в pgAdmin таблица называется member (без s)
        String sql = "INSERT INTO member (name, age, membership_type) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, member.getName());
            pstmt.setInt(2, member.getAge());
            pstmt.setString(3, member.getMembershipType());

            pstmt.executeUpdate();
            System.out.println("✅ Участник успешно сохранен в базу данных!");

        } catch (SQLException e) {
            System.out.println("❌ Ошибка базы данных: " + e.getMessage());
        }
    }

    public void getAllMembers() {
        String sql = "SELECT * FROM member";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Список участников из БД ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String type = rs.getString("membership_type");

                System.out.println("ID: " + id + " | Имя: " + name + " | Возраст: " + age + " | Тип: " + type);
            }
        } catch (SQLException e) {
            System.out.println("❌ Ошибка при чтении: " + e.getMessage());
        }
    }
}