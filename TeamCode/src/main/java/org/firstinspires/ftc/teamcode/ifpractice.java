package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous
public class ifpractice extends OpMode {

    @Override
    public void init () {

    }

    @Override
    public void loop() {
        boolean aButton = gamepad1.a;

        if (aButton) {
            telemetry.addData("A Button State", "Pressed!");
        }
        else {
            telemetry.addData("A Button State", "NOT PRESSED!]:");
        }
        telemetry.addData("A Button State", aButton);

        double leftY = gamepad1.left_stick_y;

        if (leftY < 0) {
            telemetry.addData("Left Stick","Is Negative");
        } else if (leftY > 0) {
            telemetry.addData("Left Stick", "Is Greater Than 0");
        }
        else {
            telemetry.addData("Left Stick", "Is Positive!");
        }
        telemetry.addData("Left Stick Value", leftY);
    }
}
