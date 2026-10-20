package org.firstinspires.ftc.teamcode;


public class SimpleTimer {
    long endTime;
    long startTime;
    TimerState running = TimerState.UNSTARTED;

    enum TimerState {
        UNSTARTED,
        STARTED,
        FINISHED,
    }

    public SimpleTimer() {
    }

    public void start(double seconds) {
        if (running == TimerState.UNSTARTED) {
            startTime = System.currentTimeMillis();
            endTime = Math.round(System.currentTimeMillis() + seconds * 1000);
            running = TimerState.STARTED;
        }
    }

    public void reset() {
        running = TimerState.UNSTARTED;
    }

    public boolean isRunning() {
        return running == TimerState.STARTED;
    }

    public double getTime() {
        return (System.currentTimeMillis() - startTime)/1000.0;
    }

    public boolean hasElapsed() {
        if (running == TimerState.FINISHED) {
            return true;
        } else if (running == TimerState.UNSTARTED) {
            return false;
        } else {
            if (System.currentTimeMillis() > endTime) {
                running = TimerState.FINISHED;
                return true;
            } else {
                return false;
            }
        }
    }
}
