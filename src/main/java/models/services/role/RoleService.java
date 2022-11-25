package models.services.role;

import models.view_models.role.RoleCreateRequest;
import models.view_models.role.RoleUpdateRequest;
import models.view_models.role.RoleViewModel;

import java.util.ArrayList;

public class RoleService implements IRoleService{
    @Override
    public boolean insert(RoleCreateRequest request) {
        return false;
    }

    @Override
    public boolean update(RoleUpdateRequest request) {
        return false;
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return false;
    }

    @Override
    public RoleViewModel retrieveById(String hashKey, String rangeKey) {
        return null;
    }

    @Override
    public ArrayList<RoleViewModel> retrieveAll() {
        return null;
    }
}
