package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Spinner {

    private CRServo spinner = null;
    private double spinnerSpeed = 0;

    Spinner(HardwareMap hardwareMap, String name, double spinnerSpeed) {
        spinner = hardwareMap.get(CRServo.class, name);
        spinner.setDirection(CRServo.Direction.FORWARD);
        this.spinnerSpeed = spinnerSpeed;
    }

    void start() {
        spinner.setPower(spinnerSpeed);
    }
    void stop() {
        spinner.setPower(0);
    }

    void reverse(){
        spinner.setPower(-0.5*spinnerSpeed);
    }





    }




