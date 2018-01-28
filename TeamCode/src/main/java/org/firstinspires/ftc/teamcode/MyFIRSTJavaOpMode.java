package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class MyFIRSTJavaOpMode extends LinearOpMode {
    private DcMotor right;
    private DcMotor left;

    @Override
    public void runOpMode() {

        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        double tgtPower = 0;

        while (opModeIsActive()) {
            tgtPower = -this.gamepad1.left_stick_y;
            left.setPower(-tgtPower);
            right.setPower(tgtPower);
            telemetry.addData("Target Power", tgtPower);
            telemetry.addData("Left Motor Power", left.getPower());
            telemetry.addData("Right Motor Power", right.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}