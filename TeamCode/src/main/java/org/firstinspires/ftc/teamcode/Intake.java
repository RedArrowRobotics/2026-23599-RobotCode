package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotor intake = null;

    private double intakeSpeed = 0.9;

    public Intake(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotor.class, "intake"); //port 0 Expansion hub
        intake.setDirection(DcMotor.Direction.REVERSE); //TODO verify direction
    }
    public void start() {
        intake.setPower(intakeSpeed);
    }
    public void reverse() {
        intake.setPower(-intakeSpeed);
    }
    public void stop() {
        intake.setPower(0);
    }


}
