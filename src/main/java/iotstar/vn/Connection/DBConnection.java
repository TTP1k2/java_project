package iotstar.vn.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private final String serverName = "DESKTOP-UKB0RP4";
	private final String dbName = "ShopOnline";
	private final String portNumber = "1433";
	private final String instance = "THANHPC";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	private final String userID = "";
	private final String password = "";
	//Kết nối SQL Server với Windows Authentication
	public Connection getConnection () throws Exception {
		
		String url ="jdbc:sqlserver://"+ serverName
		+ "\\"+ instance + ";integratedSecurity=true;databaseName =" +	dbName;
		if (instance == null || instance.trim().isEmpty())
		url	= "jdbc:sqlserver://" + serverName + ":"+ portNumber +
		";integratedSecurity=true;databaseName ="+ dbName;
		
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url);
	}

	public static void main(String[] args ) {
		try { System.out.println(new DBConnection().getConnection());
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
	}
}
