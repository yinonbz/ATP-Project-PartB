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

        in.read(b);

        byte[] b2;
        //byte[] b2 = new byte[b.length];

        StringBuilder details = new StringBuilder("");

        for (int i =0;i<30;i++){
            details.append(b[i]);
        }
        int counter =0;
        int value = b[30];
        int cell =30;
        for(int i=30; i<b.length;i++){
            if (i%2 ==0){
                value = b[i];
            }
            if(i%2 !=0){
                for(int j=0;j<b[i];j++){
                    details.append(value);
                    cell = cell+b[i];
                }
            }
        }

        /*for (int i =0;i<30;i++){
            b2[i] = b[i];
        }
        int counter =0;
        int value = b[30];
        int cell =30;
        for(int i=30; i<b.length;i++){
            if (i%2 ==0){
                value = b[i];
            }
            if(i%2 !=0){
                for(int j=0;j<b[i];j++){
                    b2[cell] = (byte)value;
                    cell = cell+b[i];
                }
            }
        } */
        String maze = details.toString();
        b2 = new byte[details.length()];
        for(int i=0; i<maze.length();i++){
            //int a = (int)details.charAt(i) - 48;
            String str = Character.toString(details.charAt(i));
            b2[i] = (byte) Integer.parseInt(str);
        }

        for(int i =0;i<b2.length;i++){
            b[i] = b2[i];
        }



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
