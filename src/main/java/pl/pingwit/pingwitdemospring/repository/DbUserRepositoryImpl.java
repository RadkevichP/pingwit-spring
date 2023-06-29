package pl.pingwit.pingwitdemospring.repository;

import org.springframework.stereotype.Repository;
import pl.pingwit.pingwitdemospring.repository.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
@Repository
public class DbUserRepositoryImpl implements UserRepository {

    private final DataSource dataSource;

    public DbUserRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User getById(Integer id) {

        try (Connection connection = dataSource.getConnection()) {

        } catch (SQLException e) {

        }

        return null;
    }

    @Override
    public Collection<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from users");

            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void delete(Integer userId) {

    }

    @Override
    public Integer createUser(User userToCreate) {
        return null;
    }
}