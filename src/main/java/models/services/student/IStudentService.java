package models.services.student;

import models.view_models.student.StudentClassCreateRequest;
import models.view_models.student.StudentClassUpdateRequest;
import models.view_models.student.StudentViewModel;

import java.util.ArrayList;

public interface IStudentService {
    boolean insert(StudentClassCreateRequest request);
    boolean update(StudentClassUpdateRequest request);
    boolean delete(String hashKey, String rangeKey);
    StudentViewModel retrieveById(String hashKey, String rangeKey);
    ArrayList<StudentViewModel> retrieveAll();
    boolean containStudentClass(String studentClassId);
}
