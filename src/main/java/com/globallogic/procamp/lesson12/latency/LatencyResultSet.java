package com.globallogic.procamp.lesson12.latency;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.experimental.Delegate;


public class LatencyResultSet implements ResultSet {

    @Delegate(excludes = Res.class)
    private final ResultSet realResultSet;

    public LatencyResultSet(ResultSet realResultSet) {
        this.realResultSet = realResultSet;
    }

    @Override
    public boolean next() throws SQLException {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return realResultSet.next();
    }

    @Override
    public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
        return realResultSet.getObject(columnIndex, type);
    }

    @Override
    public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
        return realResultSet.getObject(columnLabel, type);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return realResultSet.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return realResultSet.isWrapperFor(iface);
    }

    private interface Res {
        boolean next() throws SQLException;

        <T> T getObject(int columnIndex, Class<T> type);

        <T> T getObject(String columnLabel, Class<T> type);

        <T> T unwrap(Class<T> iface) throws SQLException;

        boolean isWrapperFor(Class<?> iface);
    }
}
