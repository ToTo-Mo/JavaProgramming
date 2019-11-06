import java.io.UnsupportedEncodingException;

public class test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println((byte)2);
        byte[] byte1 = new byte[10];
        System.arraycopy("hello".getBytes("utf-8"), 0, byte1, 1, "hello".getBytes().length);
        byte[] byte2 = "a".getBytes();
        System.out.println(new String(byte1));
        System.out.println(new String(byte1));
        System.out.println(new String(byte2));
        
    }
}