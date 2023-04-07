package repositories;


import doMainModels.ChucVu;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    private Session hSession;

    public ChucVuRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(ChucVu cv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChucVu cv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChucVu cv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChucVu findById(String id) {
        return this.hSession.find(ChucVu.class, id);
//        ChucVu cv = null;
//        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("from ChucVu where id =:id1", ChucVu.class);
//            query.setParameter("id1", id);
//            cv = (ChucVu) query.getSingleResult();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return cv;
    }

    public List<ChucVu> findAll() {
        String hql = "SELECT obj FROM ChucVu obj";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        return query.getResultList();
    }

    public ChucVu findByMa(String ma)
    {
        String hql = "SELECT obj FROM ChucVu obj WHERE obj.ma = ?1";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        query.setParameter(1, ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
