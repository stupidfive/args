package args;

import java.util.HashMap;
import java.util.Map;

public class ArgumentParser {
    private Map<String, ArgumentType> types = new HashMap();

    public void addArgument(Argument arg) {
        types.put(arg.flag, arg.type);
    }

    public Args parse(String input) {
        Args args = new Args();
        if (input.contains("-l")) {
            args.putBoolean("-l", true);
        }
        return args;
    }
}
