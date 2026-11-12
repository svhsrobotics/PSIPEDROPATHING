package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;


@TeleOp
public class MotorsTestOne extends LinearOpMode {
    private double denominator;
private Gamepad gamepad = gamepad1;
    public void runOpMode() throws InterruptedException{
        waitForStart();
        DcMotor motor = hardwareMap.get(DcMotor.class,"motor");
        DcMotor leftFront  = hardwareMap.get(DcMotor.class, "leftFront"); //1
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "leftBack"); //3
        DcMotor rightFront  = hardwareMap.get(DcMotor.class, "rightFront"); //2
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "rightBack"); //4
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        while (opModeIsActive()) {
            {

                double y = -gamepad1.left_stick_y;
                double x = gamepad1.left_stick_x * 1;
                double rx = gamepad1.right_stick_x;
                denominator = Math.max(Math.abs(y)+Math.abs(x)+Math.abs(rx),1);
                //
                    leftFront.setPower(y+x+rx/denominator);
                    leftBack.setPower(y-x+rx/denominator);
                    rightFront.setPower(y-x+rx/denominator);
                    rightBack.setPower(y+x-rx/denominator);
                //

            }
            if (gamepad1.x) {
            motor.setPower(0.65);
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
