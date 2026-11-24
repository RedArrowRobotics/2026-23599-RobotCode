package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Spinner {

    private CRServo spinner = null;
    private double spinnerSpeed = 0;

    public Spinner(HardwareMap hardwareMap, String name, double spinnerSpeed) {
        spinner = hardwareMap.get(CRServo.class, name);
        spinner.setDirection(CRServo.Direction.FORWARD);
        this.spinnerSpeed = spinnerSpeed;
    }

    public void start() {
        spinner.setPower(spinnerSpeed);
    }
    public void stop() {
        spinner.setPower(0);
    }

    public void reverse(){
        spinner.setPower(-0.5*spinnerSpeed);
    }





    }




