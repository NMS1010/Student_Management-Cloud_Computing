package models.repositories.student;

import common.interfaces.IModifyEntity;
import common.interfaces.IRetrieveEntity;
import models.view_models.student.StudentClassCreateRequest;
import models.view_models.student.StudentClassUpdateRequest;
import models.view_models.student.StudentViewModel;

public interface IStudentRepository extends IModifyEntity<StudentClassCreateRequest, StudentClassUpdateRequest, String, String>,
        IRetrieveEntity<StudentViewModel, String, String> {
    boolean containStudentClass(String studentClassId);
}
