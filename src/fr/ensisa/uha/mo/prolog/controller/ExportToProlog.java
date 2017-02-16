package fr.ensisa.uha.mo.prolog.controller;

import fr.ensisa.uha.mo.prolog.Model.Course;
import fr.ensisa.uha.mo.prolog.Model.Room;
import fr.ensisa.uha.mo.prolog.Model.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

/**
 * Created by maxim on 11/01/2017.
 */
public class ExportToProlog {


    public void exportTeachers(ObservableList<Teacher> teachers){
        try {
            File file = new File("server/prolog/teacher.pl");
            Writer w = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(":-module(teacher, [teacher/1, teaches/2]).\n" +
                    "\n" +
                    "%% Ce fichier contient les informations relatives aux enseignants &&\n" +
                    "\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "%%%%%%%%%%%% Enseignants %%%%%%%%%%%%%\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
            for (Teacher teacher : teachers) {
                bw.write("teacher('"+teacher.getName()+"').\n");
            }
            bw.write("\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "%%%%%%% Relations prof - cours %%%%%%%\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
            for(Teacher teacher : teachers){
                if(teacher.getEnseigne()!=null) {
                    bw.write("teaches('"+teacher.getName()+"','"+teacher.getEnseigne().getName()+"').\n");
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
            bw.write(":-module(salle,[room/1, roomSize/2, roomEquipment/2, roomType/2]).\n" +
                    "\n" +
                    "%% Ce fichier contient les informations relatives aux salles de cours %%\n" +
                    "\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "%%%%%%% Salles %%%%%%%\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%\n");
            for (Room room : rooms) {
                bw.write("room('"+room.getName()+"').\n");
            }
            bw.write("%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "%%%%%%% Taille %%%%%%%\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%\n");
            for(Room room : rooms) {
                bw.write("roomSize('"+room.getName()+"',40).\n");
            }
            bw.write("\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "%%% Equipements %%%%%%\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "equipment('computer').\n" +
                    "equipment('motor').\n" +
                    "equipment('projector').\n" +
                    "equipment('board').\n" +
                    "\n" +
                    "roomEquipment(R,E):- room(R), equipment(E).\n" +
                    "\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "%%%% Type salle %%%%%%\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%\n");
            for(Room room : rooms) {
                bw.write("roomType('"+room.getName()+"',normal).\n");
            }
            bw.flush();
            bw.close();
        }
        catch (IOException e){

        }
    }

    public void exportCourses(ObservableList<Course> courses){
        try {
            File file = new File("server/prolog/course.pl");
            Writer w = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(":- module(course, [course/1, isTP/1, isTD/1, isMagistral/1]).\n" +
                    "\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "%%%%%% course %%%%%%\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
            for (Course course : courses) {
                bw.write("course('"+course.getName()+"').\n");
            }
            bw.write("\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "%%%%%% magistral %%%%%%\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
            for (Course course : courses) {
                bw.write("magistral('"+course.getName()+"').\n");
            }
            bw.write("\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "%%%%%% tp %%%%%%\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");

            bw.write("tp('xxxxxxxxxx').\n");

            bw.write("tp('yyyyyyyyyyy').\n");

            bw.write("\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "%%%%%% règles %%%%%%\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                    "isTP(Course) :- course(Course),\n" +
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