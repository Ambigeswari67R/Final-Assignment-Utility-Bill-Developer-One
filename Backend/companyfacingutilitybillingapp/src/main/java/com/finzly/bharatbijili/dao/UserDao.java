package com.finzly.bharatbijili.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;
import com.finzly.bharatbijili.entity.User;

@Repository
public class UserDao {
	@Autowired
	SessionFactory factory;

	public List<User> getAllUsers() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		return criteria.list();
	}

	public List<User> getUserById(Long userId) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId));
		return criteria.list();

	}

	public String createUser(User user) {

		try {
			Session session = factory.openSession();
			session.save(user);
			session.beginTransaction().commit();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "User successsfully added";
	}

	public String updateUser(Long userId, User updatedUser) {

		Session session = factory.openSession();
		Transaction tx = null;
		String resultMessage = "";

		try {
			tx = session.beginTransaction();

			User existingUser = session.get(User.class, userId);

			if (existingUser != null) {
				existingUser = (User) session.merge(updatedUser);

				tx.commit();
				resultMessage = "User updated successfully!";
			} else {
				resultMessage = "User not found with ID: " + userId;
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			resultMessage = "Error updating User: " + e.getMessage();
		} finally {
			session.close();
		}

		return resultMessage;

	}

	public String deleteUser(Long userId) {

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			User userToDelete = session.get(User.class, userId);

			if (userToDelete != null) {
				session.delete(userToDelete);
				tx.commit();
				return "User deleted successfully";
			} else {
				return "User with ID " + userId + " not found";
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return "Error deleting user: " + e.getMessage();
		} finally {
			session.close();
		}
	}

}
