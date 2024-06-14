import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationSystem {
    private List<Course> courses;
    private List<Student> students;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }
    public void listStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student findStudentById(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();
        Scanner scanner = new Scanner(System.in);

        // Adding some sample courses
        system.addCourse(new Course("CS101", "The Complete Web Developer Course", "Learn Web Development", 100, "MWF 10-11AM"));
        system.addCourse(new Course("CS102", "Data Structures And Algorithms", "Learn, Analyze and Implement Data Structure", 80, "TTh 3-4PM"));
        system.addCourse(new Course("CS103", "Learn JAVA Programming", "Deep Dive in Core Java programming", 100, "WFS 5-6PM"));
        
        // Adding some sample students
        system.addStudent(new Student("S001", "Alice"));
        system.addStudent(new Student("S002", "Bob"));
        system.addStudent(new Student("S003", "John"));
        system.addStudent(new Student("S004", "Devin"));

        while (true) {
            System.out.println("1. List courses");
            System.out.println("2. List students");
            System.out.println("3. Register for a course");
            System.out.println("4. Drop a course");
            System.out.println("5. List registered courses");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
          

            switch (choice) {
                case 1:
                    system.listCourses();
                    break;
                case 2:
                    system.listStudents();
                    break;
                case 3:
                    System.out.println("Enter student ID: ");
                    String studentID = scanner.next();
                    Student student = system.findStudentById(studentID);
                    if (student == null) {
                        System.out.println("Student is not found");
                        break;
                    }
                    System.out.println("Enter course code: ");
                    String courseCode = scanner.next();
                    Course course = system.findCourseByCode(courseCode);
                    if (course == null) {
                        System.out.println("Course is not found");
                        break;
                    }
                    if (student.registerCourse(course)) {
                        System.out.println("Successfully registered");
                    } else {
                        System.out.println("Course is full or already registered");
                    }
                    break;
                case 4:
                    System.out.println("Enter student ID: ");
                    studentID = scanner.next();
                    student = system.findStudentById(studentID);
                    if (student == null) {
                        System.out.println("Student is not found");
                        break;
                    }
                    System.out.println("Enter course code: ");
                    courseCode = scanner.next();
                    course = system.findCourseByCode(courseCode);
                    if (course == null) {
                        System.out.println("Course is not found");
                        break;
                    }
                    if (student.dropCourse(course)) {
                        System.out.println("Successfully dropped");
                    } else {
                        System.out.println("You are not registered for this course.");
                    }
                    break;
                case 5:
                    System.out.println("Enter student ID: ");
                    studentID = scanner.next();
                    student = system.findStudentById(studentID);
                    if (student == null) {
                        System.out.println("Student is not found");
                        break;
                    }
                    System.out.println("Registered courses for student " + student.getName() + ":");
                    student.listRegisteredCourses();
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
