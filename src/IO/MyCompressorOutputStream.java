package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

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
    @Override
    public void write(byte[] b)throws IOException{
        ArrayList<Byte> listB = new ArrayList<>();
        for (int i =0;i<30;i++){
            listB.add(i,b[i]);
        }
        byte counter =1;
        int prev = b[30];
        int k=31;
        listB.add(30,b[30]);
        for(int i = 31 ;i<b.length;i++){
            if(prev == b[i]) {
                counter++;
            }
             else{
                listB.add(k,counter);
                counter = 1;
                prev = b[i];
                listB.add(k+1,b[i]);
                k=k+2;
            }
        }
        byte [] ans = new byte[listB.size()];
        for(int i = 0 ; i<ans.length;i++){
            ans[i] = listB.get(i);
        }
        out.write(ans);
        out.flush();
        out.close();
    }

}
