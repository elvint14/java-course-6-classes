package az.et.recap.lesson02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramStringsAppTest {

    @Test
    void isAnagram_Should_ReturnSuccess() {
        boolean expected = true;
        boolean actual = AnagramStringsApp.isAnagram("abcd", "dabc");
        assertEquals(expected, actual);
        assertTrue(actual);
    }

}