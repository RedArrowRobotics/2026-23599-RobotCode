//TODO make distance actually in inches
//TODO make it stop if values are bad.

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
        // construct AutoOmniDrive object here
        AutoOmniDrive autoOmniDrive = new AutoOmniDrive(omniDrive, 1, 3, telemetry);

        waitForStart();

        // call 'start' on the AutoOmniDrive object
        autoOmniDrive.start();

        while (opModeIsActive()) {
            // call the 'loop' function on the AutoOmniDrive object
            autoOmniDrive.loop();
            telemetry.update();

        }
    }

}
