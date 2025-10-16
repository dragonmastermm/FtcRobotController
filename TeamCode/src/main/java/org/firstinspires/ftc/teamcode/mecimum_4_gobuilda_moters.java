package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class mecimum_4_gobuilda_moters extends OpMode {

    private DcMotor intakeMotor;
    private DcMotor FrontLeft;
    private DcMotor backLeft;
    private DcMotor FrontRight;
    private DcMotor backRight;
    private double strafe;
    private double forward;
    private double rotate;{

        strafe = gamepad1.left_stick_x;
        forward = gamepad1.left_stick_y;
        rotate = gamepad1.right_stick_x;
        mecanumDrive(strafe, forward, rotate);
    }

    @Override
    public void init() {
        intakeMotor = hardwareMap.get(DcMotor.class, "intake");
        FrontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        FrontLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            intakeMotor.setPower(1.0); // Intake in
        } else {
            intakeMotor.setPower(0.0); // Stop
        }
    }


    public void mecanumDrive(double strafe, double forward, double rotate) {
        double frontLeftPower = (-forward) + strafe + rotate;
        double backLeftPower = (-forward) - strafe + rotate;
        double frontRightPower = (-forward) - strafe - rotate;
        double backRightPower = (-forward) + strafe - rotate;

        // Normalize the wheel speeds
        double maxPower = Math.max(Math.abs(frontLeftPower), Math.max(Math.abs(backLeftPower),
                Math.max(Math.abs(frontRightPower), Math.abs(backRightPower))));
        if (maxPower > 1.0) {
            frontLeftPower /= maxPower;
            backLeftPower /= maxPower;
            frontRightPower /= maxPower;
            backRightPower /= maxPower;
        }

        FrontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        FrontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);
    }
}
