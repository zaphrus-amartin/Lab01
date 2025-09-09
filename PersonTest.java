import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person frodo;
    private Person sam;
    private Person merry;
    private Person pippin;

    @BeforeEach
    void setUp() {
        frodo = new Person("Frodo", "Baggins", "0001", "Mr.", 2003);
        sam = new Person("Samwise", "Gamgee", "0002", "Mr.", 2003);
        merry = new Person("Meriadoc", "Brandybuck", "0003", "Mr.", 2003);
        pippin = new Person("Peregrin", "Took", "0004", "Mr.", 2003);
    }

    @Test
    void testFullName() {
        assertEquals("Frodo Baggins", frodo.fullName());
        assertEquals("Samwise Gamgee", sam.fullName());
    }

    @Test
    void testFormalName() {
        assertEquals("Mr. Frodo Baggins", frodo.formalName());
        assertEquals("Mr. Peregrin Took", pippin.formalName());
    }

    @Test
    void testGetAgeCurrentYear() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        assertEquals(String.valueOf(currentYear - 2003), frodo.getAge());
        assertEquals(String.valueOf(currentYear - 2003), pippin.getAge());
    }

    @Test
    void testGetAgeSpecificYear() {
        assertEquals("17", sam.getAge(2020));
        assertEquals("17", merry.getAge(2020));
    }

    @Test
    void testToCSV() {
        assertEquals("Frodo,Baggins,0001,Mr.,2003", frodo.toCSV());
        assertEquals("Peregrin,Took,0004,Mr.,2003", pippin.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{\"firstName\":\"Frodo\", \"lastName\":\"Baggins\", \"ID\":\"0001\", \"title\":\"Mr.\", \"YOB\":2003}";
        assertEquals(expected, frodo.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Person><FirstName>Frodo</FirstName><LastName>Baggins</LastName><ID>0001</ID><Title>Mr.</Title><YOB>2003</YOB></Person>";
        assertEquals(expected, frodo.toXML());
    }
}
