package org.firstinspires.ftc.teamcode.auto;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ActualShooter;
import org.firstinspires.ftc.teamcode.Intake;
import org.firstinspires.ftc.teamcode.SimpleTimer;
import org.firstinspires.ftc.teamcode.Spinner;

public class AutoShoot {  private final Telemetry telemetry;
    private final ActualShooter shooter;
    private final Spinner roller;
    private final Spinner spinner;
    private final Intake intake;
    private SimpleTimer timer=new SimpleTimer();
    private double launchSpeed;


    AutoShoot(ActualShooter shooter, Spinner roller, Spinner spinner, Intake intake, Telemetry telemetry) {
        this.shooter = shooter;
        this.roller = roller;
        this.spinner = spinner;
        this.intake = intake;
        this.telemetry = telemetry;
    }

    public void setLaunchSpeed(double launchSpeed) {
        this.launchSpeed = launchSpeed;
    }

    public void shoot() {

        shooter.shoot(launchSpeed);

        // feed if up to speed
        if (shooter.isShooterAtRightSpeed(launchSpeed)) {
            roller.start();
            spinner.start();
            intake.start();
        }  else {
            roller.stop();
            spinner.stop();
            intake.stop();
        }
    }

    public void start(double seconds) {
        timer.start(seconds);
    }

    public boolean loop() {
        if (timer.hasElapsed()) {
            shooter.stop();
            roller.stop();
            spinner.stop();
            intake.stop();
            return false;
        }
        else {
            shoot();
            return true;
        }
    }


}
