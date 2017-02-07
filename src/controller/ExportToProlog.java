package controller;

import Model.Course;
import Model.Room;
import Model.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

import static com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text.NEW_LINE;

/**
 * Created by maxim on 11/01/2017.
 */
public class ExportToProlog {


    public void exportTeachers(ObservableList<Teacher> teachers){
        try {
            File file = new File("server/prolog/teacher.pl");
            Writer w = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(":-module(teacher, [teacher/1, teaches/2]).");
            bw.newLine();
            for (Teacher teacher : teachers) {
                bw.write("teacher('");
                bw.write(teacher.getName());
                bw.write("').");
                bw.newLine();
            }
            bw.newLine();
            for(Teacher teacher : teachers){
                if(teacher.getEnseigne()!=null) {
                    bw.write("teaches('");
                    bw.write(teacher.getName());
                    bw.write("','");
                    bw.write(teacher.getEnseigne().getName());
                    bw.write("').");
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        }
        catch (IOException e){

        }

    }

    public void exportRooms(ObservableList<Room> rooms){
        try {
            File file = new File("server/prolog/salle.pl");
            Writer w = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(":-module(salle,[room/1, roomSize/2, roomEquipment/2, roomType/2]).");
            bw.newLine();
            for (Room room : rooms) {
                bw.write("room('");
                bw.write(room.getName());
                bw.write("').");
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (IOException e){

        }
    }

    public void exportCourses(ObservableList<Course> courses){
        try {
            File file = new File("server/prolog/courses.pl");
            Writer w = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(":- module(course, [course/1, isTP/1, isTD/1, isMagistral/1]).");
            bw.newLine();
            for (Course course : courses) {
                bw.write("course('");
                bw.write(course.getName());
                bw.write("').");
                bw.newLine();
            }

            bw.newLine();
            bw.write("isTP(Course) :- course(Course),\n" +
                    "\t\t\t\ttp(Course).\n" +
                    "\t\t\t\t\n" +
                    "isTD(Course) :- course(Course),\n" +
                    "\t\t\t\ttd(Course).\n" +
                    "\t\t\t\t\n" +
                    "isMagistral(Course) :- \tcourse(Course),\n" +
                    "\t\t\t\t\t\tmagistral(Course).");
            bw.flush();
            bw.close();
        }
        catch (IOException e){

        }

    }

    public static void main (String args[]) throws IOException {

        ObservableList<Teacher> teachers = FXCollections.observableArrayList();

        teachers.add(new Teacher("Perronne"));
        teachers.add(new Teacher("Hassenforder"));
        teachers.add(new Teacher("Thirion"));
        teachers.add(new Teacher("Bourgeois"));
        teachers.add(new Teacher("Studer"));
        teachers.add(new Teacher("Ruma"));
        teachers.add(new Teacher("Djedjick"));

        //exportTeachers(teachers);

        /*try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("filename.txt"), "utf-8"));
            writer.write("Something");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}