package org.firstinspires.ftc.teamcode;


public class SimpleTimer {
    long endTime;
    TimerState running = TimerState.UNSTARTED;

    enum TimerState {
        UNSTARTED,
        STARTED,
        FINISHED,
    }

    SimpleTimer() {
    }

    void start(double seconds) {
        if (running == TimerState.UNSTARTED) {
            endTime = Math.round(System.currentTimeMillis() + seconds * 1000);
            running = TimerState.STARTED;
        }
    }

    void reset() {
        running = TimerState.UNSTARTED;
    }

    boolean isRunning() {
        return running == TimerState.STARTED;
    }

    boolean hasElapsed() {
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
