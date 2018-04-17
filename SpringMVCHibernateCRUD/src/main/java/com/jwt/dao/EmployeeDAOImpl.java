package com.jwt.dao;

import com.jwt.model.Employee;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEmployee(Employee employee) {
        Transaction tx = sessionFactory.openSession().beginTransaction();
//        tx.begin();
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
        tx.commit();

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAllEmployees() {
//        Session session = null;
//        Transaction transaction = null;
//        session = HibernateUtil.getSessionFactory().openSession();
//        transaction = session.getTransaction();
//        transaction.begin();
//        return session.createQuery("from Employee").list();
//            session.save(person);
//         transaction.commit();
        return sessionFactory
                .getCurrentSession()
                .createCriteria(Employee.class)
                .add(Restrictions.like("name", "n%"))
                .list();
//        return sessionFactory.getCurrentSession().createQuery("from Employee").list();

    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }

    }

    @Override
    public Employee getEmployee(int empid) {
        return (Employee) sessionFactory.getCurrentSession().get(
                Employee.class, empid);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return employee;
    }
}
