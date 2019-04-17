package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.io.*;
public class MyCompressorOutputStream extends OutputStream {
    private OutputStream out;

    public MyCompressorOutputStream(OutputStream Other_out) {
        if (Other_out != null) {
            this.out = Other_out;
        } else {
            this.out = null;
        }
    }

    @Override
    public void write(int b) throws IOException {

    }
}
