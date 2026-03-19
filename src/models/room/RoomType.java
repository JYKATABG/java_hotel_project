package models.room;

public class RoomType {
    private int id;
    private String typeName;
    private int capacity;
    private double pricePerNight;

    public RoomType() {
    };

    RoomType(int id, String typeName, int capacity, double pricePerNight) {
        this.id = id;
        this.typeName = typeName;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
