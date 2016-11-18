package org.firstinspires.ftc.teamcode;

/**
 * Created by Jarred on 10/30/2016.
 */

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "forkTest", group = "Concept")
public class forkTEst extends OpMode {

    DcMotor motor;

    int encode;

    public void init()
    {

        motor = hardwareMap.dcMotor.get("motor");
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void loop()
    {
        //-12278
        telemetry.update();
        telemetry.addData("rotations ", motor.getCurrentPosition());
        telemetry.addData("direction is", motor.getPower());
        //change the checksum ASAP
        if(gamepad1.left_stick_y >.5   ){
            motor.setPower(.75);

        }
        else if(gamepad1.left_stick_y < -.5 ){
            motor.setPower(-.75);
        }
        else{
            motor.setPower(0);
        }

    }

}

