package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Jarred on 10/18/2016.
 */

public class CompTele extends OpMode {
    Drivetrain drivetrain;



    LargeBallLifter yogaLift;

    BallControlInterface ballControl;


    ModernRoboticsI2cGyro gyro;

    int rotation = 0;




    public void init()
    {
        drivetrain = new Drivetrain(hardwareMap, telemetry);

        gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("gyro");

        gyro.calibrate();

        try
        {
            // make sure the gyro is calibrated.
            while (gyro.isCalibrating())
            {
                Thread.sleep(50);
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        gyro.resetZAxisIntegrator();

    }

    public void loop()
    {
        float stickX = gamepad1.left_stick_x; // Stick position (Absolute heading)
        float stickY = gamepad1.left_stick_y; // Each is in range -1 to 1
        float stickRot = gamepad1.right_stick_x / 2f; //Used to rotate the robot;
        rotation = gyro.getHeading();
        drivetrain.oneStickLoop(stickX, stickY, stickRot, rotation);





        yogaLift.openLift();





    }
}
