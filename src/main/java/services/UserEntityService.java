package services;

import models.UserEntity;

import java.util.List;

public interface UserEntityService
{
    UserEntity findUser (int id);
    void saveUser (UserEntity userEntity);
    void deleteUser (UserEntity userEntity);
    void updateUser (UserEntity userEntity);
    List<UserEntity> findAllUsers ();
}
