package args;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgsTest {
    @Test
    void testBooleanFlag() {
        ArgumentParser parser = new ArgumentParser();
        Argument arg = new Argument("-l", ArgumentType.BOOL);
        parser.addArgument(arg);
        Args args = parser.parse("-l");

        assertTrue(args.getBoolean("-l"));
    }

    @Test
    void testBooleanFlagFalse() {
        ArgumentParser parser = new ArgumentParser();
        Argument arg = new Argument("-l", ArgumentType.BOOL);
        parser.addArgument(arg);
        Args args = parser.parse("");

        assertFalse(args.getBoolean("-l"));
    }

    @Test
    void testBooleanFlagTwice() {
        ArgumentParser parser = new ArgumentParser();
        parser.addArgument(new Argument("-l", ArgumentType.BOOL));
        parser.addArgument(new Argument("-v", ArgumentType.BOOL));
        Args args = parser.parse("-l -v");

        assertTrue(args.getBoolean("-l"));
        assertTrue(args.getBoolean("-v"));
    }

}
