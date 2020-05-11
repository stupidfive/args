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
        String[] tokens = input.split("\\s");
        for (String token : tokens) {
            args.putBoolean(token, true);
        }
        return args;
    }
}
