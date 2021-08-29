package dbEntities;

import services.DataBaseService;

import java.sql.ResultSet;

public class CustomersTableAdapter {

    DataBaseService dbService;

    public CustomersTableAdapter(DataBaseService dbService){
        this.dbService = dbService;
    }

    //Методаы добавления, удаления и редактирования записей
    public ResultSet getAllCustomers(){
        return null;
    }
/*
    public boolean addCustomer (){
        return false;
    }
    //Методы создания и удаления таблицы
    public boolean createTable(){
        String createTableSQL = "CREATE TABLE customers (" +
                "id SERIAL PRIMARY KEY, " +
                "firstName CHARACTER VARYING(30), " +
                "lastName CHARACTER VARYING(30), " +
                "email CHARACTER VARYING(30), " +
                "age INTEGER" +
                ");";
        return ;
    }



    public boolean dropTable(){
        String dropTableSQL = "DROP Table customers";
    }

 */
}
