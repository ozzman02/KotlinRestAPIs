package com.kotlin.playground;


import playground.classes.Authenticate;
import playground.classes.Course;
import playground.classes.CourseCategory;
import playground.classes.CourseUtils;


public class InvokeKotlinFromJava {

    public static void main(String[] args) {

        var course = new Course(
                1, "Reactive Programming in Modern Java using Project Reactor", "Dilip", CourseCategory.DEVELOPMENT);

        var course2 = new Course(
                1, "Test", "Test");

        System.out.println("Course: " + course);
        System.out.println("Course: " + course2);


        CourseUtils.printName1();
        CourseUtils.printName1("abc");
        Course.Companion.printName2("ABC");
        Course.printName2("test");

        System.out.println("NoOfCourses: " + course.noOfCourses);

        Authenticate.INSTANCE.authenticate("Admin", "password");
        Authenticate.authenticate("Dilip", "abc");
    }
}
