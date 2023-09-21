package org.example.app.utils;

import org.example.app.entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserNameChecker {

    public static boolean isUserNameExists(User user) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = session.get(User.class, user.getUserName());

            if (user != null) {
                Query<User> query = session.createQuery("FROM User", User.class);
                query.setMaxResults(1);
                query.getResultList();
            }
            return user != null;
        }
    }
}
