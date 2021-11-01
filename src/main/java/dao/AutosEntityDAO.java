package dao;

import models.AutosEntity;
import models.UsersEntity;

import java.util.List;

public interface AutosEntityDAO
{
    AutosEntity findAutoById (int id);
    List<AutosEntity> findAutoByUserEntity(UsersEntity usersEntity);
    List<AutosEntity> findAllAuto ();
}