package model;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String number;
    private ContactType type;
    private ArrayList<String> callLog ;

    public Contact(String name, String number, ContactType contactType){
        this.name = name;
        this.number = number;
        this.type = contactType;
        callLog = new ArrayList<>();
    }
    public Contact(){
        this.callLog = new ArrayList<>();
    }

    public void setName(String name){
        this.name = name;
    }

    // Requires: number should be 10 chars long
    // Modifies: this
    //Effects: number setter
    public void setNumber(String number){
        if(number.length()==10)
            this.number = number;
        else
            System.out.println("Please enter a valid number");
    }
    // Modifies: this
    // Effects: Type setter
    public void setType(ContactType cType){
        this.type = cType;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public ContactType getType() {
        return type;
    }

    //todo: create a method to add the given date in the callLog
    //Requires date should be a string in formate MM/DD/YYYY
    //Modifies: this
    //Effects: adds the date to the callLog
    public void call(String date){
        callLog.add(date);
    }

    //Todo: create a method to print all the dates in the callLog
    //Effects: prints all the dates in the callLog on the console
    public void printCallLog(){
        System.out.println("The updated call Log  is: ");
        for(String date:callLog)
            System.out.println(date);
    }

    // todo: create a method to return the size of the callLog
    //Effects: returns the size of the callLog
    public int logSize(){
        return callLog.size();
    }

    //todo: create a method to generate an automate response
    //Effects: this method should generate different responses based on the this's contact type
    public String automatearResponse(){
        switch (this.type){
            case WORK: return "I'll get back to you at work";
            case FAMILY:return "See you at home.";
            case FRIEND:return "Meet you at the cafe.";
        }
        return " ";
    }
}
