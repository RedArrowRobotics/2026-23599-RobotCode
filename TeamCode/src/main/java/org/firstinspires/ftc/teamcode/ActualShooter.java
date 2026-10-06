package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ActualShooter {
    private DcMotor shooter = null;
    ActualShooter(HardwareMap hardwareMap){
        //shooter = hardwareMap.get(DcMotor.class, "shooter" ); //port 0 Expansion hub
        //shooter.setDirection(DcMotor.Direction.FORWARD); //TODO verify direction
    }
    void shoot( double speed) {
       //shooter.setPower(speed);
    }
    void stop() {
        //shooter.setPower(0);
    }
}
