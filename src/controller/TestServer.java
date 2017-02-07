package controller;

import java.beans.XMLEncoder;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by othman on 13/01/2017.
 */
public class TestServer {

    public void run() {

        try {
            Runtime.getRuntime().exec("cmd /c start server\\server.bat");

            Thread.sleep(3000);
            URL url = new URL("http://localhost:4040/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuffer response = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }

            handleResponse(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void handleResponse(String res) {
        TestParseResponse parser = new TestParseResponse();
        ArrayList<CourseInstance> courses = parser.parse(res);

        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("schedule.xml")));
            encoder.writeObject(courses);
            encoder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}