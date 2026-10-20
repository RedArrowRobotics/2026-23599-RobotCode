package org.firstinspires.ftc.teamcode.auto;

import org.firstinspires.ftc.teamcode.OmniDrive;
import org.firstinspires.ftc.teamcode.SimpleTimer;

public class AutoOmniDrive {
    private SimpleTimer timer=new SimpleTimer();
    private double distance;
    private double time;

    private double T1;
    private double T2;
    private OmniDrive chassis;

    AutoOmniDrive(OmniDrive chassis, double distance, double time) {
        this.chassis = chassis;
        this.distance = distance;
        this.time = time;
        double A = 2*distance/0.8-time;
        T1 = (time-A)/2;
        T2 = time-T1;
    }

    public void start(){
      timer.start(time);
    }

    public boolean loop() {
        double cv;
        double slope = 0.8/T1;
        if(timer.getTime() < T1){
            cv = timer.getTime()*slope;
            chassis.drive(cv, 0, 0);
            return false;
        }else if(timer.getTime() < T2){
            cv = 0.8;
            chassis.drive(cv, 0, 0);
            return false;
        }else if(timer.getTime() < time){
            cv = (timer.getTime()-T2)*-slope+0.8;
            chassis.drive(cv, 0, 0);
            return false;
        }else{
            cv = 0;
            chassis.drive(cv, 0, 0);
            return true;
        }

    }
}
