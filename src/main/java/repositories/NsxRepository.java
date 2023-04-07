package repositories;

import doMainModels.Nsx;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class NsxRepository {
    private Session hSession;
    public NsxRepository(){
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(Nsx nsx)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(Nsx nsx)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(Nsx nsx)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public Nsx findById(UUID id){
        return this.hSession.find(Nsx.class,id);
    }
    public List<Nsx> findAll() {
        String hql = "SELECT obj FROM Nsx obj";
        TypedQuery<Nsx> query = this.hSession.createQuery(hql, Nsx.class);
        return query.getResultList();
    }

    public Nsx findByMa(String ma)
    {
        String hql = "SELECT obj FROM Nsx obj WHERE obj.ma = ?1";
        TypedQuery<Nsx> query = this.hSession.createQuery(hql, Nsx.class);
        query.setParameter(1, ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

}
