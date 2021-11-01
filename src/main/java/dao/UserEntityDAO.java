package dao;

import models.UserEntity;

import java.util.List;

public interface UserEntityDAO
{
    UserEntity findById (int id);
    void save (UserEntity userEntity);
    void update (UserEntity userEntity);
    void delete (UserEntity userEntity);
    List<UserEntity> findAll ();
}
