import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbTest {
    public static void main(String[] args) {
        // Данные для подключения
        String url = "jdbc:postgresql://localhost:5432/gym_db";
        String user = "postgres";
        String password = "ktl192192"; // Пароль от PostgreSQL

        try {
            // Попытка установить соединение
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("✅ УСПЕХ: База данных подключена!");
                connection.close(); // Закрываем соединение
            }
        } catch (SQLException e) {
            System.out.println("❌ ОШИБКА ПОДКЛЮЧЕНИЯ:");
            e.printStackTrace();
        }
    }
}
