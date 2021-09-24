package com.sunanda;

/**
 * author:-Sunanda
 * Date:-22/09/2021
 */

public class StopWatch {
    /**
     * The time the stop watch was last started.
     */
    private long startTime;

    /**
     * The time elapsed before the current
     */
    private long previousElapsedTime;

    /**
     * Whether the stop watch is currently running or not.
     */
    private boolean isRunning;

    public void start() {
        synchronized (this) {
            startTime = System.currentTimeMillis();
            isRunning = true;
        }
    }

    public void pause() {
        synchronized (this) {
            previousElapsedTime += System.currentTimeMillis() - startTime;
            isRunning = false;
        }
    }
    public void reset() {
        synchronized (this) {
            startTime = 0;
            previousElapsedTime = 0;
            isRunning = false;
        }
    }
    public final long getElapsedTime() {
        synchronized (this) {
            long currentElapsedTime = 0;
            if (isRunning) {
                currentElapsedTime = System.currentTimeMillis() - startTime;
            }
            return previousElapsedTime + currentElapsedTime;
        }
    }

    @Override
    public String toString() {
        return String.format("%d millis", getElapsedTime());
    }
}
class Test
{
    public static void main(String[] args)
    {
        StopWatch ob=new StopWatch();
        ob.start();
        ob.pause();
        ob.reset();
        long t=ob.getElapsedTime();
        System.out.println("Elapsed Time is:"+t);
        System.out.println("Elapsed Time  in string format is:"+ob.toString());
    }
}