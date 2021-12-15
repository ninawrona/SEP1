package model.list;

import model.basic.Course;
import model.basic.Teacher;

import java.util.ArrayList;

/**
 * A class representing a list of teachers.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class TeacherList {
    private ArrayList<Teacher> teachers;

    /**
     * Zero-argument constructor. The previously declared ArrayList "teachers" of type Teacher is initialized.
     */
    public TeacherList() {
        teachers = new ArrayList<>();
    }

    /**
     * A method returning the number of elements the ArrayList contains.
     *
     * @return an int representing the number of Teacher objects on the list.
     */
    public int size() {
        return teachers.size();
    }

    /**
     * A getter method returning a teacher from the list.
     *
     * @param index the desired index to get the teacher from.
     * @return a Teacher object from the specified index.
     */
    public Teacher get(int index) {
        return teachers.get(index);
    }

    /**
     * A void method for adding a teacher to the list.
     *
     * @param teacher the Teacher object to be added to the list (cannot be null).
     */
    public void addTeacher(Teacher teacher) {
        if (teacher == null) {
            throw new IllegalArgumentException("Teacher can not be null");
        }
        teachers.add(teacher);
    }

    /**
     * A void method for removing a teacher from the list.
     *
     * @param teacher the Teacher object to be removed from the list (cannot be null). There must be at least 1 Teacher object in a list in order to use the method.
     */
    public void removeTeacher(Teacher teacher) {
        if (size() == 0) {
            throw new NullPointerException(
                    "The list is empty! You cannot remove anything!");
        }
        if (teacher == null) {
            throw new IllegalArgumentException("You must select a teacher to remove");
        }
        teachers.remove(teacher);
    }

    /**
     * A method checking if the list contains the specified teacher.
     *
     * @param teacher the Teacher object to search by (cannot be null).
     * @return "True" if the list contains the specified Teacher object, or "False" if it does not.
     */
    public boolean contains(Teacher teacher) {
        if (teacher == null) {
            throw new NullPointerException("Parameter cannot be null!");
        }
        if (teachers.contains(teacher)) {
            return true;
        }
        return false;
    }

    /**
     * A method returning a String representation of the ArrayList "teachers".
     *
     * @return a String containing all the teachers and their information.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i) == null) {
                str += "";
            } else {
                str += i + 1 + ". " + teachers.get(i).toString();
            }

        }
        return str;
    }

    /**
     * A method comparing two TeacherList objects.
     *
     * @param obj an object representing the other object to be compared.
     * @return "True" if the two TeacherList objects are identical, or "False" if they are not.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof TeacherList)) {
            return false;
        }

        TeacherList other = (TeacherList) obj;

        boolean equals = true;

        for (int i = 0; i < teachers.size(); i++) {
            if (!(teachers.get(i).equals(other.get(i)))) {
                equals = false;
            }
        }
        return equals;
    }
}
