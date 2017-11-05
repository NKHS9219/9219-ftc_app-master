package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="DevinScrub", group="LinearOpMode")  // @Autonomous(...) is the other common choice
//@Disabled
public class Auto extends LinearOpMode {

    DcMotor MotorLeft;
    DcMotor MotorRight;

    private DcMotor LbMotor;
    private DcMotor LfMotor;
    private DcMotor RfMotor;
    private DcMotor RbMotor;



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
        while (opModeIsActive()) {


        }
    }
   public void TankForward(double power) {
       RbMotor.setPower(power);
       RfMotor.setPower(power);
       LbMotor.setPower(power);
       LfMotor.setPower(power);

   }
    public void TankRight(double power) {
        RbMotor.setPower(-power);
        RfMotor.setPower(-power);
        LbMotor.setPower(power);
        LfMotor.setPower(power);

}
    public void TankLeft(double power){
        RbMotor.setPower(power);
        RfMotor.setPower(power);
        LbMotor.setPower(-power);
        LfMotor.setPower(-power);

    }
    public void TankBack(double power){
        RbMotor.setPower(-power);
        RfMotor.setPower(-power);
        LbMotor.setPower(-power);
        LfMotor.setPower(-power);

    }

}
