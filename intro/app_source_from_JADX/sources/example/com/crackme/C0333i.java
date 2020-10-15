package example.com.crackme;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: example.com.crackme.i */
public class C0333i {
    static final /* synthetic */ boolean $assertionsDisabled;

    /* renamed from: l */
    private static byte[][] f28l;

    /* renamed from: example.com.crackme.i$Status */
    public enum Status {
        KEY_GOOD,
        KEY_INVALID
    }

    static {
        boolean z;
        if (!C0333i.class.desiredAssertionStatus()) {
            z = true;
        } else {
            z = false;
        }
        $assertionsDisabled = z;
        /*
        f28l = new byte[0][];
        byte[][] v0 = new byte[20][];
        v0[0] = new byte[]{26, 6, 125};
        byte[] v6 = new byte[11];
        v0[1] = new byte[]{64, 118, -91, 90, 7, -17, -114, 118, -49, 31, -40};
        v6[3] = 68;
        v0[2] = new byte[]{8, 1, 36};
        v6[0] = 103;
        v0[13] = new byte[]{97, 110, 100, 114, 111, 105, 100, 46, 116, 101, 108, 101, 112, 104, 111, 110, 121, 46, 84, 101, 108, 101, 112, 104, 111, 110, 121, 77, 97, 110, 97, 103, 101, 114};
        v6[1] = 101;
        v6[2] = 116;
        v0[3] = new byte[]{-70, -16, 42, -68, Byte.MAX_VALUE, 34, -66, -74, -102};
        byte[] v2 = new byte[3];
        v2[2] = 16;
        v2[1] = 88;
        v6[4] = 101;
        v6[5] = 118;
        v6[6] = 105;
        v6[7] = 99;
        v6[8] = 101;
        v6[9] = 73;
        v0[4] = v2;
        v0[5] = new byte[]{14, 6, 22};
        v6[10] = 100;
        byte[] v3 = new byte[5];
        v3[2] = 103;
        v3[4] = 104;
        v3[3] = 116;
        v3[0] = 101;
        v3[1] = 110;
        v0[6] = v3;
        v0[7] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 116, 114, 105, 110, 103};
        byte[] v4 = new byte[12];
        v4[10] = 101;
        v4[1] = 101;
        v4[3] = 82;
        byte[] v5 = new byte[15];
        v4[0] = 103;
        v4[7] = 117;
        v4[11] = 115;
        v4[2] = 116;
        v5[0] = 48;
        v5[2] = 48;
        v0[16] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 79, 98, 106, 101, 99, 116};
        v5[1] = 48;
        v4[4] = 101;
        v5[3] = 48;
        v4[9] = 99;
        v0[12] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 121, 115, 116, 101, 109};
        v5[4] = 48;
        v4[5] = 115;
        v4[8] = 114;
        v0[17] = v6;
        v5[5] = 48;
        byte[] v8 = new byte[6];
        v5[6] = 48;
        v5[7] = 48;
        v0[14] = new byte[]{101, 120, 105, 116};
        v5[8] = 48;
        v5[9] = 48;
        v8[1] = 113;
        v4[6] = 111;
        v5[10] = 48;
        v0[9] = v4;
        v0[8] = new byte[]{97, 110, 100, 114, 111, 105, 100, 46, 99, 111, 110, 116, 101, 110, 116, 46, 67, 111, 110, 116, 101, 120, 116};
        v5[11] = 48;
        v8[0] = 101;
        v8[3] = 97;
        v5[12] = 48;
        v8[2] = 117;
        v5[13] = 48;
        v8[4] = 108;
        v8[5] = 115;
        v5[14] = 48;
        v0[10] = new byte[]{83, 72, 65, 45, 49};
        v0[11] = v5;
        v0[15] = v8;
        f28l = v0;
*/
        byte[][] v0 = new byte[20][];
        f28l = new byte[0][];
        // BEGIN ???
        v0[0] = new byte[]{26, 6, 125};
        v0[1] = new byte[]{64, 118, -91, 90, 7, -17, -114, 118, -49, 31, -40};
        v0[2] = new byte[]{8, 1, 36};
        v0[3] = new byte[]{-70, -16, 42, -68, 127, 34, -66, -74, -102};
        v0[4] = new byte[] {0, 88, 16}; 
        v0[5] = new byte[]{14, 6, 22};
        // ??? END
        // l? ength
        v0[6] = new byte[] {101, 110, 103, 116, 104};
        // java.lang.String 
        v0[7] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 116, 114, 105, 110, 103}; 
        // android.content.Context
        v0[8] = new byte[]{97, 110, 100, 114, 111, 105, 100, 46, 99, 111, 110, 116, 101, 110, 116, 46, 67, 111, 110, 116, 101, 120, 116};
        // getResources 
        v0[9] = new byte[] {103, 101, 116, 82, 101, 115, 111, 117, 114, 99, 101, 115};    
        // "SHA-1"
        v0[10] = new byte[]{83, 72, 65, 45, 49}; 
        // "000000000000000"
        v0[11] = new byte[] {48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48}; 
        // java.lang.System
        v0[12] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 121, 115, 116, 101, 109}; 
        // android.telephony.TelephonyManager
        v0[13] = new byte[]{97, 110, 100, 114, 111, 105, 100, 46, 116, 101, 108, 101, 112, 104, 111, 110, 121, 46, 84, 101, 108, 101, 112, 104, 111, 110, 121, 77, 97, 110, 97, 103, 101, 114};
        // exit
        v0[14] = new byte[]{101, 120, 105, 116}; 
        // "equals"
        v0[15] = new byte[]{101,113,117,97,108,115}; 
        // java.lang.Object
        v0[16] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 79, 98, 106, 101, 99, 116};
        // getDeviceId 
        v0[17] = new byte[] {103, 101, 116, 68, 101, 118, 105, 99, 101, 73, 100}; 
         
        f28l = v0;
    }

    @TargetApi(19)
    public static Status checkKey(String key, Context context) {
        try {
            Class javaString = Class.forName("java.lang.String");
            Class androidContext = Class.forName("android.content.Context");
            try {
                if ($assertionsDisabled || androidContext != null) {
                    Method getResources = androidContext.getDeclaredMethod("getResources", new Class[0]);
                    TelephonyManager telManager = (TelephonyManager) context.getSystemService("phone");
                    try {
                        if (!$assertionsDisabled && javaString == null) {
                            throw new AssertionError();
                        } else if ($assertionsDisabled || getResources != null) {
                            Class[] clsArr = new Class[0];
                            Method clsArr_length = javaString.getDeclaredMethod("length", clsArr);
                            try {
                                Method stringEquals = javaString.getDeclaredMethod("equals", new Class[]{Object.class});
                                try {
                                    Class<?> javaSystem = Class.forName("java.lang.System");
                                    Class<?> telManager2 = Class.forName("android.telephony.TelephonyManager");
                                    try {
                                        if (!$assertionsDisabled && telManager2 == null) {
                                            throw new AssertionError();
                                        } else if ($assertionsDisabled || javaSystem != null) {
                                            Method getDeviceId = telManager2.getDeclaredMethod("getDeviceId", new Class[0]);
                                            Method exit = javaSystem.getDeclaredMethod("exit", new Class[]{Integer.TYPE});
                                            try {
                                                // if deviceId == 000000000000000
                                                // -> exit
                                                if (((Boolean) stringEquals.invoke(getDeviceId.invoke(telManager, new Object[0]), "000000000000000")).booleanValue()) {
                                                     exit.invoke(javaSystem, new Object[]{0});
                                                }
                                                try {
                                                    if ($assertionsDisabled || clsArr_length != null) {

                                                        if (!((Boolean) stringEquals.invoke(Integer.toString(((Integer) clsArr_length.invoke(key.replaceAll("-", "").toLowerCase(Locale.UK), new Object[0])).intValue()), "88")).booleanValue()) {
                                                            return Status.KEY_INVALID;
                                                        }
                                                        try {
                                                            byte[] pkey = Arrays.copyOf(
                                                                MessageDigest //b22a4c2d516e253453b34fc49d5eda316ea1c1da
                                                                    .getInstance("SHA-1")
                                                                    .digest(
                                                                        new byte[]{
                                                                            30,//getbyte(123, (byte)14/*f28l[5][0]*/, (byte)125/*f28l[0][2]*/, (byte)6/*f28l[0][1]*/),
                                                                            2,
                                                                            120//getbyte(321, (byte)6/*f28l[0][1]*/, (byte)14/*f28l[5][0]*/, (byte)125/*f28l[0][2]*/)
                                                                        }
                                                                    ), 
                                                                16 // new length
                                                            );
                                                            byte[] encryptedPart = new byte[(f28l[1].length + f28l[3].length)];
                                                            System.arraycopy(f28l[1], 0, encryptedPart, 0, f28l[1].length);
                                                            System.arraycopy(f28l[3], 0, encryptedPart, f28l[1].length, f28l[3].length);
                                                            byte[] encrypted = new byte[(encryptedPart.length + 12)];
                                                            System.arraycopy(encryptedPart, 0, encrypted, 0, encryptedPart.length);
                                                            System.arraycopy(new byte[]{122, 125, -19, 33, 69, 71, 112, -6, 36, 19, -90, 118}, 0, encrypted, encryptedPart.length, 12);
                                                            if (((Boolean) stringEquals.invoke(
                                                                key.replaceAll("-", "").toLowerCase(Locale.UK)
                                                                , new Object[]{new String(keyAes(pkey, encrypted))}
                                                                )).booleanValue()) {
                                                                return Status.KEY_GOOD;
                                                            }
                                                            return Status.KEY_INVALID;
                                                        } catch (NumberFormatException e) {
                                                            return Status.KEY_INVALID;
                                                        } catch (Exception e2) {
                                                            return Status.KEY_GOOD;
                                                        }
                                                    } else {
                                                        throw new AssertionError();
                                                    }
                                                } catch (IllegalAccessException | InvocationTargetException e3) {
                                                    return Status.KEY_INVALID;
                                                }
                                            } catch (IllegalAccessException | InvocationTargetException e4) {
                                                return Status.KEY_INVALID;
                                            }
                                        } else {
                                            throw new AssertionError();
                                        }
                                    } catch (NoSuchMethodException e5) {
                                        return Status.KEY_INVALID;
                                    }
                                } catch (ClassNotFoundException e6) {
                                    return Status.KEY_INVALID;
                                }
                            } catch (NoSuchMethodException e7) {
                                return Status.KEY_INVALID;
                            }
                        } else {
                            throw new AssertionError();
                        }
                    } catch (IllegalAccessException | NoSuchMethodException e8) {
                        return Status.KEY_INVALID;
                    } catch (InvocationTargetException e9) {
                        return Status.KEY_INVALID;
                    }
                } else {
                    throw new AssertionError();
                }
            } catch (NoSuchMethodException e10) {
                return Status.KEY_INVALID;
            }
        } catch (ClassNotFoundException e11) {
            return Status.KEY_INVALID;
        }
    }

    private static byte getbyte(int seed, byte a, byte b, byte c) {
        int v0 = a % 25;
        int v1 = b % 3;
        return v0 % 2 == 0 ? (byte) (((seed >> v0) & 255) ^ ((seed >> v1) | c)) : (byte) (((seed >> v0) & 255) ^ ((seed >> v1) & c));
    }

    private static byte _getbyte(int seed, byte a, byte b, byte c) {
        int v0 = a % 25;
        int v1 = b % 3;
        return v0 % 2 == 0 ? (byte) (((seed >> v0) & 255) ^ ((seed >> v1) | c)) : (byte) (((seed >> v0) & 255) ^ ((seed >> v1) & c));
    }

    protected static String intToHex(Number n, int chars) {
        return String.format("%0" + chars + "x", new Object[]{n});
    }

    private static byte[] keyAes(byte[] key, byte[] output) throws Exception {
        SecretKeySpec KeySpec = new SecretKeySpec(key, "AES");
        Cipher aesInst = Cipher.getInstance("AES");
        aesInst.init(Cipher.DECRYPT_MODE, KeySpec);
        return aesInst.doFinal(output);
    }
}
