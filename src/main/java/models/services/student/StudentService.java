package models.services.student;

import models.view_models.student.StudentClassCreateRequest;
import models.view_models.student.StudentClassUpdateRequest;
import models.view_models.student.StudentViewModel;

import java.util.ArrayList;

public class StudentService implements IStudentService {
    private static StudentService instance = null;
    public static StudentService getInstance() {
        if(instance == null)
            instance = new StudentService();
        return instance;
    }
    @Override
    public boolean insert(StudentClassCreateRequest request) {
        return false;
    }

    @Override
    public boolean update(StudentClassUpdateRequest request) {
        return false;
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return false;
    }

    @Override
    public StudentViewModel retrieveById(String hashKey, String rangeKey) {
        return null;
    }

    @Override
    public ArrayList<StudentViewModel> retrieveAll() {
        return null;
    }

    @Override
    public boolean containStudentClass(String studentClassId) {
        return false;
    }
}
