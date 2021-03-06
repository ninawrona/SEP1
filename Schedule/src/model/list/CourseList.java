package model.list;

import model.basic.Course;
import model.basic.Teacher;

import java.util.ArrayList;

/**
 * A class representing a list of courses.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class CourseList {
    private ArrayList<Course> courses;

    /**
     * Zero-argument constructor. The previously declared ArrayList "courses" of type course is initialized.
     */
    public CourseList() {
        courses = new ArrayList<>();
    }

    /**
     * A method returning the number of elements the ArrayList contains.
     *
     * @return an int representing the number of Room objects on the list.
     */
    public int size() {
        return courses.size();
    }

    /**
     * A getter method returning a room from the list.
     *
     * @param index the desired index to get the room from.
     * @return a Room object from the specified index.
     */
    public Course get(int index) {
        return courses.get(index);
    }

    /**
     * A void method for adding a course to the list of courses.
     *
     * @param course the Course object to be added to the list (cannot be null).
     */
    public void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Parameter cannot be null!");
        }
        courses.add(course);
    }

    /**
     * A void method for removing a course from the list.
     *
     * @param course the Course object to be removed from the list (cannot be null). There must be at least 1 Teacher object in a list in order to use the method.
     */
    public void removeCourse(Course course) {
        if (size() == 0) {
            throw new NullPointerException(
                    "The list is empty! You cannot remove anything!");
        }
        if (course == null) {
            throw new IllegalArgumentException("Parameter cannot be null!");
        }
        courses.remove(course);
    }

    /**
     * A method returning a String representation of the ArrayList "Courses".
     *
     * @return a String containing all the rooms and their information.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < courses.size(); i++) {
            str += courses.get(i).toString() + "\n";
        }
        return str;
    }

    /**
     * A method comparing two RoomList objects.
     *
     * @param obj an object representing the other object to be compared.
     * @return "True" if the two RoomList objects are identical, or "False" if they are not.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof CourseList)) {
            return false;
        }

        CourseList other = (CourseList) obj;

        if (courses.size() == other.size()) {
            for (int i = 0; i < courses.size(); i++) {
                if (!(courses.get(i).equals(other.courses.get(i)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
