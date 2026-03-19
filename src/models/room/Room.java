package models.room;

public class Room {
    private int id;
    private int roomNumber;
    private int floorNumber;
    private String status;
    private int roomTypeId;
    private String roomTypeName;

    public Room() {
    };

    public Room(int id, int roomNumber, int floorNumber, String status, int roomTypeId, String roomTypeName) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.status = status;
        this.roomTypeId = roomTypeId;
        this.roomTypeName = roomTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    @Override
    public String toString() {
        return roomNumber + " (" + status + ")";
    }
}
