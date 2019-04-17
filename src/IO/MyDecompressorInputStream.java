package IO;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {


    public MyDecompressorInputStream(InputStream fileInputStream) {

    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}
