package Task_25;

import java.sql.*;

public class Main {

    public static MySQLDriverManager driverManager = MySQLDriverManager.getInstance();

    public static void main(String[] args) {

        createTableOfStudents();

        //Добавление данных в таблицу
        addStudentToTable(1, "Alex", "Backer");
        addStudentToTable(2, "Maria", "Crane");
        addStudentToTable(3, "Ann", "Donovan");

        //Удаление данных из таблицы (по имени студента)
        deleteStudentFromTable("Alex");

        //Получение данных из таблицы
        printTableInfo();
    }

    public static void createTableOfStudents() {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = driverManager.getConnection();
            statement = connection.createStatement();

            statement.executeUpdate("drop table groupStudents");

            //Создание таблицы студентов
            statement.executeUpdate("create table groupStudents (" +
                    "id int not null auto_increment," +
                    "name varchar(45) not null," +
                    "surname varchar(45)," +
                    "primary key (id))"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addStudentToTable(int id, String name, String surname) {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = driverManager.getConnection();
            statement = connection.createStatement();

            statement.executeUpdate("insert into students.groupStudents(id, name, surname)" +
                    "value (" + id + ", '" + name + "', '" + surname + "')"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteStudentFromTable(String name) {

        Connection connection = null;

        try {
            connection = driverManager.getConnection();

            PreparedStatement st = connection.prepareStatement("DELETE FROM groupStudents WHERE name = ?");
            st.setString(1, name);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printTableInfo() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = driverManager.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * From " + "groupStudents");

            //Выведение полученных данных на консоль
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " +
                        resultSet.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}