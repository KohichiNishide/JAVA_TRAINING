package ch20.ex03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

        byte[] plain = new byte[3];    // 平文
        byte key = (byte)0x0F;         // 鍵
        
        byte[] encrypt = new byte[3];  // 暗号文
        byte[] decrypt = new byte[3];  // 復号文

        // 平文の設定
        plain[0] = (byte)0x0F; // 0000 1111
        plain[1] = (byte)0x55; // 0101 0101
        plain[2] = (byte)0xAA; // 1010 1010

        // 平文の表示
        System.out.println("*** 平文 ***");
        for (byte tmp : plain)
            System.out.println(toBinaryString(tmp));

        // 暗号化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        EncryptOutputStream encos = new EncryptOutputStream(baos, key);
        encos.write(plain);
        encrypt = baos.toByteArray();

        // 暗号文の表示
        System.out.println("*** 暗号文 ***");
        for (byte tmp : encrypt)
            System.out.println(toBinaryString(tmp));

        // 復号化
        ByteArrayInputStream bais = new ByteArrayInputStream(encrypt);
        DecryptInputStream decis = new DecryptInputStream(bais, key);
        decis.read(decrypt);

        // 復号文の表示
        System.out.println("*** 復号文 ***");
        for (byte tmp : decrypt)
            System.out.println(toBinaryString(tmp));

    }
	
	public static String toBinaryString(byte b) {
        char[] buf = new char[8];
        int shift = 1;
        for (int i=7; i>=0; i--) {
            if ((shift & b) == 1) {
                buf[i] = '1';
            } else {
                buf[i] = '0';
            }
            b = (byte)(b >> 1);
        }
        return new String(buf);
    }

}
