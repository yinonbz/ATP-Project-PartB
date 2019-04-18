package IO;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

        in.read(b);

        byte[] b2;
        List<Byte> details = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            details.add(b[i]);
        }
        int size2 = b.length;
        byte value = 0;
        for (int i = 30; i < b.length; i++) {
            for (int j = 0; j < b[i]; j++) {
                details.add(value);
            }
            if (value ==0){
                value =1;
            }
            else{
                value =0;
            }
        }

        int size = details.size();
        for (int i = 0; i < size; i++) {
            b[i] = details.get(i);
            System.out.print(b[i]);
        }
        System.out.println();

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
