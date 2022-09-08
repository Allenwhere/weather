import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    private PrintStream console = null;
    private ByteArrayOutputStream bytes = null;

    @BeforeEach
    public void setUp() {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @AfterEach
    public void after() {
        System.setOut(console);
    }
    @org.junit.jupiter.api.Test
    void fizzBuzzValues() {
    String f = "fizz";
    String b = "buzz";
    String fb = "fizzbuzz";
    FizzBuzz.FizzBuzzValues(1,15);
    String expected = new String(f+"\n"+b+"\n"+f+"\n"+f+"\n"+b+"\n"+f+"\n"+fb);
    assertEquals(expected,bytes.toString().trim().replace("\r",""));

    }
}