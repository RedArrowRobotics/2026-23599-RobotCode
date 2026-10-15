

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.OmniDrive;


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
