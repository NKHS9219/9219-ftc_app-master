package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name = "TwoControllerTeleOpNineTwoOneNine", group = "Master")
public class TwoControllerTeleOpNineTwoOneNine extends LinearOpMode {

    private DcMotor RB; //1.0
    private DcMotor RF; //1.1
    private DcMotor LF; //1.2
    private DcMotor LB; //1.3
    private DcMotor CB; //2.0
    private DcMotor GM; //2.1
    private Servo RG; //1.0
    private Servo LG; //1.1

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        LF = hardwareMap.get(DcMotor.class,"LFMotor");
        RF = hardwareMap.get(DcMotor.class,"RFMotor");
        LB = hardwareMap.get(DcMotor.class,"LBMotor");
        RB = hardwareMap.get(DcMotor.class,"RBMotor");
        CB = hardwareMap.get(DcMotor.class,"CBMotor");
        GM = hardwareMap.get(DcMotor.class,"GMMotor");
        RG = hardwareMap.get(Servo.class,"RGServo");
        LG = hardwareMap.get(Servo.class,"LGServo");

        LF.setDirection(DcMotor.Direction.FORWARD);
        RF.setDirection(DcMotor.Direction.REVERSE);
        RB.setDirection(DcMotor.Direction.REVERSE);
        LB.setDirection(DcMotor.Direction.FORWARD);
        CB.setDirection(DcMotor.Direction.REVERSE);
        GM.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {

            double RFpower = (gamepad1.left_stick_y + gamepad1.right_stick_x);
            double RBpower = (gamepad1.left_stick_y + gamepad1.right_stick_x);
            double LFpower = (gamepad1.left_stick_y - gamepad1.right_stick_x);
            double LBpower = (gamepad1.left_stick_y - gamepad1.right_stick_x);
            double CBpower = (gamepad1.left_stick_x);
            double GMpower = (gamepad2.right_stick_y);

            RFpower = Range.clip(RFpower,-0.5, 0.5);
            RBpower = Range.clip(RBpower,-0.5, 0.5);
            LFpower = Range.clip(LFpower,-0.5, 0.5);
            LBpower = Range.clip(LBpower,-0.5, 0.5);
            CBpower = Range.clip(CBpower,-0.5, 0.5);
            GMpower = Range.clip(GMpower,-0.5, 0.5);

            int position = GM.getCurrentPosition();
            telemetry.addData("GMEncoder", position);
            GM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            LF.setPower(LFpower);
            RF.setPower(RFpower);
            LB.setPower(LBpower);
            RB.setPower(RBpower);
            CB.setPower(CBpower);
            GM.setPower(GMpower);

            if (gamepad2.b) {
                RG.setPosition(0.5);
                LG.setPosition(0.3);

            }

            if (gamepad2.a) {
                RG.setPosition(0.1);
                LG.setPosition(0.7);

            }
        }
    }
}