package org.firstinspires.ftc.teamcode.auto;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.OmniDrive;
import org.firstinspires.ftc.teamcode.SimpleTimer;

public class AutoOmniStrafe {
    private final Telemetry telemetry;
    private SimpleTimer timer=new SimpleTimer();
    private double distance;
    private double time;

    private double T1;
    private double T2;
    private OmniDrive chassis;
    private double topSpeed = 0.6;

    AutoOmniStrafe(OmniDrive chassis, double distance, double time, Telemetry telemetry) {
        this.chassis = chassis;
        this.distance = distance/62;
        //minimum distance is ts/2*62; maximum distance is time*speed*62
        //distance=1 causes robot to move 62 inches. 5ft 2in. 5.167ft
        this.time = time;
        this.telemetry = telemetry;
        double A = 2*this.distance/topSpeed-time;
        T1 = (time-A)/2;
        T2 = time-T1;
        telemetry.addData("A",A);
        telemetry.addData("T1",T1);
        telemetry.addData("T2",T2);

    }

    public void start(){
      timer.start(time);
    }

    public boolean loop() {
        double cv;
        double slope = topSpeed/T1;
        if(timer.getTime() < T1){
            cv = timer.getTime()*slope;
            chassis.drive(0, cv, 0);
        }else if(timer.getTime() < T2){
            cv = topSpeed;
            chassis.drive(0, cv, 0);
        }else if(timer.getTime() < time){
            cv = (timer.getTime()-T2)*-slope+topSpeed;
            chassis.drive(0, cv, 0);
        }else{
            cv = 0;
            chassis.drive(0, cv, 0);
            return true;
        }

        //telemetry.addData("cv",cv);
        return false;
    }
}
