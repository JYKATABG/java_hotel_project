package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.room.Room;

public class roomDao {
    public List<Room> getAll() {
        List<Room> list = new ArrayList<>();
        String sql = """
                SELECT r.*, rt.type_name
                FROM rooms r
                JOIN room_types rt ON r.room_type_id = rt.id
                ORDER BY r.room_number
                        """;

        try (Connection conn = DatabaseManager.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Room> searchByRoomNumber(String keyword) {
        List<Room> list = new ArrayList<>();
        String sql = """
                SELECT r.*, rt.type_name
                FROM room r
                JOIN room_type rt ON r.room_type_id = rt.id
                WHERE r.room_number LIKE ?
                """;
        try (Connection conn = DatabaseManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Room> getByStatus(String status) {
        List<Room> list = new ArrayList<>();
        String sql = """
                SELECT r.*, rt.type_name
                FROM room r
                JOIN room_type rt ON r.room_type_id = rt.id
                WHERE r.status = ?
                """;
        try (Connection conn = DatabaseManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // TODO: INSERT, UPDATE, DELETE Functions
    public void insertRoom(Room r) {
        String sql = """
                INSERT INTO rooms
                (room_number, floor_number, status, room_type_id)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conn = DatabaseManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, r.getRoomNumber());
            ps.setInt(2, r.getFloorNumber());
            ps.setString(3, r.getStatus());
            ps.setInt(4, r.getRoomTypeId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRoom(Room r) {
        String sql = """
                UPDATE rooms
                SET room_number=?, floor_number=?,
                status=?, room_type_id=? WHERE id=?
                """;

        try (Connection conn = DatabaseManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, r.getRoomNumber());
            ps.setInt(2, r.getFloorNumber());
            ps.setString(3, r.getStatus());
            ps.setInt(4, r.getRoomTypeId());
            ps.setInt(5, r.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(int id) {
        String sql = """
                DELETE FROM rooms WHERE id=?
                """;
        try (Connection conn = DatabaseManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Room mapRow(ResultSet rs) throws SQLException {
        Room r = new Room();
        r.setId(rs.getInt("id"));
        r.setRoomNumber(rs.getInt("room_number"));
        r.setFloorNumber(rs.getInt("floor_number"));
        r.setStatus(rs.getString("status"));
        r.setRoomTypeId(rs.getInt("room_type_id"));
        r.setRoomTypeName(rs.getString("type_name"));
        return r;
    }
}
