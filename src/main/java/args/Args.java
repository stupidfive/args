package args;

import java.util.HashMap;
import java.util.Map;

public class Args {
    private Map<String, Boolean> booleanMap = new HashMap<>();
    private Map<String, Object> map = new HashMap<>();

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

    public String getString(String flag) {
        return (String) map.get(flag);
    }

    public void putString(String flag, String value) {
        map.put(flag, value);
    }
}
