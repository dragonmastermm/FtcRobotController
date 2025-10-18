package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Newer_mecinum extends OpMode {

    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;
    private DcMotor shooterLeft;

    @Override
    public void init() {
        // Initialize motors
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        shooterLeft = hardwareMap.get(DcMotor.class, "shooterLeft");

        // Reverse right side motors if needed
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        // Mecanum drive calculations
        double y = -gamepad1.left_stick_y; // forward/backward
        double x = gamepad1.left_stick_x;  // strafe
        double rx = gamepad1.right_stick_x; // rotation

        double frontLeftPower = y + x + rx;
        double backLeftPower = y - x + rx;
        double frontRightPower = y - x - rx;
        double backRightPower = y + x - rx;

        // Normalize the wheel speeds
        double max = Math.max(
                Math.max(Math.abs(frontLeftPower), Math.abs(backLeftPower)),
                Math.max(Math.abs(frontRightPower), Math.abs(backRightPower))
        );
        if (max > 1.0) {
            frontLeftPower /= max;
            backLeftPower /= max;
            frontRightPower /= max;
            backRightPower /= max;
        }

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);

        // Shooter control
        shooterLeft.setPower(gamepad1.right_trigger);

        telemetry.addData("FL", frontLeftPower);
        telemetry.addData("BL", backLeftPower);
        telemetry.addData("FR", frontRightPower);
        telemetry.addData("BR", backRightPower);
        telemetry.addData("Shooter", shooterLeft.getPower());
    }
}

