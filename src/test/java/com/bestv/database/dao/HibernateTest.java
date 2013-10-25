package com.bestv.database.dao;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.metadata.ClassMetadata;
import org.junit.Test;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 13-10-17
 * Time: 下午3:29
 * To change this template use File | Settings | File Templates.
 */
public class HibernateTest {
    @Test
    public void test() throws Exception {
        final Session session = HibernateDao.getInstance().getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}
