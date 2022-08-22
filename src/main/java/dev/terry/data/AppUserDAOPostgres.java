package dev.terry.data;

import dev.terry.entities.AppUser;
import dev.terry.entities.enums.Role;
import dev.terry.utils.ConnectionUtil;

import java.sql.*;

public class AppUserDAOPostgres implements AppUserDAO {

    @Override
    public AppUser createAccount(AppUser appUser) {
        try(Connection conn = ConnectionUtil.createConnection())
        {
            String sql = "insert into app_user values(default, ?, ?, ?, ?, default)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, appUser.getUsername());
            preparedStatement.setString(2, appUser.getPassword());
            preparedStatement.setString(3, appUser.getFname());
            preparedStatement.setString(4, appUser.getLname());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            appUser.setId(rs.getInt("id"));
            appUser.setRole(Role.valueOf(rs.getString("userRole")));

            return appUser;

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AppUser getAppUserByUsername(String username) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from app_user where username = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            if(!rs.next()){
                return null;
            }
            AppUser appUser = new AppUser();
            appUser.setId(rs.getInt("id"));
            appUser.setUsername(rs.getString("username"));
            appUser.setPassword(rs.getString("password"));
            appUser.setFname(rs.getString("fname"));
            appUser.setLname(rs.getString("lname"));
            appUser.setRole(Role.valueOf(rs.getString("userRole")));

            return appUser;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AppUser updateRole(AppUser appUser, Role role) {
        try(Connection conn = ConnectionUtil.createConnection())
        {
            String sql = "update app_user set userRole = ? where username = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, role.name());
            preparedStatement.setString(2, appUser.getUsername());

            preparedStatement.executeUpdate();
            appUser.setRole(role);
            return appUser;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
