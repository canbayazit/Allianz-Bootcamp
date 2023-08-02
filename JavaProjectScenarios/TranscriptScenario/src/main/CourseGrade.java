package main;

import util.Grade;

import java.util.Set;

public class CourseGrade {
    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private Grade gradeTaken;

    // ödevde aldığı parametrelere göre 4 tane overloaded constructor girmemiz istendi.
    public CourseGrade(String courseDepartment) {
        setCourseDepartment(courseDepartment);
        this.courseCode=100;
        this.courseCredit=4;
        this.gradeTaken=Grade.F;
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        this.courseCredit=4;
        this.gradeTaken=Grade.F;
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        this.gradeTaken=Grade.F;
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    // "COMP","CENG","ECE","ME","MATH" sadece bu değerleri alabilir
    public void setCourseDepartment(String courseDepartment) {
        if (Set.of("COMP","CENG","ECE","ME","MATH").contains(courseDepartment.toUpperCase())) {
            this.courseDepartment = courseDepartment.toUpperCase();
        } else {
            this.courseDepartment = "CENG"; // Default value
        }
    }

    public int getCourseCode() {
        return courseCode;
    }

    // sadece 100 ile 599 arasında olabilir.
    public void setCourseCode(int courseCode) {
        if (courseCode >= 100 && courseCode <= 599) {
            this.courseCode = courseCode;
        } else {
            this.courseCode = 100; // Default value
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    // sadece 3 yada 4 değerini alabilir
    public void setCourseCredit(int courseCredit) {
        if (courseCredit == 3 || courseCredit == 4) {
            this.courseCredit = courseCredit;
        } else {
            this.courseCredit = 4; // Default value
        }
    }

    // setGradeTaken methodları overloading yapıldı.
    public void setGradeTaken(double val) {
        if (val >= 0.0 && val <= 4.0) {
            int roundedValue = (int) Math.round(val);
            this.gradeTaken = Grade.values()[roundedValue];
        } else {
            this.gradeTaken = Grade.F; // Default value
        }
    }

    public void setGradeTaken(Grade g) {
            this.gradeTaken = g;

    }
    @Override
    public String toString() {
        return "Department: " + courseDepartment +
                " CourseCode: " + courseCode +
                " Credit: " + courseCredit +
                " Grade: " + gradeTaken.getStringValue();
    }

}
