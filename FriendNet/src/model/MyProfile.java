package model;

import java.util.ArrayList;
import java.util.List;

public class MyProfile {

    private String name;
    private int age;
    private String currentLocation;
    private String workPlace;
    private List<MyProfile> friendsList;
    private List<Event> upcomingEvents;

    public MyProfile(String nm, int age, String locn, String work) {
        this.name = nm;
        this.age = age;
        currentLocation = locn;
        workPlace = work;
        upcomingEvents = new ArrayList<>();
        friendsList = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public String getWorkPlace() {
        return workPlace;

    }
        //Todo: this method is still not clear.
    public int upcomingEventNum() {
        return upcomingEvents.size();

    }
    public List<MyProfile> getFriendsList() {
        return friendsList;
    }
    public List<Event> getEventList() {
        return upcomingEvents;
    }

    // REQUIRES: f is not already in friendsList
    // MODIFIES: this
    // EFFECTS: consumes a MyProfile object, a friend f, and adds it to the friendsList
    public boolean addFriend(MyProfile f) {
        if(friendsList.contains(f))
            return false;
        friendsList.add(f);
        return true;
    }

    // MODIFIES: this
    // EFFECTS: removes a friend with the given name from this. If removal is successful, return true, else
    //          return false
    public boolean unFriend(String nm) {
            for(MyProfile mp:friendsList) {
                if (mp.getName() == nm) {
                    friendsList.remove(mp);
                    return true;
                }}
        return false;
    }

    // REQUIRES: ev is not in upcomingEvents
    // MODIFIES: this
    // EFFECTS: adds the given event to the list of upcoming events
    public void addEvent(Event ev) {
        if(upcomingEvents.contains(ev))
            return ;
        upcomingEvents.add(ev);
    }

    // MODIFIES: this
    // EFFECTS: removes an event with the given name. If removal is successful, return true, else return false
    public boolean removeEvent(String nm) {
        for(Event ev:upcomingEvents) {
            if (ev.getName() == nm) {
                upcomingEvents.remove(ev);
                return true;
            }
        }
        return false;
    }

    // EFFECTS: returns the number of events that are at the current location of this person
    public int eventNumNearMe() {
        int numEventNearMe =0;
        for(Event ev:upcomingEvents)
            if(ev.getLocation().equals(getCurrentLocation()))
                numEventNearMe++;

        return numEventNearMe;
    }

    // EFFECTS: returns the number of events of the given type et
    public int specificEventType(EventType et) {
        int eventOfGivenType = 0;
            for(Event ev:upcomingEvents)
                if(ev.getEventType().equals(et))
                    eventOfGivenType++;
        return eventOfGivenType;
    }

    // EFFECTS: prints events of  type et to the console
    //          Hint: is there a method you have already written that you can use?
    public void printEventSchedule(EventType et) {
        System.out.println("Events of type " +et + "are: ");
        for(Event ev:upcomingEvents)
            if(ev.getEventType().equals(et))
                System.out.println(ev.getName());

    }

    // EFFECTS: prints out the list of friends that this MyProfile has
    public void printFriendNames() {
        for(MyProfile mp:friendsList)
            System.out.println(mp.getName());
    }

    // EFFECTS: prints out the names of friends who live at the same location associated with this profile
    public void printFriendsNearMe() {
        for(MyProfile mp:friendsList)
                if(mp.getCurrentLocation().equals(this.getCurrentLocation()))
                    System.out.println(mp.getName());
    }

    // EFFECTS: produces true if this profile has a friend with the given name,
    //          OR if any of this profile's friends has a friend with the given name
    //          Hint: use recursion!
    public boolean canFindPerson(String name) {
        if(this.friendsList.isEmpty())
            return false;
        for(MyProfile mp:friendsList)
            if(mp.getName().equals(name))
                return true;

        for(MyProfile mp:friendsList)
            if(mp.canFindPerson(name))
                return true;

        return false;
    }


}
