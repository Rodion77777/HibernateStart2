package dao;

import models.AutoEntity;
import models.UserEntity;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class AutoEntityDAOImpl implements AutoEntityDAO
{
    @Override
    public AutoEntity findAutoById(int id)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        AutoEntity autoEntity = session.get(AutoEntity.class, id);
        session.close();
        return autoEntity;
    }

    @Override
    public List<AutoEntity> findAutoByUserEntity(UserEntity userEntity)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<AutoEntity> autoEntityList = session.createQuery("from AutoEntity where userEntity = :userId").setParameter("userId", userEntity).getResultList();
        session.close();
        return autoEntityList;
    }

    @Override
    public List<AutoEntity> findAllAuto()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<AutoEntity> autoEntityList = session.createQuery("From AutoEntity").list();
        session.close();
        return autoEntityList;
    }
}
