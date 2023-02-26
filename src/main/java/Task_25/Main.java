package Task_25;

import java.sql.*;

public class Main {

    public static final String USER_NAME = "User";
    public static final String PASSWORD = "root";
    public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/students";
    public static Connection connection;
    public static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        createTableOfStudents();

        //Добавление данных в таблицу
        addStudentToTable(1, "Alex", "Backer");
        addStudentToTable(2, "Maria", "Crane");
        addStudentToTable(3, "Ann", "Donovan");

        //Удаление данных из таблицы (по имени студента)
        deleteStudentFromTable("Alex");

        //Получение данных из таблицы
        printTableInfo("groupStudents");
    }

    public static void createTableOfStudents() {
        try {
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
        }
    }

    public static void addStudentToTable(int id, String name, String surname) {

        try {
            statement.executeUpdate("insert into students.groupStudents(id, name, surname)" +
                    "value (" + id + ", '" + name + "', '" + surname + "')"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudentFromTable(String name) {

        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM groupStudents WHERE name = ?");
            st.setString(1, name);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printTableInfo(String tableName) {

        try {
            ResultSet resultSet = statement.executeQuery("SELECT * From " + tableName);

            //Выведение полученных данных на консоль
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " +
                        resultSet.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}