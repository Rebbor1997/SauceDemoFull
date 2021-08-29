package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class DataBaseService {
   /* public static Logger logger = Logger.getLogger(DataBaseService.class);

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "1234567";

    Connection connection;
    Statement statement;

    public DataBaseService(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            logger.info(e.toString());
        } catch (SQLException trowables) {
            logger.info(trowables.toString());
        }

        if (connection != null){
            logger.info("Соединение установлено успешно");
        }else {
            logger.info("Что-то пошло не так");
        }

    }

    */
}
