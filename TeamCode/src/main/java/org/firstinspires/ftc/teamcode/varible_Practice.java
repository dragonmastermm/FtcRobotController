package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class varible_Practice extends OpMode {

    public void init() {
        int team_Number = 21537;
        double motor_Speed =0.75;
        boolean claw_Closed = true;

        telemetry.addData("team number", team_Number);
        telemetry.addData("motor speed", motor_Speed);
        telemetry.addData("claw closed", claw_Closed);
        String name = "team charcole";
        telemetry.addData("belongs to team cha", name);
    }

    @Override
    public void loop() {
        telemetry.update();
    }
}
