package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ActualShooter {
    private DcMotorEx shooter = null;
    private double ticksPerSec = 2800;
    ActualShooter(HardwareMap hardwareMap){
        shooter = hardwareMap.get(DcMotorEx.class, "shooter" ); //port 0 Expansion hub
        shooter.setDirection(DcMotor.Direction.REVERSE);
        shooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    void shoot( double speed) {
       shooter.setVelocity(speed*ticksPerSec);
    }
    void stop() {
        shooter.setPower(0);
    }
}
//Maximum speed is 2800 ticks per second.