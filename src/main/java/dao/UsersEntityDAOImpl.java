package dao;

import models.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UsersEntityDAOImpl implements UsersEntityDAO
{
    @Override
    public UsersEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UsersEntity.class, id);
    }

    @Override
    public void save(UsersEntity usersEntity)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(usersEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(UsersEntity usersEntity)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(usersEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(UsersEntity usersEntity)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(usersEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public List<UsersEntity> findAll()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<UsersEntity> list = session.createQuery("From UsersEntity").list();
        session.close();
        return list;
    }

    public void dropUsersEntity()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete UsersEntity").executeUpdate();
        transaction.commit();
        session.close();
    }
}
