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
        ArgumentType waitType = null;
        String key = null;
        for (String token : tokens) {
            if (waitType == ArgumentType.STRING) {
                args.putString(key, token);
            }

            ArgumentType type = types.get(token);
            if (type == ArgumentType.BOOL) {
                args.putBoolean(token, true);
            } else if (type == ArgumentType.STRING) {
                waitType = type;
                key = token;
            }
        }
        return args;
    }
}
