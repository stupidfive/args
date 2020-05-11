package args;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgsTest {
    ArgumentParser parser;

    @BeforeEach
    void setUp() {
        parser = new ArgumentParser();
    }

    @Test
    void testBooleanFlag() {
        Argument arg = new Argument("-l", ArgumentType.BOOL);
        parser.addArgument(arg);

        Args args = parser.parse("-l");

        assertTrue(args.getBoolean("-l"));
    }

    @Test
    void testBooleanFlagFalse() {
        Argument arg = new Argument("-l", ArgumentType.BOOL);
        parser.addArgument(arg);

        Args args = parser.parse("");

        assertFalse(args.getBoolean("-l"));
    }

    @Test
    void testBooleanFlagTwice() {
        parser.addArgument(new Argument("-l", ArgumentType.BOOL));
        parser.addArgument(new Argument("-v", ArgumentType.BOOL));

        Args args = parser.parse("-l -v");

        assertTrue(args.getBoolean("-l"));
        assertTrue(args.getBoolean("-v"));
    }

    @Test
    void test4() {
        parser.addArgument(new Argument("-l", ArgumentType.BOOL));
        parser.addArgument(new Argument("-v", ArgumentType.BOOL));

        Args args = parser.parse("-v");

        assertFalse(args.getBoolean("-l"));
        assertTrue(args.getBoolean("-v"));
    }

}
