package project1;

abstract class user {
    String username;
    int userID;

    public user(String username, int userID) {
        this.username = username;
        this.userID = userID;
    }

    public String toString() {
        return "User name: " + username + ", User ID: " + userID;
    }
}

class Student extends user {
    String course;

    public Student(String username, int userID, String course) {
        super(username, userID);
        this.course = course;
    }

    public String toString() {
        return super.toString() + ", Course: " + course;
    }
}

class Faculty extends user {
    String subject;

    public Faculty(String username, int userID, String subject) {
        super(username, userID);
        this.subject = subject;
    }

    public String toString() {
        return super.toString() + ", Subject Specialization: " + subject;
    }
}
