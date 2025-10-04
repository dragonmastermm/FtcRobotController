package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class gamepadpractice extends OpMode {

    @Override
    public void init () {

    }

    @Override
    public void loop() {
        // runs 50x* a second
        double speedfoward = gamepad2.right_stick_y / 2;
        double speedturn = gamepad1.left_stick_x / 2;
        double straithspeed = speedfoward + (gamepad2.right_stick_x / 2);

        telemetry.addData("x", gamepad1.x);
        telemetry.addData("y", gamepad1.y);
        telemetry.addData("a button", gamepad1.a);
        telemetry.addData("b button", gamepad1.b);
        telemetry.addData("left stick x", speedturn);
        telemetry.addData("right stick x", speedfoward);
        telemetry.addData("right stick y", straithspeed);
        telemetry.addData("left trigger", gamepad1.left_trigger);
        telemetry.addData("right trigger", gamepad1.right_trigger);
        telemetry.addData("left bumper", gamepad1.left_bumper);
        telemetry.addData("right bumper", gamepad1.right_bumper);
        telemetry.update();
    }
}
