package services;

import models.AutosEntity;
import models.UsersEntity;

import java.util.List;

public interface UserEntityService
{
    UsersEntity findUser (int id);
    void saveUser (UsersEntity usersEntity);
    void deleteUser (UsersEntity usersEntity);
    void updateUser (UsersEntity usersEntity);
    List<UsersEntity> findAllUsers ();
    AutosEntity findAutoById (int id);
}
