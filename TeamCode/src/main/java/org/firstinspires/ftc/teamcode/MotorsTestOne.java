package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp
public class MotorsTestOne extends LinearOpMode {
private Gamepad gamepad = gamepad1;
    public void runOpMode() throws InterruptedException{
        waitForStart();
        DcMotor motor = hardwareMap.get(DcMotor.class,"motor");
        //up dpad motor spins one way
        //down dpad motor spins another way
        while (opModeIsActive()) {
            if (gamepad1.x) {
            motor.setPower(0.3);
            }
            else
            {
                if (gamepad1.y) {
                    motor.setPower(-0.3);
            }
                else {
                   motor.setPower(0);
                }
            }
        }
    }
}
