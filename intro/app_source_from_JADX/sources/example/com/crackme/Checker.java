package example.com.crackme;

import android.content.Context;
import example.com.crackme.C0333i;

public class Checker {
    public static boolean check(String key, Context context) {
        return C0333i.checkKey(key, context) == C0333i.Status.KEY_GOOD;
    }

    public boolean getRandomBoolean() {
        return Math.random() < 0.5d;
    }
}
