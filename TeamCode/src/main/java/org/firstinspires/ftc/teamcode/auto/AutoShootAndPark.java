package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.ActualShooter;
import org.firstinspires.ftc.teamcode.Intake;
import org.firstinspires.ftc.teamcode.OmniDrive;
import org.firstinspires.ftc.teamcode.Spinner;


@Autonomous(name="ShootAndPark", group="Robot")
public class AutoShootAndPark extends LinearOpMode {

    private OmniDrive omniDrive = null;
    private ActualShooter shooter = null;
    private  Intake intake =null;
    private Spinner spinner = null;
    private Spinner roller = null;

    @Override
    public void runOpMode() {
        omniDrive = new OmniDrive(hardwareMap, telemetry);
        shooter = new ActualShooter(hardwareMap, telemetry);
        intake = new Intake(hardwareMap);
        spinner = new Spinner(hardwareMap, "Spinner", -0.6);
        roller = new Spinner(hardwareMap, "Roller", -0.8);

        AutoOmniStrafe autoOmniStrafe = new AutoOmniStrafe(omniDrive, -48, 1.5, telemetry);
        AutoOmniDrive autoOmniDrive = new AutoOmniDrive(omniDrive, -96, 3, telemetry);
        AutoShoot autoShoot = new AutoShoot(shooter, roller, spinner, intake, telemetry);
        autoShoot.setLaunchSpeed(ActualShooter.SHORT_SHOOT_SPEED);
        waitForStart();

        // Shoot
        autoShoot.start(4);
        while (opModeIsActive()) {
            // call the 'loop' function on the AutoOmniDrive object
            autoShoot.loop();
            telemetry.update();
        }


        // Strafe Right 48in. (negative)
        autoOmniStrafe.start();
        while (opModeIsActive()) {
            // call the 'loop' function on the AutoOmniDrive object
            autoOmniStrafe.loop();
            telemetry.update();

        }

        // Drive backwards 96in. (negative)
        autoOmniDrive.start();
        while (opModeIsActive()) {
            // call the 'loop' function on the AutoOmniDrive object
            autoOmniDrive.loop();
            telemetry.update();

        }


        // Done!

    }

}
