package models.services.lecture;

import models.view_models.lecture.LectureCreateRequest;
import models.view_models.lecture.LectureUpdateRequest;
import models.view_models.lecture.LectureViewModel;

import java.util.ArrayList;

public class LectureService implements ILectureService{
    @Override
    public boolean insert(LectureCreateRequest request) {
        return false;
    }

    @Override
    public boolean update(LectureUpdateRequest request) {
        return false;
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return false;
    }

    @Override
    public LectureViewModel retrieveById(String hashKey, String rangeKey) {
        return null;
    }

    @Override
    public ArrayList<LectureViewModel> retrieveAll() {
        return null;
    }

    @Override
    public boolean containLectureBelongFaculty(String facultyId) {
        return false;
    }
}
