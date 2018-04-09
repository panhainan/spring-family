package site.sixteen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import site.sixteen.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, UserTopicDAO {

    User findByNameIgnoringCase(String name);

    List<User> findAllByEmailLike(String email);

    /**
     * JPA自定义查询功能测试案例
     * 注意此处为HQL语句，from后面必须为实体类名，而不是表名
     */
    @Query("select u from User u where u.email like '%@gmail.com'")
    List<User> findAllGmailUsers();
}
