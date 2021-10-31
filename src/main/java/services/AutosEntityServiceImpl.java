package services;

import dao.AutosEntityDAO;
import models.AutosEntity;

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
    public List<AutosEntity> findAutoByUserID(int userId) {
        return autosEntityDAO.findAutoByUserID(userId);
    }

    @Override
    public List<AutosEntity> findAllAuto() {
        return autosEntityDAO.findAllAuto();
    }
}
