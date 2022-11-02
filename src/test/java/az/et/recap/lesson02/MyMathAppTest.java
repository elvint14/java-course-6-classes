package az.et.recap.lesson02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathAppTest {

    private MyMathApp app;

    @BeforeEach
    void setUp() {
        app = new MyMathApp();
    }

    @Test
    void multiply_Should_ReturnSuccess() {
        int expected = 2;
        int actual = app.multiply(1, 2);

        assertEquals(expected, actual);
    }

    @Test
    void isEven_Should_ReturnSuccess() {
        assertTrue(app.isEven(2));
    }

    @Test
    void isNotNull_Should_ThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> app.isNotNull(null));
    }

}