package com.asiainfo.domain;

/**
 * Company:AsiaInfo Linkage
 * User: YcY_YcY
 * Date: 14-7-24 ����7:56
 * Description:
 * ���Բ���:
 * user           ��½���ݿ���û���
 * passWord       ��½���ݿ���û�����
 * databaseType   ���ݿ����ͣ��磺Oracle��Mysql,Sybase��
 * dbAddress      ���ݿ��ip��ַ
 * dbPort         ���ݿ�˿ں�
 * dbName         ���ݿ�����
 * ���Բ�����
 * url            ���ݿ�����
 * className      ���ݿ�����
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
