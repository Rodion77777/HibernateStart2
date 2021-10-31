package dao;

import models.AutosEntity;

import java.util.List;

public interface AutosEntityDAO
{
    AutosEntity findAutoById (int id);
    List<AutosEntity> findAutoByUserID (int userId);
    List<AutosEntity> findAllAuto ();
}