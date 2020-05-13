package args;

import java.util.HashMap;
import java.util.Map;

public class ArgumentParser {
    private Map<String, ArgumentType> types = new HashMap();

    public void addArgument(Argument arg) {
        types.put(arg.flag, arg.type);
    }

    public Args parse(String input) {
        String[] tokens = input.split("\\s");
        return parseTokens(tokens);
    }

    private Args parseTokens(String[] tokens) {
        Args args = new Args();

        String key = null;
        ArgumentType waitValueOfType = null;

        for (String token : tokens) {
            if (waitValueOfType != null) {
                if (waitValueOfType == ArgumentType.STRING) {
                    args.putString(key, token);
                } else if (waitValueOfType == ArgumentType.INTEGER) {
                    args.putInteger(key, Integer.parseInt(token));
                }
                key = null;
                waitValueOfType = null;
                continue;
            }

            ArgumentType type = types.get(token);
            if (type == ArgumentType.BOOL) {
                args.putBoolean(token, true);
            } else {
                key = token;
                waitValueOfType = type;
            }
        }
        return args;
    }

}
