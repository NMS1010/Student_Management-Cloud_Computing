package models.services.faculty;

import models.view_models.faculty.FacultyCreateRequest;
import models.view_models.faculty.FacultyUpdateRequest;
import models.view_models.faculty.FacultyViewModel;

import java.util.ArrayList;

public class FacultyService implements IFacultyService{
    @Override
    public boolean insert(FacultyCreateRequest request) {
        return false;
    }

    @Override
    public boolean update(FacultyUpdateRequest request) {
        return false;
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return false;
    }

    @Override
    public FacultyViewModel retrieveById(String hashKey, String rangeKey) {
        return null;
    }

    @Override
    public ArrayList<FacultyViewModel> retrieveAll() {
        return null;
    }
}
