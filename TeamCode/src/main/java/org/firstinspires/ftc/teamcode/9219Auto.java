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
    private DcMotor CB;

    @Override
    public void runOpMode() {

        color = hardwareMap.colorSensor.get("color");

        /* eg: Initialize the hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names assigned during the robot configuration
         * step (using the FTC Robot Controller app on the phone).
         */
        // leftMotor  = hardwareMap.dcMotor.get("left_drive");
        // rightMotor = hardwareMap.dcMotor.get("right_drive");

        LFMotor = hardwareMap.dcmotor.get("lfMotor");
        RFMotor = hardwareMap.dcmotor.get("rfMotor");
        LBMotor = hardwareMap.dcmotor.get("lbMotor");
        RBMotor = hardwareMap.dcmotor.get("rbMotor");
        CBMotor = hardwareMap.dcmotor.get("cbMotor");

        LFMotor.setDirection(DcMotor.Direction.REVERSE)
        // eg: Set the drive motor directions:
        // "Reverse" the motor that runs backwards when connected directly to the battery
         //leftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        // rightMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        // run until the end of the match (driver presses STOP)
        while(opModeIsActive()) {

        if(color.red() > color.blue() && color.red() {
        colorFound = "Red";
        telemetry.addData(caption: "Color Found ;",colorFound)
        telemetery.Update()
        TankFoward(.5)
        Thread.sleep(500)
        }else {
            TankBackward(.5)
            Thread.sleep(500)
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
    public void TankStrafeRight(double power) {

        }
}
