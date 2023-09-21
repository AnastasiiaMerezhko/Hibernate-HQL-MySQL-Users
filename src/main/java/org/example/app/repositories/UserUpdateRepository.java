package org.example.app.repositories;

import org.example.app.entities.User;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
import org.example.app.utils.UserNameChecker;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserUpdateRepository {

    public String updateUser(User user) {
        if (UserNameChecker.isUserNameExists(user)) {
            return updateUserByUserName(user);
        } else {
            return Constants.USERNAME_NO_EXISTS_MSG;
        }
    }

    public String updateUserByUserName(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "UPDATE User SET email = :email WHERE userName = :userName";
            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("email", user.getEmail());
            query.setParameter("userName", user.getUserName());
            query.executeUpdate();
            transaction.commit();
            return Constants.DATA_UPDATE_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}