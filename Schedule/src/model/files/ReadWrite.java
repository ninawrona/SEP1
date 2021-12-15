package model.files;

import model.basic.*;
import model.list.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class ReadWrite {
    /**
     * Method reading in a SessionList and a String for chosen classGroup and turning it into and xml file
     * @param sessions A SessionList object
     * @param chosenClassGroup A String of the chosenClassGroup
     */
    public static void manualWriteSessionList(SessionList sessions, String chosenClassGroup)//put Semester+ClassName.
    {
        File file = new File("SessionList" + chosenClassGroup + ".xml");
        try {
            PrintWriter out = new PrintWriter(file);

            String xml = "";
            xml +=
                    "<?xml version=\"1.0\" encoding=\"UTF-8\"" + "standalone=\"no\"?>\n";

            xml += "\n<SessionList>";
            for (int i = 0; i < sessions.size(); i++) {

                xml += "\n<Session>";
                xml += "\n    <Course>" + sessions.get(i).getCourse() + "</Course>";
                xml += "\n    <Class>" + sessions.get(i).getCourse().getClassGroup()
                        + "</Class>";
                xml += "\n    <Teachers>";
                for (int j = 0;
                     j < sessions.get(i).getCourse().getTeachers().size(); j++) {
                    xml +=
                            sessions.get(j).getCourse().getTeachers().get(j).getViaId() + ",";
                }
                xml += "</Teachers>";

                xml += "\n    <Date>" + sessions.get(i).getDate() + "</Date>";

                xml += "\n    <WeekDay>" + sessions.get(i).getDate().getWeekday()
                        + "</WeekDay>";
                xml += "\n    <StartTime>" + sessions.get(i).getStartTime()
                        + "</StartTime>";
                xml += "\n    <NumberOfLessons>" + sessions.get(i).getNumberOfLessons()
                        + "</NumberOfLessons>";

                xml += "\n    <EndTime>" + sessions.get(i).getEndTime() + "</EndTime>";

                if (sessions.get(i).getRoom() == null) {
                    xml += "\n   <Room>unassigned</Room>";
                } else {
                    xml += "\n    <Room>" + sessions.get(i).getRoom() + "</Room>";
                }

                xml += "\n</Session>";

            }
            xml += "\n</SessionList>";
            out.println(xml);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method reading in a File file and turning it into a ClassGroupList
     * @param file File object with students
     * @return returns a ClassGroupList
     */
    public static ClassGroupList manualReadStudents(File file) {

        ClassGroupList classGroupList = new ClassGroupList();

        try {
            Scanner in = new Scanner(file);
            Student student;
            int semester = 0;
            String classGroup = "";
            String name = null;
            int viaId = 0;
            String[] parts;

            while (in.hasNext()) {
                String line = in.nextLine();
                if (line.contains(",")) {
                    //divides the line by commas
                    parts = line.split(",");
                    if (parts.length == 4) {
                        semester = Integer.parseInt(parts[0]);
                        classGroup = parts[1].toUpperCase();
                        viaId = Integer.parseInt(parts[2]);
                        name = parts[3];

                        student = new Student(semester, name, viaId);

                        String classGroupString = "";
                        classGroupString += semester;

                        classGroupString += classGroup;
                        switch (classGroupString) {
                            case "1X": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 1 && classGroupList
                                            .get(i).getClassName().equals("X")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "1Y": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 1 && classGroupList
                                            .get(i).getClassName().equals("Y")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "1Z": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 1 && classGroupList
                                            .get(i).getClassName().equals("Z")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "1DK": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 1 && classGroupList
                                            .get(i).getClassName().equals("DK")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "2X": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 2 && classGroupList
                                            .get(i).getClassName().equals("X")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "2Y": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 2 && classGroupList
                                            .get(i).getClassName().equals("Y")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "2Z": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 2 && classGroupList
                                            .get(i).getClassName().equals("Z")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "2DK": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 2 && classGroupList
                                            .get(i).getClassName().equals("DK")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "3X": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 3 && classGroupList
                                            .get(i).getClassName().equals("X")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "3Y": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 3 && classGroupList
                                            .get(i).getClassName().equals("Y")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "3Z": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 3 && classGroupList
                                            .get(i).getClassName().equals("Z")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "3DK": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 3 && classGroupList
                                            .get(i).getClassName().equals("DK")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "4X": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 4 && classGroupList
                                            .get(i).getClassName().equals("X")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "4Y": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 4 && classGroupList
                                            .get(i).getClassName().equals("Y")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "4Z": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 4 && classGroupList
                                            .get(i).getClassName().equals("Z")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "4DK": {
                                for (int i = 0; i < classGroupList.size(); i++) {
                                    if (classGroupList.get(i).getSemester() == 4 && classGroupList
                                            .get(i).getClassName().equals("Dk")) {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                        }
                    } else {
                        throw new IllegalArgumentException("Error reading line: " + line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return classGroupList;
    }

    /**
     * Method reading in a File file and turning it into a CourseList
     * @param file File object with courses
     * @return returns a Courselist
     */
    public static CourseList manualReadCourses(File file) {

        CourseList courses = new CourseList();
        TeacherList masterTeacherList = new TeacherList();
        try {
            Scanner in = new Scanner(file);
            Course course;
            int semesterTaught = 0;
            ClassGroup classGroup;
            String courseName = null;
            int ECTS = 0;
            String[] parts;

            while (in.hasNext()) {
                String line = in.nextLine();

                if (line.contains(",")) {

                    parts = line.split(",");
                    if (parts.length == 5) {
                        semesterTaught = Integer.parseInt(parts[0]);
                        classGroup = new ClassGroup(semesterTaught, parts[1]);
                        courseName = parts[2];
                        TeacherList teacherList = new TeacherList();
                        teacherList.addTeacher(new Teacher(parts[3]));
                        if (!(masterTeacherList.contains(new Teacher(parts[3])))) {
                            masterTeacherList.addTeacher(new Teacher(parts[3]));
                        }
                        ECTS = Integer.parseInt(parts[4]);

                        if (courses.size() == 0) {
                            course = new Course(courseName, classGroup, teacherList,
                                    semesterTaught, ECTS);
                            for (int j = 0; j < teacherList.size(); j++) {
                                if (!(teacherList.get(j) == null)) {
                                    teacherList.get(j).assignToCourseTaught(course);

                                }
                            }
                            courses.addCourse(course);
                        } else if (courses.size() >= 1) {
                            boolean teacherFound = false;
                            for (int i = 0; i < courses.size(); i++) {
                                if (courses.get(i).getClassGroup().equals(classGroup) && courses
                                        .get(i).getName().equals(courseName) && !(courses.get(i)
                                        .getTeachers().contains(new Teacher(parts[3])))) {
                                    courses.get(i).addTeacher(new Teacher(parts[3]));


                                    teacherFound = true;

                                }
                            }
                            if (!teacherFound) {
                                course = new Course(courseName, classGroup, teacherList,
                                        semesterTaught, ECTS);


                                for (int j = 0; j < teacherList.size(); j++) {
                                    if (!(teacherList.get(j) == null)) {
                                        teacherList.get(j).assignToCourseTaught(course);
                                    }
                                }
                                courses.addCourse(course);
                            }
                        }

                    } else {
                        throw new IllegalArgumentException("Unable to read line" + line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * Method reading in a file of courses and turns it into a TeacherList
     * @param file File with courses and teachers
     * @return Returns a TeacherList
     */
    public static TeacherList manualReadMasterTeacherList(File file) {
        CourseList courses = new CourseList();
        TeacherList masterTeacherList = new TeacherList();
        try {
            Scanner in = new Scanner(file);
            Course course;
            int semesterTaught = 0;
            ClassGroup classGroup;
            String courseName = null;
            int ECTS = 0;
            String[] parts;

            while (in.hasNext()) {
                String line = in.nextLine();

                if (line.contains(",")) {

                    parts = line.split(",");
                    if (parts.length == 5) {
                        semesterTaught = Integer.parseInt(parts[0]);
                        classGroup = new ClassGroup(semesterTaught, parts[1]);
                        courseName = parts[2];
                        TeacherList teacherList = new TeacherList();
                        teacherList.addTeacher(new Teacher(parts[3]));

                        ECTS = Integer.parseInt(parts[4]);

                        if (courses.size() == 0) {
                            course = new Course(courseName, classGroup, teacherList,
                                    semesterTaught, ECTS);
                            for (int j = 0; j < teacherList.size(); j++) {
                                if (!(teacherList.get(j) == null)) {
                                    teacherList.get(j).assignToCourseTaught(course);
                                }
                            }
                            courses.addCourse(course);
                        } else if (courses.size() >= 1) {
                            boolean teacherFound = false;
                            for (int i = 0; i < courses.size(); i++) {
                                if (courses.get(i).getClassGroup().equals(classGroup) && courses
                                        .get(i).getName().equals(courseName) && !(courses.get(i)
                                        .getTeachers().contains(new Teacher(parts[3])))) {
                                    courses.get(i).addTeacher(new Teacher(parts[3]));
                                    teacherFound = true;
                                }
                            }
                            if (!teacherFound) {
                                course = new Course(courseName, classGroup, teacherList,
                                        semesterTaught, ECTS);
                                for (int j = 0; j < teacherList.size(); j++) {
                                    if (!(teacherList.get(j) == null)) {
                                        teacherList.get(j).assignToCourseTaught(course);
                                    }
                                }
                                courses.addCourse(course);
                            }
                        }

                    } else {
                        throw new IllegalArgumentException("Unable to read line" + line);
                    }
                }
            }

            for (int i = 0; i < courses.size(); i++) {
                for (int j = 0; j < courses.get(i).getTeachers().size(); j++) {
                    if (!(masterTeacherList
                            .contains(courses.get(i).getTeachers().get(j)))) {
                        masterTeacherList.addTeacher(courses.get(i).getTeachers().get(j));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return masterTeacherList;
    }

    /**
     * Method reading in a File file and creating a RoomList
     * @param file File containing rooms
     * @return Returns a RoomList
     */
    public static RoomList manualReadRooms(File file) {

        RoomList rooms = new RoomList();

        try {
            Scanner in = new Scanner(file);

            String[] parts;
            String[] roomParts;

            while (in.hasNext()) {
                String line = in.nextLine();

                if (line.contains(",")) {
                    parts = line.split(",");

                    for (int i = 0; i < parts.length - 1; i++) {
                        int floor;
                        String floorString = "";
                        char block;
                        int number;
                        String numberString = "";
                        int capacity;
                        char roomLetter;
                        Room room;
                        if (parts[i].contains(".")) {
                            roomParts = parts[i].split("[.]");
                            block = parts[0].charAt(0);
                            capacity = Integer.parseInt(parts[1]);
                            if (parts[0].charAt(1) == '0') {
                                floorString += parts[0].charAt(1);

                                floorString += parts[0].charAt(2);
                                floor = Integer.parseInt(floorString);
                            } else {
                                floorString += parts[0].charAt(1);
                                floorString += parts[0].charAt(2);

                                floor = Integer.parseInt(floorString);
                            }
                            if (roomParts[1].length() == 2) {
                                number = Integer.parseInt(roomParts[1]);
                                numberString += roomParts[1];
                                capacity = Integer.parseInt(parts[1]);
                                room = new Room(floor, block, number, capacity);
                                rooms.addRoom(room);
                            } else if (roomParts[1].length() == 3) {
                                numberString += roomParts[1].charAt(0);
                                numberString += roomParts[1].charAt(1);
                                number = Integer.parseInt(numberString);
                                roomLetter = roomParts[1].charAt(2);
                                numberString += roomLetter;
                                capacity = Integer.parseInt(parts[1]);
                                room = new FoldableRoom(floor, block, number, capacity,
                                        roomLetter);
                                if (!(rooms.contains(room))) {
                                    rooms.addRoom(room);
                                } else {
                                    System.out.println("Room already exists, failed to add");
                                }
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}

