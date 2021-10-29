package services;

import dao.UsersEntityDAOImpl;
import models.AutosEntity;
import models.UsersEntity;

import java.util.List;

public class UserEntityServiceImpl implements UserEntityService {

    private UsersEntityDAOImpl usersEntityDAO;

    public UserEntityServiceImpl(UsersEntityDAOImpl usersEntityDAO)
    {
        this.usersEntityDAO = usersEntityDAO;
    }

    @Override
    public UsersEntity findUser (int id)
    {
        return usersEntityDAO.findById(id);
    }

    @Override
    public void saveUser (UsersEntity usersEntity)
    {
        usersEntityDAO.save(usersEntity);
    }

    @Override
    public void deleteUser (UsersEntity usersEntity)
    {
        usersEntityDAO.delete(usersEntity);
    }

    @Override
    public void updateUser (UsersEntity usersEntity)
    {
        usersEntityDAO.update(usersEntity);
    }

    @Override
    public List<UsersEntity> findAllUsers ()
    {
        return usersEntityDAO.findAll();
    }

    @Override
    public AutosEntity findAutoById (int id)
    {
        return usersEntityDAO.findAutoById(id);
    }
}
