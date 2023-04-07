package repositories;

import doMainModels.ChiTietSP;
import doMainModels.SanPham;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class ChiTietSPRepository {
    private Session hSession;

    public ChiTietSPRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(ChiTietSP ctsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChiTietSP ctsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChiTietSP ctsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChiTietSP findById(String id) {
        return this.hSession.find(ChiTietSP.class, id);
    }

    public List<ChiTietSP> findAll() {
        String hql = "SELECT obj FROM ChiTietSP obj";
        TypedQuery<ChiTietSP> query = this.hSession.createQuery(hql, ChiTietSP.class);
        return query.getResultList();
    }

    public ChiTietSP findByID(String id)
    {
        String hql = "SELECT obj FROM ChiTietSP obj WHERE obj.id = ?1";
        TypedQuery<ChiTietSP> query = this.hSession.createQuery(hql, ChiTietSP.class);
        query.setParameter(1, id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
