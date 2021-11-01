package dao;

import models.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserEntityDAOImpl implements UserEntityDAO
{
    @Override
    public UserEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UserEntity.class, id);
    }

    @Override
    public void save(UserEntity userEntity)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(UserEntity userEntity)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(userEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(UserEntity userEntity)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public List<UserEntity> findAll()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<UserEntity> list = session.createQuery("From UserEntity").list();
        session.close();
        return list;
    }

    public void dropUsersEntity()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete UserEntity").executeUpdate();
        transaction.commit();
        session.close();
    }
}
