package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;

public class Main {

    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) throws SQLException {

        // реализуйте алгоритм здесь
        userService.createUsersTable();

        userService.saveUser("John", "Doe", (byte) 27);
        userService.saveUser("Jane", "Doe", (byte) 16);
        userService.saveUser("Adam", "Smith", (byte) 87);
        userService.saveUser("Ellen", "Smith", (byte) 99);

        userService.getAllUsers();

       userService.removeUserById(3);
        userService.cleanUsersTable();
       userService.dropUsersTable();



    }
}
