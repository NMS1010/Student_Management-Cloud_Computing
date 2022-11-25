package models.services.grade;

import models.view_models.grade.GradeCreateRequest;
import models.view_models.grade.GradeUpdateRequest;
import models.view_models.grade.GradeViewModel;

import java.util.ArrayList;

public class GradeService implements IGradeService{
    @Override
    public boolean insert(GradeCreateRequest request) {
        return false;
    }

    @Override
    public boolean update(GradeUpdateRequest request) {
        return false;
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return false;
    }

    @Override
    public GradeViewModel retrieveById(String hashKey, String rangeKey) {
        return null;
    }

    @Override
    public ArrayList<GradeViewModel> retrieveAll() {
        return null;
    }

    @Override
    public boolean containStudent(String studentId) {
        return false;
    }

    @Override
    public boolean containSubjectGroup(String subjectGroupId) {
        return false;
    }

    @Override
    public ArrayList<GradeViewModel> retrieveGradeByLectureId(String lectureId) {
        return null;
    }
}
