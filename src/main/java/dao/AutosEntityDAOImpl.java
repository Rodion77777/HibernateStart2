package dao;

import models.AutosEntity;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class AutosEntityDAOImpl implements AutosEntityDAO
{
    @Override
    public AutosEntity findAutoById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        AutosEntity autosEntity = session.get(AutosEntity.class, id);
        session.close();
        return autosEntity;
    }

    @Override
    public List<AutosEntity> findAutoByUserID(int userId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<AutosEntity> autosEntityList = session.createQuery("From AutosEntity where 'user_id' = :userId")
                .setParameter("userId", userId).list();
        session.close();
        return autosEntityList;
    }

    @Override
    public List<AutosEntity> findAllAuto() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<AutosEntity> autosEntityList = session.createQuery("From AutosEntity").list();
        session.close();
        return autosEntityList;
    }
}
