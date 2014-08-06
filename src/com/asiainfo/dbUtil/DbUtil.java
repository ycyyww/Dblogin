package com.asiainfo.dbUtil;

import com.asiainfo.domain.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DbUtil {

    public Connection startConn(String url, String user, String passWord) throws ClassNotFoundException,
            SQLException {

        return DriverManager.getConnection(url, user, passWord);

    }

    /**
     * |
     *
     * @param sql
     * @param conn
     * @return
     */
    public String getSqlResult(String sql, Connection conn) {
        Statement stmt = null;
        ResultSet rs = null;
        String str = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);// sql为sql语句例如"select * from
            while (rs.next()) {
                str = rs.getString("0");
            }

        } catch (SQLException e) {
        } finally {
            closeConn(rs, stmt);
        }
        return str;
    }


    /**
     * @param sql
     * @param conn
     * @return
     */
    public String getUsedPrecent(String sql, Connection conn) {
        Statement stmt = null;
        ResultSet rs = null;
        String str = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);// sql为sql语句例如"select * from
            while (rs.next()) {
                str = rs.getString("usedprecent");
            }
        } catch (SQLException e) {
        } finally {
            closeConn(rs, stmt);
        }
        return str;
    }


    /*public void excuteProdure(String sql, Connection conn) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            stmt.executeQuery(sql);
            *//*while (rs.next()) {
                str = rs.getString("usedprecent");
            }*//*
        } catch (SQLException e) {
        }
    }
*/
    public void closeConn(ResultSet rs, Statement stmt) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
        }
    }

    public void closeConn(Statement stmt, Connection conn) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
    }

    /**
     * @param database
     * @return
     */
    public Map<String, String> getClassName(Database database) {
        String datebaseType = database.getDatabaseType();
        Map<String, String> driveMap = new HashMap<String, String>();
        if (datebaseType.toUpperCase().equals("MYSQL")) {
            driveMap.put("className", "com.mysql.jdbc.Driver");
            driveMap.put("drivername", "jdbc:mysql://");
            driveMap.put("sql_log", "select 0");
        }
        if (datebaseType.toUpperCase().equals("ORACLE")) {
            StringBuffer sql_Oracle = new StringBuffer("select  round((total-free)/total,4) usedprecent from( select tablespace_name,sum(bytes)/1024/1024 total from dba_data_files group by tablespace_name) a,(select tablespace_name,sum(bytes)/1024/1024 free from dba_free_space group by tablespace_name) b where a.tablespace_name=b.tablespace_name and a.tablespace_name='");
            sql_Oracle.append(database.getTableSpaceName()).append("'");
            driveMap.put("className", "oracle.jdbc.driver.OracleDriver");
            driveMap.put("drivername", "jdbc:oracle:thin:@//");
            driveMap.put("sql_log", "select 0 from dual");
            driveMap.put("sql_segment", sql_Oracle.toString());
        }
        if (datebaseType.toUpperCase().equals("SYBASE")) {
            StringBuffer sql_Sybase = new StringBuffer("select used_percent from #store_segment where segment_name='");
            sql_Sybase.append(database.getTableSpaceName()).append("'");
            driveMap.put("className", "com.sybase.jdbc2.jdbc.SybDriver");
            driveMap.put("drivername", "jdbc:sybase:Tds:");
            driveMap.put("sql_log", "select 0 as '0' ");
            driveMap.put("sql_segment", sql_Sybase.toString());
        }
        return driveMap;
    }

    /**
     * 说明：拼接数据库需要的URL
     *
     * @param datebaseType
     * @param dbAddress
     * @param dbPort
     * @param dbName
     * @return
     */
    public String getUrl(String datebaseType, String dbAddress, String dbPort, String dbName) {
        return datebaseType + dbAddress + ":" + dbPort + "/" + dbName;
    }


}
