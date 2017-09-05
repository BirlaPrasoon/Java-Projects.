package ui;

import model.Contact;
import model.ContactType;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Contact c = new Contact();
        String cName;
        String cNumber;
        ContactType cType;
        System.out.println("Enter name:");
        cName = s.next();
        System.out.println("Add a phone number for " + cName + ":");
        cNumber = s.next();
                System.out.println("Would you like to call " + c.getName() + " now? Type 'y' for yes, 'n' for no.");
        options(c, s);
    }

    private static void options(Contact c, Scanner s){
        String option = s.next();
        if(option.equals("y")) {
            System.out.println("Enter a date for the call in the format MM/DD/YY:");
            c.call(s.next());
            System.out.println("Here is your updated call history:");
            c.printCallLog();
        } else if (option.equals("n")) {
            System.out.println("Ok. Not caling any one.");
        }
    }


}
