package by.it.romanova.at21;

import by.it.romanova.at21.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDao implements InterfaceDao<User> {
    @Override
    public User read(long id) throws SQLException {

        User user = null;

        String sql = "SELECT * FROM romanova.user WHERE id="+id;
        CreateConnectionCreator connectionCreator = new ConnectionCreatorMySql();
        try (Connection connection = connectionCreator.get();
             Statement statement = connection.createStatement()){

                ResultSet resultSet = statement.executeQuery(sql);
                if(resultSet.next()){
                    user = new User(resultSet.getLong("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            resultSet.getDate("create_time"));
        }
    }

        return user;
    }

    @Override
    public boolean create(User user) throws SQLException {

        String sql = String.format("insert INTO user (username, email, password, create_time)"+
                "values('%s','%s','%s','%s')",
                user.getUsername(), user.getEmail(), user.getPassword(), user.getDate());
        CreateConnectionCreator connectionCreator = new ConnectionCreatorMySql();
        try (Connection connection = connectionCreator.get();
             Statement statement = connection.createStatement()){
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if(generatedKeys.next()){
                    long id=generatedKeys.getLong(1);
                    user.setId(id);
                    return true;
                }

            }

        }
        return false;
    }

    @Override
    public boolean update(User bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(User bean) throws SQLException {
        return false;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }
}
