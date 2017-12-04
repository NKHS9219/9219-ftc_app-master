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
    private ColorSensor RC;
    private String colorFound;

    public void runOpMode() throws InterruptedException {

        LF = hardwareMap.get(DcMotor.class, "LFMotor");
        RF = hardwareMap.get(DcMotor.class, "RFMotor");
        LB = hardwareMap.get(DcMotor.class, "LBMotor");
        RB = hardwareMap.get(DcMotor.class, "RBMotor");
        CB = hardwareMap.get(DcMotor.class, "CBMotor");
        GM = hardwareMap.get(DcMotor.class, "GMMotor");
        RG = hardwareMap.get(Servo.class, "RGServo");
        LG = hardwareMap.get(Servo.class, "LGServo");
        RC = hardwareMap.get(ColorSensor.class, "RCSensor");

        LF.setDirection(DcMotor.Direction.FORWARD);
        RF.setDirection(DcMotor.Direction.REVERSE);
        RB.setDirection(DcMotor.Direction.REVERSE);
        LB.setDirection(DcMotor.Direction.FORWARD);
        CB.setDirection(DcMotor.Direction.REVERSE);
        GM.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("color red: ", RC.red());
            telemetry.addData("color blue: ", RC.blue());
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