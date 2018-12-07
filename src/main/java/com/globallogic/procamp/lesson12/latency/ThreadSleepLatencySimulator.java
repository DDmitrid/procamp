package com.globallogic.procamp.lesson12.latency;


public class ThreadSleepLatencySimulator implements LatencySimulator {
    private final long extraLatency;

    public ThreadSleepLatencySimulator(long extraLatency) {
        this.extraLatency = extraLatency;
    }

    @Override
    public void simulate() {
        try {
            Thread.sleep(extraLatency);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
