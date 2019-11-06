package utils;

import java.util.HashMap;


public class CharCounter extends HashMap<Character, Integer> {
    public CharCounter() {
        super();
    }
    public CharCounter(CharCounter charCounter) {
        super(charCounter);
    }

    public boolean contains(CharCounter word) {
        for (Entry<Character, Integer> entry : word.entrySet()) {
            if (containsKey(entry.getKey())) {
                if (get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void add(final String string) {
        for (Character c : string.toCharArray()) {
            add(c);
        }
    }

    public void add(final Character key) {
        int curValue = 0;
        if (containsKey(key)) {
            curValue = get(key);
        }
        put(key, ++curValue);
    }

    public Integer remove(final Character key) {
        if (containsKey(key)) {
            int curValue = get(key);
            if (curValue <= 1) {
                return super.remove(key);
            }
            put(key, --curValue);
            return curValue;
        }
        return 0;
    }
}
