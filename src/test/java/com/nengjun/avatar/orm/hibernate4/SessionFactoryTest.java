package com.nengjun.avatar.orm.hibernate4;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Henry on 15/9/11.
 */
public class SessionFactoryTest {
    @Test
    public void test() {
        final Session session = HibernateSessionFactory.getSession();
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
            HibernateSessionFactory.closeSession();
        }
    }
}
