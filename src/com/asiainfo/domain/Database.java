package com.asiainfo.domain;

/**
 * Company:AsiaInfo Linkage
 * User: YcY_YcY
 * Date: 14-7-24 上午7:56
 * Description:
 * 显性参数:
 * user           登陆数据库的用户名
 * passWord       登陆数据库的用户密码
 * databaseType   数据库类型（如：Oracle，Mysql,Sybase）
 * dbAddress      数据库的ip地址
 * dbPort         数据库端口号
 * dbName         数据库名称
 * 隐性参数：
 * url            数据库链接
 * className      数据库驱动
 */
public class Database {
    private String databaseType;
    private String className;
    private String user;
    private String passWord;
    private String dbAddress;
    private String dbPort;
    private String dbName;
    private String url;
    private String tableSpaceName;

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDbAddress() {
        return dbAddress;
    }

    public void setDbAddress(String dbAddress) {
        this.dbAddress = dbAddress;
    }

    public String getDbPort() {
        return dbPort;
    }

    public void setDbPort(String dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTableSpaceName() {
        return tableSpaceName;
    }

    public void setTableSpaceName(String tableSpaceName) {
        this.tableSpaceName = tableSpaceName;
    }
}
