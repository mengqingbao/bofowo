package org.mybatis.spring;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MultiDataSource implements DataSource {
	
	private Map<String,DataSource> datasourceMap;

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return datasourceMap.get(DataDomian.getDataBaseId()).getLogWriter();
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		datasourceMap.get(DataDomian.getDataBaseId()).setLogWriter(out);

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		datasourceMap.get(DataDomian.getDataBaseId()).setLoginTimeout(seconds);
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return datasourceMap.get(DataDomian.getDataBaseId()).getLoginTimeout();
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return datasourceMap.get(DataDomian.getDataBaseId()).getParentLogger();
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return datasourceMap.get(DataDomian.getDataBaseId()).unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return datasourceMap.get(DataDomian.getDataBaseId()).isWrapperFor(iface);
	}

	@Override
	public Connection getConnection() throws SQLException {
		return datasourceMap.get(DataDomian.getDataBaseId()).getConnection();
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		return datasourceMap.get(DataDomian.getDataBaseId()).getConnection(username, password);
	}

	public void setDatasourceMap(Map<String, DataSource> datasourceMap) {
		this.datasourceMap = datasourceMap;
	}
}
