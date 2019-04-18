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
        for(int i = 0;i<b.length;i++){
            System.out.print(b[i]);
        }
        ArrayList<Byte> listB = new ArrayList<>();
        for (int i =0;i<30;i++){
            listB.add(i,b[i]);
        }

        byte counter = 1;
        byte zero = 0;
        int curr = b[30];
        if(curr == 1){
            listB.add(zero);
            for(int i=31;i<b.length;i++){
                if((0xff&counter)==255){
                listB.add((byte)255);
                listB.add(zero);
                counter = 1;
                }
                else if(curr==b[i]){
                    counter++;
                }else{
                    listB.add(counter);
                    counter =1;
                    curr = b[i];
                }

            }
        }else{
            for(int i=31;i<b.length;i++){
                if(counter==255){
                    listB.add(counter);
                    listB.add(zero);
                    counter = 1;
                }
                else if(curr==b[i]){
                    counter++;
                }else{
                    listB.add(counter);
                    counter =1;
                    curr = b[i];
                }
            }
        }
        listB.add(counter);
        System.out.println();
        byte [] ans = new byte[listB.size()];
        for(int i = 0 ; i<ans.length;i++){
            ans[i] = listB.get(i);
            System.out.print(ans[i] + ",");
        }
        System.out.println();
        out.write(ans);
        out.flush();
        out.close();
    }
}
