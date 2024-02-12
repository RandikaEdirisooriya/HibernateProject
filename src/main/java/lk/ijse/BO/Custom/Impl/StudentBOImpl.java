package lk.ijse.BO.Custom.Impl;

import lk.ijse.BO.Custom.StudentBO;
import lk.ijse.DAO.Custom.StudentDao;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DTO.StudentDto;
import lk.ijse.Entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDao studentDao = (StudentDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public List<StudentDto> getAllStudent() throws Exception {
        List<StudentDto> allStudent= new ArrayList<>();
        List<Student> all = studentDao.getAll();
        for (Student c : all) {
            allStudent.add(new StudentDto(c.getStudent_ID(), c.getFirstName(), c.getLastName(),c.getEmail(), c.getContactNumber()));
        }
        return allStudent;
    }

    @Override
    public boolean addStudent(StudentDto dto) throws Exception {
        return studentDao.save(new Student(dto.getStudent_ID(), dto.getFirstName(), dto.getLastName(),dto.getEmail(), dto.getContactNumber()));

    }

    @Override
    public boolean updateStudent(StudentDto dto) throws Exception {
        return studentDao.update(new Student(dto.getStudent_ID(), dto.getFirstName(), dto.getLastName(),dto.getEmail(), dto.getContactNumber()));

    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDao.delete(id);
    }
}
