package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name = "TwoControllerTeleOpNineTwoOneNine", group = "Master")
public class TwoControllerTeleOpNineTwoOneNine extends LinearOpMode {

    private DcMotor RB; 
    private DcMotor RF; 
    private DcMotor LF; 
    private DcMotor LB; 
    private DcMotor GM; 
    private Servo RG; 
    private Servo LG; 

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        LF = hardwareMap.get(DcMotor.class,"LFMotor");
        RF = hardwareMap.get(DcMotor.class,"RFMotor");
        LB = hardwareMap.get(DcMotor.class,"LBMotor");
        RB = hardwareMap.get(DcMotor.class,"RBMotor");
        GM = hardwareMap.get(DcMotor.class,"GMMotor");
        RG = hardwareMap.get(Servo.class,"RGServo");
        LG = hardwareMap.get(Servo.class,"LGServo");

        LF.setDirection(DcMotor.Direction.FORWARD);
        RF.setDirection(DcMotor.Direction.REVERSE);
        RB.setDirection(DcMotor.Direction.REVERSE);
        LB.setDirection(DcMotor.Direction.FORWARD);
        GM.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {

            double RFpower = (gamepad1.left_stick_y + gamepad1.right_stick_x);
            double RBpower = (gamepad1.left_stick_y + gamepad1.right_stick_x);
            double LFpower = (gamepad1.left_stick_y - gamepad1.right_stick_x);
            double LBpower = (gamepad1.left_stick_y - gamepad1.right_stick_x);
            double GMpower = (gamepad2.left_stick_y);

            RFpower = Range.clip(RFpower,-1, 1);
            RBpower = Range.clip(RBpower,-1, 1);
            LFpower = Range.clip(LFpower,-1, 1);
            LBpower = Range.clip(LBpower,-1, 1);
            GMpower = Range.clip(GMpower,-0.5, 0.25);

            GM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            LF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            LB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

            LF.setPower(LFpower);
            RF.setPower(RFpower);
            LB.setPower(LBpower);
            RB.setPower(RBpower);
            GM.setPower(GMpower);

            if (gamepad2.b) {
                RG.setPosition(0.7);
                LG.setPosition(0.3);

            }

            if (gamepad2.a) {
                RG.setPosition(0.2);
                LG.setPosition(0.7);
            
            }
                
            if (gamepad2.y) {
                RG.setPosition(0.4);
                LG.setPosition(0.5);
                
            }
            
                
            
            
            if (gamepad1.y) {
                stop();
                
            }
        }
    }
}
