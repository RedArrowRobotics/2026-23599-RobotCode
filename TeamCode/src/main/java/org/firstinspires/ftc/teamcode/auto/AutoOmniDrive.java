package org.firstinspires.ftc.teamcode.auto;

import org.firstinspires.ftc.teamcode.SimpleTimer;

public class AutoOmniDrive {
    private SimpleTimer timer=new SimpleTimer();
    private double forward;
    private double time;

    AutoOmniDrive(double forward, double time) {
        this.forward = forward;
        this.time = time;
    }

    public boolean loop() {
        return true;
    }
}
