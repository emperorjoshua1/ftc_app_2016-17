package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Owner on 11/4/2016. (0x3a)
 */
@TeleOp(name = "Sensor: MR FloorColor", group = "Sensor")
public class SensorMRColorFloor extends LinearOpMode{

    ColorSensor colorSensor;    // Hardware Device Object
    float hsvValuesFloor[] = {0F,0F,0F};


    @Override
        public void runOpMode() {


        // values is a reference to the hsvValuesFloor array.
        final float values[] = hsvValuesFloor;

        ElapsedTime opmodeRunTime = new ElapsedTime();
        colorSensor = hardwareMap.colorSensor.get("FloorSensor");
       colorSensor.setI2cAddress(I2cAddr.create8bit(58));

        waitForStart();
        while (opModeIsActive()) {

            String currentcolor = getFloorColor();

            // send the info back to driver station using telemetry function.
            telemetry.addData("Running Time", opmodeRunTime.seconds());
            telemetry.addData("Clear", colorSensor.alpha());
            telemetry.addData("Red", colorSensor.red());
            telemetry.addData("Green", colorSensor.green());
            telemetry.addData("Blue ", colorSensor.blue());
            telemetry.addData("Hue", hsvValuesFloor[0]);
            telemetry.addData("Saturation", hsvValuesFloor[1]);
            telemetry.addData("floor color", colorSensor);
            telemetry.addData("value", hsvValuesFloor[2]);
            telemetry.addData("curent color", currentcolor);
            telemetry.update();
        }
    }
            public String getFloorColor(){
        Color.RGBToHSV(colorSensor.red() * 8, colorSensor.green() * 8, colorSensor.blue() * 8, hsvValuesFloor);
        colorSensor.setI2cAddress(I2cAddr.create8bit(58));
        String currentcolor = "not white";

        if (hsvValuesFloor[0] == 60 && hsvValuesFloor[1] == 1) {
            currentcolor = "white";
        }

        if (hsvValuesFloor[0] < 60) {
            currentcolor = "not white";
        }

        if (hsvValuesFloor[0] > 60) {
            currentcolor = "not white";
        }

        return currentcolor;
    }
}