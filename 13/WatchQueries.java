import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WatchQueries {

    public void getBrandsByType(String type) {
        String query = "SELECT brand FROM Watch WHERE type = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("brand"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getMechanicalWatchesByPrice(double maxPrice) {
        String query = "SELECT * FROM Watch WHERE type = 'mechanical' AND price <= ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, maxPrice);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Brand: " + rs.getString("brand") + ", Price: " + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getBrandsByCountry(String country) {
        String query = "SELECT Watch.brand FROM Watch JOIN Manufacturer ON Watch.manufacturer_id = Manufacturer.id WHERE Manufacturer.country = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, country);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("brand"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getManufacturersByTotalWatchValue(double maxTotalValue) {
        String query = "SELECT Manufacturer.name FROM Manufacturer JOIN Watch ON Manufacturer.id = Watch.manufacturer_id GROUP BY Manufacturer.id HAVING SUM(Watch.price * Watch.quantity) <= ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, maxTotalValue);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}