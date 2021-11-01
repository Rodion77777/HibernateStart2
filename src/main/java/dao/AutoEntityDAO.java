package dao;

import models.AutoEntity;
import models.UserEntity;

import java.util.List;

public interface AutoEntityDAO
{
    AutoEntity findAutoById (int id);
    List<AutoEntity> findAutoByUserEntity(UserEntity userEntity);
    List<AutoEntity> findAllAuto ();
}