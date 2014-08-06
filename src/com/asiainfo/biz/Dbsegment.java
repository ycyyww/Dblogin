package com.asiainfo.biz;

import com.asiainfo.dbUtil.DbUtil;
import com.asiainfo.domain.Database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Company:AsiaInfo Linkage
 * User: YcY_YcY
 * Date: 14-7-28 ÉÏÎç11:28
 * Description:
 */
public class Dbsegment {

    public static void main(String[] args) {
        DbUtil dbutil = new DbUtil();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

     /*   String user = "dhcp";
        String passWord = "dhcp123";
        String databaseType = "oracle";
        String dbAddress = "192.168.58.164";
        String dbPort = "1521";
        String dbName = "lcdmp2";
        String tableSpaceName="UNDOTBS1";*/


        String user = "dhcp";
        String passWord = "dhcp123";
        String databaseType = "Sybase";
       // String dbAddress = "192.168.58.167";
        String dbAddress = "192.168.58.163";
        String dbPort = "5501";
        String dbName = "LCDMP2X_SYBASE";
        //String tableSpaceName = "default";
        String tableSpaceName = "system";
        try {
            Database database = new Database();
            database.setDatabaseType(databaseType);
            database.setUser(user);
            database.setPassWord(passWord);
            database.setDbAddress(dbAddress);
            database.setDbPort(dbPort);
            database.setDbName(dbName);
            database.setTableSpaceName(tableSpaceName);

            Map map = dbutil.getClassName(database);
            if (map.size() > 0) {
                String usedprecent = "";
                String className = (String) map.get("className");
                String url = dbutil.getUrl((String) map.get("drivername"), dbAddress, dbPort, dbName);
           //     conn = dbutil.startConn(conn, className, url, user, passWord);
                if (databaseType.toUpperCase().equals("SYBASE")) {
                    cs = conn.prepareCall("{call  dbo.saaaaap_segment(?)}");
                    cs.setString(1, tableSpaceName);
                    cs.execute();
                    rs = cs.getResultSet();
                    while (rs.next()) {
                        usedprecent = rs.getString("used_percent");
                    }
                } else {
                    usedprecent = dbutil.getUsedPrecent((String) map.get("sql_segment"), conn);
                }

                System.out.println(usedprecent);
            } else {
                System.out.println("-1");
            }
       // } catch (ClassNotFoundException e1) {
            System.out.println("-1");
        } catch (SQLException e1) {
            e1.printStackTrace();
            System.out.println("-1");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                }
            }


        }
    }

}
