package oops.IO;

import java.io.*;

public class BufferedReader {
    static void main() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String name = br.readLine();
    }
}
