package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.Servo;
import static org.firstinspires.ftc.teamcode.Constants.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Jarred on 12/10/2016.
 */
@Autonomous(name="Center Goal Auto Delay", group="final")
public class CenterGoalDelay extends LinearOpMode
{
    AutonomousDriveTrain driveTrain;
    BallControl shooter;

    ElapsedTime timer1 = new ElapsedTime();

    public void runOpMode()
    {
        driveTrain = new AutonomousDriveTrain();
        driveTrain.init(this);
        shooter = new BallControl(hardwareMap, telemetry);

        waitForStart();

        float mark2 = (float) .9;
        sleep(10000);
        driveTrain.right(.4295, .5);
        timer1.reset();
        timer1.startTime();

        while(timer1.milliseconds() < 15000)
        {
            shooter.runFlywheel(true);
            shooter.runElevator(false, mark2 );
        }

        shooter.runFlywheel(false);
        shooter.runElevator(true, mark2);

        driveTrain.right(.704, .5);
    }
}
