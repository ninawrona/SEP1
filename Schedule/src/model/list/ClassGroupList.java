package model.list;

import model.basic.ClassGroup;
import model.basic.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class representing a collection of classes
 */
public class ClassGroupList {
    private ArrayList<ClassGroup> classes;

    public ClassGroupList() {
        classes = new ArrayList<>();

        // debugging by making simple course
        ClassGroup x1 = new ClassGroup(1, "X");

        classes.add(x1);
        x1.addCourse(new Course("RWD"));
        //classes.add((new ClassGroup(1,"X")).copy());
        classes.add((new ClassGroup(1, "Y")));
        classes.add((new ClassGroup(1, "Z")));
        classes.add((new ClassGroup(1, "DK")));

        classes.add((new ClassGroup(2, "X")));
        classes.add((new ClassGroup(2, "Y")));
        classes.add((new ClassGroup(2, "Z")));
        classes.add((new ClassGroup(2, "DK")));

        classes.add((new ClassGroup(3, "X")));
        classes.add((new ClassGroup(3, "Y")));
        classes.add((new ClassGroup(3, "Z")));
        classes.add((new ClassGroup(3, "DK")));

        classes.add((new ClassGroup(4, "X")).copy());
        classes.add((new ClassGroup(4, "Y")).copy());
        classes.add((new ClassGroup(4, "Z")).copy());
        classes.add((new ClassGroup(4, "DK")).copy());


    }

    public int size() {
        return classes.size();
    }

    public void addClass(ClassGroup classGroup) {
        classes.add(classGroup);
    }

    public void removeClass(ClassGroup classGroup) {
        if (size() == 0) {
            throw new NullPointerException(
                    "The list is empty! You cannot remove anything!");
        }
        if (classes == null) {
            throw new IllegalArgumentException("Parameter cannot be null!");
        }
        classes.remove(classGroup);
    }

    public ClassGroup get(int index) {
        return classes.get(index);
    }

    public static ClassGroupList manualReadStudents(File file)
    {

        ClassGroupList classGroupList = new ClassGroupList();

        try
        {
            Scanner in = new Scanner(file);
            Student student;
            int semester = 0;
            String classGroup = "";
            String name = null;
            int viaId = 0;
            String[] parts;

            while (in.hasNext())
            {
                String line = in.nextLine();
                if (line.contains(","))
                {
                    //divides the line by commas
                    parts = line.split(",");
                    if (parts.length == 4)
                    {
                        semester = Integer.parseInt(parts[0]);
                        classGroup = parts[1].toUpperCase();
                        viaId = Integer.parseInt(parts[2]);
                        name = parts[3];

                        student = new Student(semester, name, viaId);

                        String classGroupString = "";
                        classGroupString += semester;

                        classGroupString += classGroup;
                        switch (classGroupString)
                        {
                            case "1X":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 1
                                        && classGroupList.get(i).getClassName().equals("X"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "1Y":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 1
                                        && classGroupList.get(i).getClassName().equals("Y"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "1Z":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 1
                                        && classGroupList.get(i).getClassName().equals("Z"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "1DK":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 1
                                        && classGroupList.get(i).getClassName().equals("DK"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "2X":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 2
                                        && classGroupList.get(i).getClassName().equals("X"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "2Y":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 2
                                        && classGroupList.get(i).getClassName().equals("Y"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "2Z":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 2
                                        && classGroupList.get(i).getClassName().equals("Z"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "2DK":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 2
                                        && classGroupList.get(i).getClassName().equals("DK"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "3X":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 3
                                        && classGroupList.get(i).getClassName().equals("X"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "3Y":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 3
                                        && classGroupList.get(i).getClassName().equals("Y"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "3Z":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 3
                                        && classGroupList.get(i).getClassName().equals("Z"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "3DK":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 3
                                        && classGroupList.get(i).getClassName().equals("DK"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "4X":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 4
                                        && classGroupList.get(i).getClassName().equals("X"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "4Y":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 4
                                        && classGroupList.get(i).getClassName().equals("Y"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "4Z":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 4
                                        && classGroupList.get(i).getClassName().equals("Z"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                            case "4DK":
                            {
                                for (int i = 0; i < classGroupList.size(); i++)
                                {
                                    if (classGroupList.get(i).getSemester() == 4
                                        && classGroupList.get(i).getClassName().equals("Dk"))
                                    {
                                        classGroupList.get(i).addStudent(student);
                                        break;
                                    }
                                }
                                break;
                            }

                        }
                    }
                    else
                    {
                        throw new IllegalArgumentException("Error reading line: " + line);
                    }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return classGroupList;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getStudents().size() == 0) {
                str += "";
            } else {
                str += classes.get(i).toString();
            }
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ClassGroupList)) {
            return false;
        }

        ClassGroupList other = (ClassGroupList) obj;

        if (classes.size() == other.size()) {
            for (int i = 0; i < classes.size(); i++) {
                if (!(classes.get(i).equals(other.get(i)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
