package dev.terry.data;

import dev.terry.entities.AppUser;
import dev.terry.entities.enums.Role;
import dev.terry.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUserDAOPostgres implements AppUserDAO {

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
}
