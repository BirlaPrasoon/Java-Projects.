package model;

public class Event {

    private String name;
    private String date;
    private String location;
    private EventType type;

    public Event(String name, String date, String location, EventType type) {
        this.type = type;
        this.name = name;
        this.location = location;
        this.date = date;
    }

    // getters
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }
    public EventType getEventType() {
        return type;
    }


}
