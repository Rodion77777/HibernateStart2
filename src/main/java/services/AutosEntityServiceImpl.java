package services;

import dao.AutosEntityDAO;
import models.AutosEntity;
import models.UsersEntity;

import java.util.List;

public class AutosEntityServiceImpl implements AutosEntityService
{
    AutosEntityDAO autosEntityDAO;

    public AutosEntityServiceImpl (AutosEntityDAO autosEntityDAO) {
        this.autosEntityDAO = autosEntityDAO;
    }

    @Override
    public AutosEntity findAutoById(int id) {
        return autosEntityDAO.findAutoById(id);
    }

    @Override
    public List<AutosEntity> findAutoByUserEntity(UsersEntity usersEntity) {
        return autosEntityDAO.findAutoByUserEntity(usersEntity);
    }

    @Override
    public List<AutosEntity> findAllAuto() {
        return autosEntityDAO.findAllAuto();
    }
}
