package org.firstinspires.ftc.teamcode;

import android.hardware.Sensor;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;


@Autonomous(name="AutoNineTwoOneNine", group="Master")
public class AutoNineTwoOneNine extends LinearOpMode {

    private DcMotor RB;
    private DcMotor RF;
    private DcMotor LF;
    private DcMotor LB;
    private DcMotor CB;
    private Servo RG;
    private Servo LG;

    public void runOpMode() {

        LF = hardwareMap.get(DcMotor.class,"LFMotor");
        RF = hardwareMap.get(DcMotor.class,"RFMotor");
        LB = hardwareMap.get(DcMotor.class,"LBMotor");
        RB = hardwareMap.get(DcMotor.class,"RBMotor");
        CB = hardwareMap.get(DcMotor.class,"CBMotor");
        RG = hardwareMap.get(Servo.class,"RGServo");
        LG = hardwareMap.get(Servo.class,"LGServo");

        LF.setDirection(DcMotor.Direction.FORWARD);
        RF.setDirection(DcMotor.Direction.REVERSE);
        RB.setDirection(DcMotor.Direction.REVERSE);
        LB.setDirection(DcMotor.Direction.FORWARD);
        CB.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

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
       RB.setPower(-power);
       RF.setPower(-power);
       LB.setPower(power);
       LF.setPower(power);

}

    public void TankBack(double power){
        RB.setPower(power);
        RF.setPower(power);
        LB.setPower(-power);
        LF.setPower(-power);

        }
    }
}
