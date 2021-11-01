package services;

import models.AutosEntity;
import models.UsersEntity;

import java.util.List;

public interface AutosEntityService
{
    AutosEntity findAutoById (int id);
    List<AutosEntity> findAutoByUserEntity(UsersEntity usersEntity);
    List<AutosEntity> findAllAuto ();
}
