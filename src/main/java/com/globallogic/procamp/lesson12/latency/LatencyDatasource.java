package com.globallogic.procamp.lesson12.latency;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import lombok.experimental.Delegate;


public class LatencyDatasource implements DataSource {
    @Delegate(excludes = LatencyDatasource.ConnectionAware.class)
    private final DataSource realDataSource;
    private final LatencySimulator latencySimulator;

    public LatencyDatasource(DataSource realDataSource, LatencySimulator latencySimulator) {
        this.realDataSource = realDataSource;
        this.latencySimulator = latencySimulator;
    }

    @Override
    public Connection getConnection() throws SQLException {
        final Connection connection = realDataSource.getConnection();
        return new LatencyConnection(connection, latencySimulator);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        final Connection connection = realDataSource.getConnection(username, password);
        return new LatencyConnection(connection, latencySimulator);
    }

    private interface ConnectionAware {
        Connection getConnection() throws SQLException;

        Connection getConnection(String username, String password) throws SQLException;
    }
}
