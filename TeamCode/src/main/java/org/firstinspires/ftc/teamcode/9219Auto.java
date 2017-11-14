package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name="9219Auto", group="9219Code")
public class 9219Auto extends LinearOpMode {

    private DcMotor RB;
    private DcMotor RF;
    private DcMotor LF;
    private DcMotor LB;

    @Override
    public void runOpMode() {

        /* eg: Initialize the hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names assigned during the robot configuration
         * step (using the FTC Robot Controller app on the phone).
         */
        // leftMotor  = hardwareMap.dcMotor.get("left_drive");
        // rightMotor = hardwareMap.dcMotor.get("right_drive");

        // eg: Set the drive motor directions:
        // "Reverse" the motor that runs backwards when connected directly to the battery
         //leftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        // rightMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        // run until the end of the match (driver presses STOP)
        while(opModeIsActive()) {


        }
    }
   public void TankForward(double power) {
       RBMotor.setPower(power);
       RFMotor.setPower(power);
       LBMotor.setPower(-power);
       LFMotor.setPower(-power);

   }
    public void TankRight(double power) {
        RBMotor.setPower(power);
        RFMotor.setPower(power);
        LBMotor.setPower(-power);
        LFMotor.setPower(-power);

}
    public void TankLeft(double power){
        RBMotor.setPower(-power);
        RFMotor.setPower(-power);
        LBMotor.setPower(power);
        LFMotor.setPower(power);

    }
    public void TankBack(double power){
        RBMotor.setPower(-power);
        RFMotor.setPower(-power);
        LBMotor.setPower(power);
        LFMotor.setPower(power);

    }

}
