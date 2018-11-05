package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Service {
    private Connection dbconnecion;
    private Statement st;
    private ResultSet rs;
    private String sql;
    private List list;

    public List getProfit(){
        

        return list;
    }
}
