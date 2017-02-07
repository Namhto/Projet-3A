package controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
            Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("schedule.xml"));
            Node root = xml.getDocumentElement();

            for(CourseInstance courseInstance : courses) {
                Element courseInstanceNode = xml.createElement("courseInstance");
                courseInstanceNode.setAttribute("teacher", courseInstance.teacher);
                courseInstanceNode.setAttribute("promo", courseInstance.promo);
                courseInstanceNode.setAttribute("room", courseInstance.room);
                courseInstanceNode.setAttribute("course", courseInstance.course);
                courseInstanceNode.setAttribute("time", String.valueOf(courseInstance.time));

                root.appendChild(courseInstanceNode);
            }

            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            tr.transform(new DOMSource(xml), new StreamResult(new FileOutputStream("schedule.xml")));

        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}