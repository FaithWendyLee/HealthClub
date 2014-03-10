package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import dao.DaoHelper;

public class DaoHelperImpl implements DaoHelper {
	private static DaoHelperImpl baseDao = new DaoHelperImpl();
	private Connection connection = null;
	private InitialContext jndiContext = null;
	private DataSource dataSource = null;

	private DaoHelperImpl() {
		try {
			jndiContext = new InitialContext();
			dataSource = (DataSource) jndiContext
					.lookup("java:comp/env/jdbc/HealthClub");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DaoHelperImpl getBaseDaoInstance() {
		return baseDao;
	}

	@Override
	public Connection getConnection() {
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closePreparedStatement(PreparedStatement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closeResult(ResultSet result) {
		if(result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		        //装载配置文件  
        Configuration cfg = new Configuration().configure();  
        SchemaExport export = new SchemaExport(cfg);  
        export.create(true, true); 
	}

}
