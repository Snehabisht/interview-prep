package oops.IO;

import java.io.*;

public class BufferedReaderClass {
    static void main() throws IOException{
      //  InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        System.out.println(name);
    }
}
