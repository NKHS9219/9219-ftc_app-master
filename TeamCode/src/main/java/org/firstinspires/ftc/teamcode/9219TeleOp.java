package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="9219TeleOp", group="9219Code")
public class 9219TeleOp extends LinearOpMode {

    private DcMotor RB;
    private DcMotor RF;
    private DcMotor LF;
    private DcMotor LB;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        LF  = hardwareMap.get(DcMotor.class, "LFMotor");
        RF = hardwareMap.get(DcMotor.class, "RFMotor");
        LB  = hardwareMap.get(DcMotor.class, "LBMotor");
        RB = hardwareMap.get(DcMotor.class, "RBMotor");
     
        LF.setDirection(DcMotor.Direction.REVERSE);
        RF.setDirection(DcMotor.Direction.FORWARD);
        RB.setDirection(DcMotor.Direction.FORWARD);
        LB.setDirection(DcMotor.Direction.REVERSE);
        
        waitForStart();
       
        while (opModeIsActive()) {
           
            double RFpower = (gamepad1.left_stick_y - gamepad1.right_stick_x);
            double RBpower = (gamepad1.left_stick_y - gamepad1.right_stick_x);
            double LFpower = (gamepad1.left_stick_y + gamepad1.right_stick_x);
            double LBpower = (gamepad1.left_stick_y + gamepad1.right_stick_x);
            
    
            RFpower = Range.clip(RFpower,-0.75, 0.75);
            RBpower = Range.clip(RBpower,-0.75, 0.75);
            LFpower = Range.clip(LFpower,-0.75, 0.75);
            LBpower = Range.clip(LBpower,-0.75, 0.75);
            
            LF.setPower(LFpower);
            RF.setPower(RFpower);
            LB.setPower(LBpower);
            RB.setPower(RBpower);
            
        }
    }
}
