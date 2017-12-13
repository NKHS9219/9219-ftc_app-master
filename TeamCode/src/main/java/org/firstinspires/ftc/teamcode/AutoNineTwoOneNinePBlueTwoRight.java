package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name="AutoNineTwoOneNinePRedTwoRight", group="Master")
public class AutoNineTwoOneNinePBlueTwoRight extends LinearOpMode {

    private DcMotor RB;
    private DcMotor RF;
    private DcMotor LF;
    private DcMotor LB;
    private DcMotor CB;
    private DcMotor GM;
    private Servo RG;
    private Servo LG;

    public void runOpMode() throws InterruptedException {

        LF = hardwareMap.get(DcMotor.class, "LFMotor");
        RF = hardwareMap.get(DcMotor.class, "RFMotor");
        LB = hardwareMap.get(DcMotor.class, "LBMotor");
        RB = hardwareMap.get(DcMotor.class, "RBMotor");
        CB = hardwareMap.get(DcMotor.class, "CBMotor");
        GM = hardwareMap.get(DcMotor.class, "GMMotor");
        RG = hardwareMap.get(Servo.class, "RGServo");
        LG = hardwareMap.get(Servo.class, "LGServo");

        LF.setDirection(DcMotor.Direction.FORWARD);
        RF.setDirection(DcMotor.Direction.REVERSE);
        RB.setDirection(DcMotor.Direction.REVERSE);
        LB.setDirection(DcMotor.Direction.FORWARD);
        CB.setDirection(DcMotor.Direction.REVERSE);
        GM.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {


            TankClose();
            Thread.sleep(1000);
            TankLift(); //fix
            TankForward(-0.5);
            Thread.sleep(1250);
            TankTurnLeft(-0.25);
            Thread.sleep(1085);
            TankForward(-0.25);
            Thread.sleep(1000);
            TankUnLift();
            Thread.sleep(1000);
            TankOpen();
            Thread.sleep(1000);
            TankBack(-0.25);
            Thread.sleep(500);
            stop();
        }
    }

    public void TankForward(double power) {
        RB.setPower(power);
        RF.setPower(power);
        LB.setPower(power);
        LF.setPower(power);
    }


    public void TankStop()  {
        RB.setPower(0);
        RF.setPower(0);
        LB.setPower(0);
        LF.setPower(0);
        CB.setPower(0);
    }

    public void TankBack(double power) {
        RB.setPower(-power);
        RF.setPower(-power);
        LB.setPower(-power);
        LF.setPower(-power);
    }


    public void TankStrafeRight(double power) {
        CB.setPower(-power);
    }

    public void TankStrafeLeft(double power)  {
        CB.setPower(power);
        RB.setPower(0);
        RF.setPower(0);
        LF.setPower(0);
        LB.setPower(0);
    }

    public void TankTurnRight(double power)  {
        RB.setPower(-power);
        RF.setPower(-power);
        LF.setPower(power);
        LB.setPower(power);
    }


    public void TankTurnLeft (double power)  {
        RB.setPower(power);
        RF.setPower(power);
        LF.setPower(-power);
        LB.setPower(-power);
    }

    public void TankClose () {
        RG.setPosition(0.3);
        LG.setPosition(0.5);
    }

    public void TankOpen () {
        RG.setPosition(0.8);
        LG.setPosition(0.1);
    }

    public void TankLift () {
        int position = GM.getCurrentPosition();
        telemetry.addData("GMEncoder", position);
        GM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        GM.setTargetPosition(1);
        GM.setPower(-0.25);
        GM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void TankUnLift () {
        int position = GM.getCurrentPosition();
        telemetry.addData("GMEncoder", position);
        GM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        GM.setTargetPosition(0);
        GM.setPower(0.15);
        GM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}
