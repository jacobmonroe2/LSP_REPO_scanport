package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report for a course, showing course name and enrollment.
 */
public class CourseReport extends Report {

    private String courseName;
    private int enrollment;

    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    @Override
    protected void formatHeader() {
        System.out.println("=== HEADER ===");
        System.out.println("Course Report");
        System.out.println();
    }

    @Override
    protected void formatBody() {
        System.out.println("=== BODY ===");
        System.out.println("Course: " + courseName);
        System.out.println("Enrollment: " + enrollment);
        System.out.println();
    }

    @Override
    protected void formatFooter() {
        System.out.println("=== FOOTER ===");
        System.out.println("End of Course Report");
        System.out.println();
    }
}
