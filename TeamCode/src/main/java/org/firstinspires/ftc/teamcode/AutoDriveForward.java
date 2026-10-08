

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;


@Autonomous(name="Auto Drive Forward", group="Robot")
public class AutoDriveForward extends LinearOpMode {

    private OmniDrive omniDrive = null;

    @Override
    public void runOpMode() {
        omniDrive = new OmniDrive(hardwareMap);

        waitForStart();


        while (opModeIsActive()) {
            omniDrive.driveAuto(1);
        }
    }

}
