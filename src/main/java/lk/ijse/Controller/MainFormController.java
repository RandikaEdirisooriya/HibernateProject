package lk.ijse.Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.StudentBO;
import lk.ijse.DTO.StudentDto;
import lk.ijse.Entity.Student;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MainFormController {
    public TextField FirstnameTextFeild;
    public TextField LastnameTextFeild;
    public TextField EmailTextFeild;
    public TextField ContactNumberTextFeild;
    public Button SaveBtn;
    public TextField StudentIdTextFeild;
    public TableView<StudentDto> tbl_student;
    public TableColumn id;
    public TableColumn firstname;
    public TableColumn lastname;
    public TableColumn email;
    public TableColumn contact;


    StudentBO studentBO= (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    public void initialize() {

        id.setCellValueFactory(new PropertyValueFactory<>("Student_ID"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        contact.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
        loadAllStudent();
    }
        public void SaveBtnOnaction(ActionEvent actionEvent) {
            String firstName = FirstnameTextFeild.getText();
            String StudentID = StudentIdTextFeild.getText();
            String lastName = LastnameTextFeild.getText();
            String Email = EmailTextFeild.getText();
            int ContactNumber = Integer.parseInt(ContactNumberTextFeild.getText());
            try {
                studentBO.addStudent(new StudentDto(StudentID, firstName, lastName, Email, ContactNumber));
                loadAllStudent();
                new Alert(Alert.AlertType.CONFIRMATION, "Student Added Successful !", ButtonType.OK).show();
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Student Added Not Successful!", ButtonType.OK).show();
            }
        }

    private void loadAllStudent() {
        tbl_student.getItems().clear();
        ObservableList<StudentDto> items= (ObservableList<StudentDto>) tbl_student.getItems();
        try {
            /*Get all customers*/
            List<StudentDto> allstudent = studentBO.getAllStudent();
            System.out.println(allstudent);

            for (StudentDto c : allstudent) {
                items.add(new StudentDto(c.getStudent_ID(), c.getFirstName(), c.getLastName(),c.getEmail(),c.getContactNumber()));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void DeleteButtonOnAction(ActionEvent actionEvent) {
        String student_id = StudentIdTextFeild.getText();


        try {
            studentBO.deleteStudent(student_id);
loadAllStudent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updatebuttonOnAction(ActionEvent actionEvent) {
        String student_id = StudentIdTextFeild.getText();
        String firstName = FirstnameTextFeild.getText();
        String lastName = LastnameTextFeild.getText();
        String email = EmailTextFeild.getText();
        int contactNumber = Integer.parseInt(ContactNumberTextFeild.getText());

        try {
            studentBO.updateStudent(new StudentDto(student_id, firstName, lastName, email, contactNumber));
            loadAllStudent();
            new Alert(Alert.AlertType.CONFIRMATION,"Student Added Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Student Added Not Successful!", ButtonType.OK).show();
        }

    }


    public void ClearButtonOnAction(ActionEvent actionEvent) {
        FirstnameTextFeild.clear();
        LastnameTextFeild.clear();
        EmailTextFeild.clear();
        ContactNumberTextFeild.clear();
    }

}
