package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.DTO.StudentDto;

import java.util.List;

public interface StudentBO extends SuperBO {
    public List<StudentDto> getAllStudent()  throws Exception ;
    public boolean addStudent(StudentDto dto) throws Exception ;

    public boolean updateStudent(StudentDto dto)  throws Exception  ;

    public boolean deleteStudent(String id) throws Exception ;

}


