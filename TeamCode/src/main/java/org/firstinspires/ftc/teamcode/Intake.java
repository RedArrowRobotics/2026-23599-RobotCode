package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotor intakeMotor = null;

    private double intakeSpeed = 0.5;

    Intake(HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intake motor"); //port 0 Expansion hub
        intakeMotor.setDirection(DcMotor.Direction.FORWARD); //TODO verify direction
    }

    void start() {
        intakeMotor.setPower(intakeSpeed);
    }

    void stop() {
        intakeMotor.setPower(0);
    }


}
