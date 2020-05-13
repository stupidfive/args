package args;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgsTest {
    ArgumentParser parser;

    @BeforeEach
    void setUp() {
        parser = new ArgumentParser();
        parser.addArgument(new Argument("-l", ArgumentType.BOOL));
        parser.addArgument(new Argument("-p", ArgumentType.INTEGER));
        parser.addArgument(new Argument("-d", ArgumentType.STRING));
    }

    @Test
    void testBooleanFlag() {
        Args args = parser.parse("-l");

        assertTrue(args.getBoolean("-l"));
    }

    @Test
    void testBooleanFlagFalse() {
        Args args = parser.parse("");

        assertFalse(args.getBoolean("-l"));
    }

    @Test
    void testBooleanFlagTwice() {
        parser.addArgument(new Argument("-v", ArgumentType.BOOL));

        Args args = parser.parse("-l -v");

        assertTrue(args.getBoolean("-l"));
        assertTrue(args.getBoolean("-v"));
    }

    @Test
    void test4() {
        parser.addArgument(new Argument("-v", ArgumentType.BOOL));

        Args args = parser.parse("-v");

        assertFalse(args.getBoolean("-l"));
        assertTrue(args.getBoolean("-v"));
    }

    @Test
    void testString1() {
        Args args = parser.parse("-d /usr/logs");
        assertEquals("/usr/logs", args.getString("-d"));
    }

    @Test
    void testString2() {
        Args args = parser.parse("-d /usr/bin");
        assertEquals("/usr/bin", args.getString("-d"));
    }

    @Test
    void testMultipleString() {
        parser.addArgument(new Argument("-u", ArgumentType.STRING));

        Args args = parser.parse("-d /usr/bin -u root");
        assertEquals("/usr/bin", args.getString("-d"));
        assertEquals("root", args.getString("-u"));
    }

    @Test
    void testIntegerArgument() {
        Args args = parser.parse("-p 8080");
        assertEquals(8080, args.getInteger("-p"));
    }

    @Test
    void testIntegerArgument2() {
        Args args = parser.parse("-p 9090");
        assertEquals(9090, args.getInteger("-p"));
    }
}
