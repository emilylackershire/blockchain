package edu.grinnell.csc207.blockchain;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * A wrapper class over a hash value (a byte array).
 */
public class Hash {
    private final byte[] data;
    public Hash(byte[] data){
        this.data = data;
    }
    public byte[] getData() {
        return data;
    }
    public boolean isValid() {
        return Byte.toUnsignedInt(data[0]) == 0 && Byte.toUnsignedInt(data[1]) == 0 && Byte.toUnsignedInt(data[2]) == 0;
    }
    public boolean isNotValid() {
        return Byte.toUnsignedInt(data[0]) != 0 || Byte.toUnsignedInt(data[1]) != 0 || Byte.toUnsignedInt(data[2]) != 0;
    }
    @Override
    public String toString() {
        String hashString = "";
        for(int i = 0; i < data.length; i++) {
            hashString += Byte.toUnsignedInt(data[i]);
        }
        return hashString;
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Hash o) {
            Arrays.equals(o.getData(), data);
            return true;
        }
        return false;
    }
    public static byte[] calculateHash(int amount, int num, Hash prevHash, long nonce) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("sha-256");
        md.update(ByteBuffer.allocate(4).putInt(amount).array());
        if(prevHash != null) {
            md.update(prevHash.data);
        }
        md.update(ByteBuffer.allocate(8).putLong(nonce).array());
        byte[] hash = md.digest();
        return hash;
    }
}
