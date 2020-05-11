package args;

import java.util.HashMap;
import java.util.Map;

public class Args {
    private Map<String, Boolean> booleanMap = new HashMap<>();

    public boolean getBoolean(String flag) {
        Boolean result = booleanMap.get(flag);
        if (result == null) {
            result = false;
        }
        return result;
    }

    public void putBoolean(String flag, boolean value) {
        booleanMap.put(flag, value);
    }
}
