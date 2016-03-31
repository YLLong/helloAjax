package com.uiyllong.javaweb.dao;

import com.uiyllong.javaweb.javaBean.Customer;

import java.util.List;

/**
 * Created by YLL on 2016/3/11.
 */
public interface CustomerDAO {

    public List<Customer> getAll();

    public void save(Customer customer);

    public Customer get(Integer id);

    public void delete(Integer id);

    /**
     * ���غ� name ��ȵļ�¼����
     * @param name
     * @return
     */
    public long getCountWithName(String name);

}
