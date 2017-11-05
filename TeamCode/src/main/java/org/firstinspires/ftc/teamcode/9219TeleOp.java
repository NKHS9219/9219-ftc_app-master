package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="DevinMuyScrub", group="Linear Opmode")

public class TeleOp extends LinearOpMode {

    // Declare OpMode members.

    private DcMotor RB;
    private DcMotor RT;
    private DcMotor LT;
    private DcMotor LB;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
      
        LT  = hardwareMap.get(DcMotor.class, "LFMotor");
        RT = hardwareMap.get(DcMotor.class, "RFMotor");
        LB  = hardwareMap.get(DcMotor.class, "LBMotor");
        RB = hardwareMap.get(DcMotor.class, "RBMotor");
     
        LT.setDirection(DcMotor.Direction.REVERSE);
        RT.setDirection(DcMotor.Direction.FORWARD);
        RB.setDirection(DcMotor.Direction.FORWARD);
        LB.setDirection(DcMotor.Direction.REVERSE);
        
        waitForStart();
       
        while (opModeIsActive()) {
           
            double RTpower = (gamepad1.left_stick_y - gamepad1.right_stick_x);
            double RBpower = (gamepad1.left_stick_y - gamepad1.right_stick_x);
            double LTpower = (gamepad1.left_stick_y + gamepad1.right_stick_x);
            double LBpower = (gamepad1.left_stick_y + gamepad1.right_stick_x);
            
    
            RTpower = Range.clip(RTpower,-0.75, 0.75);
            RBpower = Range.clip(RBpower,-0.75, 0.75);
            LTpower = Range.clip(LTpower,-0.75, 0.75);
            LBpower = Range.clip(LBpower,-0.75, 0.75);
            
            LT.setPower(LTpower);
            RT.setPower(RTpower);
            LB.setPower(LBpower);
            RB.setPower(RBpower);
            
        }
    }
}
