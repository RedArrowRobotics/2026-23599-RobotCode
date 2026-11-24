//TODO make distance actually in inches
//TODO make it stop if values are bad.

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.OmniDrive;


@Autonomous(name="Secondary autonomous", group="Robot")
public class AutoDriveForward extends LinearOpMode {

    private OmniDrive omniDrive = null;

    @Override
    public void runOpMode() {
        omniDrive = new OmniDrive(hardwareMap, telemetry);
        // construct AutoOmniDrive object here//
        AutoOmniStrafe autoOmniStrafe = new AutoOmniStrafe(omniDrive, -2.5, 0.1, telemetry);

        AutoOmniDrive autoOmniDrive = new AutoOmniDrive(omniDrive, 19, 1, telemetry);
        //AutoOmniStrafe autoOmniStrafe = new AutoOmniStrafe(omniDrive, 38, 2, telemetry);
        //AutoOmniTurn autoOmniTurn = new AutoOmniTurn(omniDrive, 38, 2, telemetry);

        waitForStart();

        autoOmniStrafe.start();
        boolean finished = false;
        while (opModeIsActive() && !finished) {
            // call the 'loop' function on the AutoOmniDrive object
            finished = autoOmniStrafe.loop();
            telemetry.update();

        }
        // call 'start' on the AutoOmniDrive object
        autoOmniDrive.start();

        while (opModeIsActive()) {
            // call the 'loop' function on the AutoOmniDrive object
            autoOmniDrive.loop();
            telemetry.update();

        }
    }

}
