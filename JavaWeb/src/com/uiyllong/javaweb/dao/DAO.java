package com.uiyllong.javaweb.dao;

import com.uiyllong.javaweb.db.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * ��װ�˻����� CRUD �ķ������Թ�����̳�ʹ��
 * ��ǰ DAO ֱ���ڷ����л�ȡ���ݿ����ӡ�
 * ���� DAO ��ȡ DBUtils ���������
 * <T>:��ǰ DAO �����ʵ�����������ʲô</>
 * Created by YLL on 2016/3/11.
 */
public class DAO<T> {

    private QueryRunner queryRunner = new QueryRunner();

    public DAO() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) superClass;
            Type [] typeArgs = parameterizedType.getActualTypeArguments();
            if (typeArgs != null && typeArgs.length > 0) {
                if (typeArgs[0] instanceof Class) {
                    clazz = (Class<T>) typeArgs[0];
                }
            }
        }

    }

    private Class<T> clazz;

    /**
     * ����ĳһ���ֶε�ֵ�����緵��ĳһ����¼�� customerName���򷵻����ݱ����ж�������¼�ȡ�
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E getForValue(String sql, Object ... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }

    /**
     * ���� T ����Ӧ�� List
     * @param sql
     * @param args
     * @return
     */
    public List<T> getForList(String sql, Object ... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }

    /**
     * ���ض�Ӧ�� T ��һ��ʵ����Ķ���
     * @param sql
     * @param args
     * @return
     */
    public T get(String sql, Object ... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }

    /**
     * �÷�����װ�� INSERT��DELETE��UPDATE ����
     * @param sql��SQL ���
     * @param args����� SQL ����ռλ��
     */
    public void update(String sql, Object ... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            queryRunner.update(connection, sql, args);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConnection(connection);
        }
    }
}
