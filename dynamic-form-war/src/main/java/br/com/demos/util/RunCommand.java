package br.com.demos.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunCommand {

    public void execute(String command) throws IOException {
     
        try {
         
            final Process p = Runtime.getRuntime().exec(command);

            new Thread(new Runnable() {
                public void run() {
                    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line = null;

                    try {
                        while ((line = input.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }).start();

            p.waitFor();
        }catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

    }

}
