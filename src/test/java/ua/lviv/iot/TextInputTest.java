package ua.lviv.iot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextInputTest {

    TextInput textInput;

    @Test
    void creatingTextInputPassingNull() {

        assertThrows(NullPointerException.class, () -> new TextInput(null));
    }

    @Test
    void getDomainsWithEmptyInput() {

        String input = "";                             //empty input

        int actual;

        textInput = new TextInput(input);
        textInput.findEmail();
        textInput.findDomains();
        actual = textInput.getDomainSet().size();

        assertEquals(0, actual);
    }

    @Test
    void getDomains() {

        String input = "max$kuz@gmail.com" +            //not allowed sign is used
                "max@icloud.com" +                      //too short username
                "viruslviv@gmail.com" +                 //valid email
                "max-kuzmovych@icloud.com" +            //valid email
                "someone@yahoo.com";                    //valid email

        int actual;

        textInput = new TextInput(input);
        textInput.findEmail();
        textInput.findDomains();
        actual = textInput.getDomainSet().size();

        assertEquals(3, actual);
    }

}