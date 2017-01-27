package controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by othman on 19/01/2017.
 */
public class TestParseResponse {

    public void parse(String response) {
        System.out.println(response);

        ArrayList<CourseInstance> list = new ArrayList<>();
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(response);
        while(m.find()) {
            String[] courseInstance = m.group(1).split(",");
            list.add(new CourseInstance(courseInstance[0], courseInstance[1], courseInstance[2], courseInstance[3], Integer.valueOf(courseInstance[4])));
        }
    }
}
