package site.sixteen.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserRepositoryImpl {
    private final long GLORY_USER_TOPIC_PRAISE_THRESHOLD = 100;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional //update和delete操作需要添加事务支持，否则执行失败
    public int updateUserGloryByTopicPraise() {
        String update = "update User u set u.glory='active user' where u.id in (select distinct(t.userId) from Topic t where t.praise >= " + GLORY_USER_TOPIC_PRAISE_THRESHOLD + " )";
        return entityManager.createQuery(update).executeUpdate();
    }
}
