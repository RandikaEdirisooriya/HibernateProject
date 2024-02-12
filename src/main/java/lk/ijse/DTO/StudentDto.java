package lk.ijse.DTO;

public class StudentDto {
    String Student_ID;
    String FirstName;
    String LastName;

    String Email;
    int ContactNumber;

    public StudentDto() {
    }

    public StudentDto(String student_ID, String firstName, String lastName, String email, int contactNumber) {
        Student_ID = student_ID;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        ContactNumber = contactNumber;
    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(int contactNumber) {
        ContactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Student_ID='" + Student_ID + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", ContactNumber=" + ContactNumber +
                '}';
    }
}
