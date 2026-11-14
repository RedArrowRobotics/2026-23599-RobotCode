package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.OmniDrive;


@Autonomous(name="LeaveAndPark", group="Robot")
public class NewAutonomous extends LinearOpMode {

    private OmniDrive omniDrive = null;

    @Override
    public void runOpMode() {
        omniDrive = new OmniDrive(hardwareMap, telemetry);
        // construct AutoOmniDrive object here
        AutoOmniDrive autoOmniDrive = new AutoOmniDrive(omniDrive, 19, 1, telemetry);
        //AutoOmniStrafe autoOmniStrafe = new AutoOmniStrafe(omniDrive, 38, 2, telemetry);
        //AutoOmniTurn autoOmniTurn = new AutoOmniTurn(omniDrive, 38, 2, telemetry);

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
