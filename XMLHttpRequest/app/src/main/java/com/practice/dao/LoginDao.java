package com.practice.dao;

import com.practice.models.LoginModel;
import com.practice.utils.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {
    Connection cs = null;

    public boolean createUser(LoginModel lm) {
        String sql = "INSERT INTO users_table (username, password) VALUES (?, ?);";

        try {
            cs = ConnectionSingleton.getConnection();
            PreparedStatement ps = cs.prepareStatement(sql);

            ps.setString(1, lm.getUsername());
            ps.setString(2, lm.getPassword());

            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<LoginModel> displayAll() {
        List<LoginModel> llm = new ArrayList<>();
        LoginModel lm = null;

        String sql = "SELECT * FROM users_table;";

        try {
            cs = ConnectionSingleton.getConnection();
            Statement s = cs.createStatement();
            s.execute(sql);

            ResultSet rs = s.getResultSet();

            while(rs.next()) {
                lm = new LoginModel();
                lm.setPassword(rs.getString(2));
                lm.setUsername(rs.getString(1));

                llm.add(lm);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llm;
    }
}
