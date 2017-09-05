package test;

import model.Contact;
import model.ContactType;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ContactTest {
    Contact c;

    @Before
    public void setup(){
        c = new Contact("Prasoon Birla","7417735248", ContactType.FAMILY);
    }

    //todo: create a method to test all the getters of the contact class
    //outcome: all the getters must return what it should return
    @Test
    public void testGetters(){
        assertEquals(c.getName(),"Prasoon Birla");
        assertEquals(c.getNumber(),"7417735248");
        assertEquals(c.getType(),ContactType.FAMILY);
    }

    // todo: create a method to check all the setters of the contact class
    // outcome: all the setters should work properly
    @Test
    public void testSetters(){
        c.setName("Shubham Birla");
        c.setNumber("9898989898");
        c.setType(ContactType.FRIEND);
        assertFalse(c.getName().equals("Prasoon Birla"));
        assertFalse(c.getNumber().equals("7417735248"));
        assertEquals(c.getType(),ContactType.FRIEND);
    }

    // todo: create a method to test the Call method
    // outcome: method should add the given contact to the callLog
    @Test
    public void testCall(){
        assertEquals(c.logSize(),0);
        c.call("02/28/1993");
        assertEquals(c.logSize(),1);
    }

    //todo: create a method to test the automateResponse method
    //outcome: it should return the response according to the contact Type
    @Test
    public void testAutomateResponse(){
        assertTrue(c.automatearResponse().equals("See you at home."));
        c.setType(ContactType.FRIEND);
        assertTrue(c.automatearResponse().equals("Meet you at the cafe."));
    }

}
