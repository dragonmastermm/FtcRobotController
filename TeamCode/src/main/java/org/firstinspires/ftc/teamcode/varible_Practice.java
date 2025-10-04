package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class varible_Practice extends OpMode {

    public void init() {
        int team_Number = 21537;
        double motor_Speed =0.75;
        boolean claw_Closed = true;
        String name = "team charcole";
        int motor_Angle = 90;

        telemetry.addData("team number", team_Number);
        telemetry.addData("motor speed", motor_Speed);
        telemetry.addData("claw closed", claw_Closed);
        telemetry.addData("belongs to", name);
        telemetry.addData("motor angle", motor_Angle);
    }

    @Override
    public void loop() {
        telemetry.update();
    }
}
