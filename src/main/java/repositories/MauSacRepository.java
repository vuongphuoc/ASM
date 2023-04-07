package repositories;

import doMainModels.MauSac;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    private Session hSession;

    public MauSacRepository(){
        hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(MauSac ms){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.persist(ms);
            transaction.commit();

        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(MauSac ms){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.merge(ms);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(MauSac ms){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.delete(ms);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public MauSac findById(UUID id){
        return  hSession.find(MauSac.class,id);
    }

    public List<MauSac> findAll(){
        String hql = "select obj from MauSac obj";
        TypedQuery<MauSac> query = hSession.createQuery(hql,MauSac.class);
        return query.getResultList();
    }
    public MauSac findByMa(String ma){
        String hql = "select obj from MauSac obj where obj.ma = ?1";
        TypedQuery<MauSac> query = hSession.createQuery(hql, MauSac.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

}
