package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name="AutoNineTwoOneNine", group="Master")
public class AutoNineTwoOneNine extends LinearOpMode {

    private DcMotor RB;
    private DcMotor RF;
    private DcMotor LF;
    private DcMotor LB;
    private DcMotor CB;
    private Servo RG;
    private Servo LG;
    private ColorSensor CS;
    private String colorFound;

    public void runOpMode() throws InterruptedException {

        LF = hardwareMap.get(DcMotor.class, "LFMotor");
        RF = hardwareMap.get(DcMotor.class, "RFMotor");
        LB = hardwareMap.get(DcMotor.class, "LBMotor");
        RB = hardwareMap.get(DcMotor.class, "RBMotor");
        CB = hardwareMap.get(DcMotor.class, "CBMotor");
        RG = hardwareMap.get(Servo.class, "RGServo");
        LG = hardwareMap.get(Servo.class, "LGServo");CS = hardwareMap.get(ColorSensor.class, "CSensor"); //change to left and right color sensors listed in the electronics layout

        LF.setDirection(DcMotor.Direction.FORWARD);
        RF.setDirection(DcMotor.Direction.REVERSE);
        RB.setDirection(DcMotor.Direction.REVERSE);
        LB.setDirection(DcMotor.Direction.FORWARD);
        CB.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("color red: ", CS.red());
            telemetry.addData("color blue: ", CS.blue());
        }
    }

    private void TankForward(double power) {
        RB.setPower(-power);
        RF.setPower(-power);
        LB.setPower(power);
        LF.setPower(power);
    }


    public void TankBack(double power) {
        RB.setPower(power);
        RF.setPower(power);
        LB.setPower(-power);
        LF.setPower(-power);
    }


    private void TankStrafeRight(double power) {
        CB.setPower(-power);
    }


    private void TankStrafeLeft(double power)  {
        CB.setPower(power);
    }


    private void TankTurnRight(double power)  {
        RB.setPower(-power);
        RF.setPower(-power);
        LF.setPower(power);
        LB.setPower(power);
    }


    private void TankTurnLeft (double power)  {
        RB.setPower(power);
        RF.setPower(power);
        LF.setPower(-power);
        LB.setPower(-power);
    }
    }