package com.uiyllong.javaweb.dao.impl;

import com.uiyllong.javaweb.dao.CustomerDAO;
import com.uiyllong.javaweb.dao.DAO;
import com.uiyllong.javaweb.javaBean.Customer;

import java.util.List;

/**
 * Created by YLL on 2016/3/11.
 */
public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO {
    @Override
    public List<Customer> getAll() {
        String sql = "select id, name, address, phone from customers";
        return getForList(sql);
    }

    @Override
    public void save(Customer customer) {
        String sql = "insert into customers(name, address, phone) values (?, ?, ?)";
        update(sql, customer.getName(), customer.getAddress(), customer.getPhone());
    }

    @Override
    public Customer get(Integer id) {
        String sql = "select id, name, address, phone from customers where id = ?";
        return get(sql, id);
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from customers where id = ?";
        update(sql, id);
    }

    @Override
    public long getCountWithName(String name) {
        String sql = "select count(id) from customers where name = ?";
        return getForValue(sql, name);
    }
}
