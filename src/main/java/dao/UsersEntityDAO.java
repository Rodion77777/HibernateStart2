package dao;

import models.UsersEntity;

import java.util.List;

public interface UsersEntityDAO
{
    UsersEntity findById (int id);
    void save (UsersEntity usersEntity);
    void update (UsersEntity usersEntity);
    void delete (UsersEntity usersEntity);
    List<UsersEntity> findAll ();
}
