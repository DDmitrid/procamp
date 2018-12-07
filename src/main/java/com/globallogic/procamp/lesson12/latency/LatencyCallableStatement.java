package com.globallogic.procamp.lesson12.latency;

import java.sql.CallableStatement;

import lombok.experimental.Delegate;


public class LatencyCallableStatement extends LatencyPreparedStatement implements CallableStatement {
    @Delegate(excludes = ExecutionAware.class)
    private final CallableStatement realCallableStatement;

    public LatencyCallableStatement(CallableStatement realCallableStatement, LatencySimulator latencySimulator) {
        super(realCallableStatement, latencySimulator);
        this.realCallableStatement = realCallableStatement;
    }
}
