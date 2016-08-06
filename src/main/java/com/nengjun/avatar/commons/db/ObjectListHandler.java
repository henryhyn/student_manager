package com.nengjun.avatar.commons.db;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by Henry on 16/8/6.
 */
@Slf4j
public class ObjectListHandler extends AbstractListHandler<Object> {
    private Class<?> objectType;

    public ObjectListHandler(Class<?> objectType) {
        super();
        this.objectType = objectType;
    }

    @Override
    protected Object handleRow(ResultSet rs) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        Object object = null;
        try {
            object = Class.forName(objectType.getName()).newInstance();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                String name = "set" + StringUtils.capitalize(meta.getColumnLabel(i));
                Class<?> parameterType = Class.forName(meta.getColumnClassName(i));
                Method method = objectType.getMethod(name, parameterType);
                method.invoke(object, rs.getObject(i, parameterType));
            }
        } catch (NoSuchMethodException e) {
            log.error("No such method.", e);
        } catch (InstantiationException e) {
            log.error("Error on instantiation.", e);
        } catch (IllegalAccessException e) {
            log.error("Error on illegal access.", e);
        } catch (InvocationTargetException e) {
            log.error("Error on invocation target.", e);
        } catch (ClassNotFoundException e) {
            log.error("Class not found.", e);
        }
        return object;
    }
}
