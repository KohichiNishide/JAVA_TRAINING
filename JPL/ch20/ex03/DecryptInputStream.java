package ch20.ex03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream {
	byte key;
	public DecryptInputStream(InputStream in, byte key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        int tmp = super.read();
        return tmp^key;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int ret = super.read(b, off, len);
        for (int i=off; i<b.length; i++) {
            int tmp = b[i]^key;
            b[i] = (byte)tmp;
        }
        return ret;
    }
}
