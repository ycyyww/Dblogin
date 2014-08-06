package com.asiainfo.biz;

import com.asiainfo.dbUtil.DbUtil;
import com.asiainfo.domain.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class Dblogin {

        /*
         * String datebaseType = args[0];
		 * String user = args[1];
		 * String passWord = args[2];
		 * String dbAddress = args[3];
		 * String dbPort = args[4];
		 * String dbName = args[5];
		 */


    public static void main(String args[]) {
        DbUtil dbutil = new DbUtil();
        Connection conn = null;
/*        String databaseType = args[0];
        String user = args[1];
        String passWord = args[2];
        String dbAddress = args[3];
        String dbPort = args[4];
        String dbName = args[5];*/

        // MysqlTest
      /*  String user = "almams";
        String passWord = "almams";
        String databaseType = "mysql";   // here
        String dbAddress = "192.168.58.162";
        String dbPort = "3306";
        String dbName = "ALMAMSPUB_SERVER";*/

        //Oracle Test     jdbc:oracle:thin:@//192.168.58.164:1521/lcdmp2
        String user = "dhcp";
        String passWord = "dhcp123";
        String databaseType = "oracle";
        String dbAddress = "192.168.58.164";
        String dbPort = "1521";
        String dbName = "lcdmp2";
        //

        //com.sybase.jdbc3.jdbc.SybDriver
        //Sybase Test
     /*   String user = "dhcp";
        String passWord = "dhcp123";
        String databaseType = "Sybase";
        String dbAddress = "192.168.58.167";
        String dbPort = "5501";
        String dbName = "LCDMP2X_SYBASE";*/

        try {
            Database datebase = new Database();
            datebase.setDatabaseType(databaseType);
            datebase.setUser(user);
            datebase.setPassWord(passWord);
            datebase.setDbAddress(dbAddress);
            datebase.setDbPort(dbPort);
            datebase.setDbName(dbName);

            Map map = dbutil.getClassName(datebase);
            if (map.size() > 0) {
                //String className = (String) map.get("className");
                String url = dbutil.getUrl((String) map.get("drivername"), dbAddress, dbPort, dbName);
                conn = dbutil.startConn(url, user, passWord);
                String mysql_flag = dbutil.getSqlResult((String) map.get("sql_log"), conn);
                System.out.println(mysql_flag);
            } else {
                System.out.println("-1");
            }
        } catch (ClassNotFoundException e1) {
            System.out.println("-1");
        } catch (SQLException e1) {
            System.out.println("-1");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }


}
