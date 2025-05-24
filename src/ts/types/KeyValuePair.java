package ts.types;

import java.util.HashMap;
import java.util.Map;

public class KeyValuePair extends Type {

    Map<String, String> keyValue;

    public KeyValuePair(Map<String, String> keyValue) {
        this.keyValue = keyValue;
    }

    public KeyValuePair() {
        this.keyValue = new HashMap<>();
    }

    public Map<String, String> getKeyValue() {
        return keyValue;
    }

    public void addToKeyValue(String key, String value) {
        keyValue.put(key, value);
    }

    public void setKeyValue(Map<String, String> keyValue) {
        this.keyValue = keyValue;
    }

    @Override
    public String toString() {
        return keyValue.toString();
    }

}
