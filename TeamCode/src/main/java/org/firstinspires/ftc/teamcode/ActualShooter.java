package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ActualShooter {
    private DcMotorEx shooter = null;
    private double ticksPerSec = 2800;
    private Telemetry telemetry = null;
    ActualShooter(HardwareMap hardwareMap, Telemetry telemetry){
        shooter = hardwareMap.get(DcMotorEx.class, "shooter" ); //port 0 Expansion hub
        shooter.setDirection(DcMotor.Direction.REVERSE);
        shooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.telemetry =telemetry;
    }
    void shoot( double speed) {
       shooter.setVelocity(speed*ticksPerSec);
    }

    boolean isShooterAtRightSpeed(double speed) {
        double actualSpeed = shooter.getVelocity();
        double wantedSpeed = speed*ticksPerSec;
        telemetry.addData("Percent",actualSpeed/wantedSpeed);
        return (wantedSpeed*0.99 <= actualSpeed) && (actualSpeed <= wantedSpeed*1.01);
    }

    void stop() {
        shooter.setPower(0);
    }
}
//Maximum speed is 2800 ticks per second.