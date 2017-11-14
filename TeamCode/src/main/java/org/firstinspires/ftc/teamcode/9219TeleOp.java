package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="9219TeleOp", group="9219Code")
public class 9219TeleOp extends LinearOpMode {

    private DcMotor RB; //1.0
    private DcMotor RF; //1.1
    private DcMotor LF; //1.2
    private DcMotor LB; //1.3
    private DcMotor CB; //2.0

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        LF  = hardwareMap.get(DcMotor.class, "LFMotor");
        RF = hardwareMap.get(DcMotor.class, "RFMotor");
        LB  = hardwareMap.get(DcMotor.class, "LBMotor");
        RB = hardwareMap.get(DcMotor.class, "RBMotor");
        CB = hardwareMap.get(DcMotor.class, "CBMotor");
     
        LF.setDirection(DcMotor.Direction.REVERSE);
        RF.setDirection(DcMotor.Direction.FORWARD);
        RB.setDirection(DcMotor.Direction.FORWARD);
        LB.setDirection(DcMotor.Direction.REVERSE);
        CB.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
       
        while (opModeIsActive()) {
           
            double RFpower = (gamepad1.left_stick_y - gamepad1.right_stick_x);
            double RBpower = (gamepad1.left_stick_y - gamepad1.right_stick_x);
            double LFpower = (gamepad1.left_stick_y + gamepad1.right_stick_x);
            double LBpower = (gamepad1.left_stick_y + gamepad1.right_stick_x);
            double CBpower = (gamepad1.left_stick_x + gamepad1.right_stick_y);
    
            RFpower = Range.clip(RFpower,-0.75, 0.75);
            RBpower = Range.clip(RBpower,-0.75, 0.75);
            LFpower = Range.clip(LFpower,-0.75, 0.75);
            LBpower = Range.clip(LBpower,-0.75, 0.75);
            CBpower = Range.clip(CBpower,-0.75, 0.75);
            LF.setPower(LFpower);
            RF.setPower(RFpower);
            LB.setPower(LBpower);
            RB.setPower(RBpower);
            CB.setPower(CBpower);
            
        }
    }
}
