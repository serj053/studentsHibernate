package org.example;

import org.example.Tables.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<PurchaseList> purchaseListQuery = session.createQuery("select pur from PurchaseList pur")
                .getResultList();

        for (PurchaseList purchaseList : purchaseListQuery) {
            String st = purchaseList.getId().getStudentName();
            String cr = purchaseList.getId().getCourseName();
            Query stdQ = session.createQuery("select st from Student  st where name =: stName")
                    .setParameter("stName", st);
            Student std = (Student) stdQ.getSingleResult();
            Query crsQ = session.createQuery("select cr from Course cr where name =: purName")
                    .setParameter("purName", cr);
            Course crs = (Course) crsQ.getSingleResult();
            System.out.println("1  " + std.getId() + "  " + crs.getId());
            LinkedPurchaseListKey key = new LinkedPurchaseListKey(std.getId(), crs.getId());
            LinkedPurchaseList lpList = new LinkedPurchaseList(key);
            session.persist(lpList);
        }

        transaction.commit();
        sessionFactory.close();
    }
}
