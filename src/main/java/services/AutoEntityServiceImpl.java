package services;

import dao.AutoEntityDAO;
import models.AutoEntity;
import models.UserEntity;

import java.util.List;

public class AutoEntityServiceImpl implements AutoEntityService
{
    AutoEntityDAO autoEntityDAO;

    public AutoEntityServiceImpl(AutoEntityDAO autoEntityDAO) {
        this.autoEntityDAO = autoEntityDAO;
    }

    @Override
    public AutoEntity findAutoById(int id) {
        return autoEntityDAO.findAutoById(id);
    }

    @Override
    public List<AutoEntity> findAutoByUserEntity(UserEntity userEntity) {
        return autoEntityDAO.findAutoByUserEntity(userEntity);
    }

    @Override
    public List<AutoEntity> findAllAuto() {
        return autoEntityDAO.findAllAuto();
    }
}
