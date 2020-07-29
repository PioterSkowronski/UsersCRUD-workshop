package pl.coderslab.entity;


import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class UserDao {

    public  User create(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            String query = "INSERT INTO users VALUES(null, ?, ?, ?);";
            PreparedStatement statement =
                    conn.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            String query1 = "select id from users where email = ?";
            PreparedStatement statement1 =
                    conn.prepareStatement(query1);
            statement1.setString(1, user.getEmail());
            ResultSet result = statement1.executeQuery();
            result.next();
            int id = Integer.parseInt(result.getString(1));
            user.setId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public  User read(int userId) {

        User user = new User();
        if (userId > 0) {
            try (Connection conn = DbUtil.getConnection()) {
                String query = "select * from users where id = ?";
                PreparedStatement statement =
                        conn.prepareStatement(query);
                statement.setInt(1, userId);
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    user.setId(result.getInt(1));
                    user.setEmail(result.getString(2));
                    user.setUserName(result.getString(3));
                    user.setPassword(result.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;
        } else {
            System.out.println("Id musi być większe od 0");
            return null;
        }
    }

    public  void update(User user) {
        try (Connection conn = DbUtil.getConnection()) {

            String query1 = "select id,email from users";
            PreparedStatement statement1 =
                    conn.prepareStatement(query1);
            ResultSet result = statement1.executeQuery();
            int id1 = 0;
            while (result.next()) {
                if(result.getInt(1) == user.getId()){
                    id1 = user.getId();
                }
            }
                if ( user.getId() == id1){
                    String query = "update users set email = ?, username = ?, password = ? where id = ?";
                    PreparedStatement statement =
                            conn.prepareStatement(query);
                    statement.setString(1, user.getEmail());
                    statement.setString(2, user.getUserName());
                    statement.setString(3, hashPassword(user.getPassword()));
                    statement.setInt(4, user.getId());
                    statement.executeUpdate();
                } else {
                    System.out.println("Wpisu o podanym id nie ma w bazie danych");
                }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  void delete(int userId) {
        try (Connection conn = DbUtil.getConnection()) {
            String query = "delete from users where id = ?";
            PreparedStatement statement =
                    conn.prepareStatement(query);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  User[] findAll() {
        User[] tab = new User[0];
        try (Connection conn = DbUtil.getConnection()) {
            String query = "select * from users";
            PreparedStatement statement =
                    conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            int counter = 0;
            while (result.next()) {
                tab = Arrays.copyOf(tab, tab.length + 1);
                tab[tab.length - 1] = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tab;
    }

    public  void deleteAll() {

        try (Connection conn = DbUtil.getConnection()) {
            String query = "delete from users";
            PreparedStatement statement =
                    conn.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}



