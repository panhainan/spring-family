package site.sixteen.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import site.sixteen.dao.UserRepository;
import site.sixteen.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("userRepository")
public class JdbcUserRepository implements UserRepository {

    private static final String INSERT_USER = "INSERT INTO user (name,sex,birth,phone,email,profile) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "select id,name,sex,birth,phone,email,profile from user where id = ?";


    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcUserRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void saveUser(User user) {
        jdbcOperations.update(INSERT_USER,
                user.getName(),
                user.getSex(),
                user.getBirth(),
                user.getPhone(),
                user.getEmail(),
                user.getProfile());
    }

    @Override
    public User getUser(long id) {
        return jdbcOperations.queryForObject(SELECT_USER_BY_ID, new UserRowMapper(), id);
    }

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new User(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("birth"),
                    resultSet.getInt("sex"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getString("profile"));
        }
    }
}
