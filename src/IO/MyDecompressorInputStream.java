package IO;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {
    InputStream in;


    public MyDecompressorInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    public int read(byte[] b) throws IOException {
        String details;

        // numOfRows - build a string from 5 first bytes and parse it to int
        // numOfCol - build a string from 5 next bytes and parse it to int
        // startPos(X) - build a string from 5 next bytes and parse it to int
        // startPos(Y) - build a string from 5 next bytes and parse it to int
        // goalPos(X) - build a string from 5 next bytes and parse it to int
        // goalPos(Y) - build a string from 5 next bytes and parse it to int

        //start reading next cells according to format : "0 4 1 2...." means 0 appeared 4 times, 1 appeared 2 times.
        //convert them to int inside the 2d array of maze at each iteration.

        return b.length;


    }
}
