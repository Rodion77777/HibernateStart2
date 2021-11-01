package services;

import dao.UserEntityDAOImpl;
import models.UserEntity;

import java.util.List;

public class UserEntityServiceImpl implements UserEntityService {

    private UserEntityDAOImpl usersEntityDAO;

    public UserEntityServiceImpl(UserEntityDAOImpl usersEntityDAO) {
        this.usersEntityDAO = usersEntityDAO;
    }

    @Override
    public UserEntity findUser (int id) {
        return usersEntityDAO.findById(id);
    }

    @Override
    public void saveUser (UserEntity userEntity) {
        usersEntityDAO.save(userEntity);
    }

    @Override
    public void deleteUser (UserEntity userEntity) {
        usersEntityDAO.delete(userEntity);
    }

    @Override
    public void updateUser (UserEntity userEntity) {
        usersEntityDAO.update(userEntity);
    }

    @Override
    public List<UserEntity> findAllUsers () {
        return usersEntityDAO.findAll();
    }

    public void dropUsersEntity() {
        usersEntityDAO.dropUsersEntity();
    }
}
