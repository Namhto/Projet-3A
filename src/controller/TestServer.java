package controller;

import java.io.*;

/**
 * Created by othman on 13/01/2017.
 */
public class TestServer {

    public static void main(String args[]) {

        try {
            Runtime.getRuntime().exec("cmd /c start server\\server.bat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
