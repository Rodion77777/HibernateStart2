package services;

import models.AutosEntity;

import java.util.List;

public interface AutosEntityService
{
    AutosEntity findAutoById (int id);
    List<AutosEntity> findAutoByUserID (int userId);
    List<AutosEntity> findAllAuto ();
}
