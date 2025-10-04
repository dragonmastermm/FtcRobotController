package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous
public class helloWorld extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Hello", "team 21537! who am I and what am I made for?");
    }

    @Override
    public void loop(){
    }

    // single line comment
    /*
    1. hello world, change the the telemetry data to hello : "your name"
     */
}

