package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;



@Autonomous(name="AutoNineTwoOneNineRedOne", group="Master")
public class AutoNineTwoOneNineRedOne extends LinearOpMode {

    private DcMotor RB;
    private DcMotor RF;
    private DcMotor LF;
    private DcMotor LB;
    private DcMotor GM;
    private Servo RG;
    private Servo LG;
    private CRServo JA;
    private ColorSensor RC;
    private Orientation Angles;
    private VuforiaLocalizer vuforia;
    private RelicRecoveryVuMark vuMarkFound;
    private VuforiaTrackable relicTemplate;
    String colorFound;
    String pictoGraph;
    boolean foundGraph = false;
    int threshold = 20;




    public void runOpMode() throws InterruptedException {


        LF = hardwareMap.get(DcMotor.class, "LFMotor");
        RF = hardwareMap.get(DcMotor.class, "RFMotor");
        LB = hardwareMap.get(DcMotor.class, "LBMotor");
        RB = hardwareMap.get(DcMotor.class, "RBMotor");
        GM = hardwareMap.get(DcMotor.class, "GMMotor");
        RG = hardwareMap.get(Servo.class, "RGServo");
        LG = hardwareMap.get(Servo.class, "LGServo");
        JA = hardwareMap.get(CRServo.class, "JAServo");
        RC = hardwareMap.get(ColorSensor.class, "RCSensor");


        LF.setDirection(DcMotor.Direction.FORWARD);
        RF.setDirection(DcMotor.Direction.REVERSE);
        RB.setDirection(DcMotor.Direction.REVERSE);
        LB.setDirection(DcMotor.Direction.FORWARD);
        GM.setDirection(DcMotor.Direction.FORWARD);
        GM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        VuforiaLaunch();

        waitForStart();
        
        JA.setPower(1);
        Thread.sleep(2500);
            
            if (RC.blue() > 10) {
                TankClose();
                TankForward(-0.25);
                Thread.sleep(500);
                TankStop();
                Thread.sleep(1000);
                JA.setPower(-1);
                Thread.sleep(1000);
                TankForward(-0.25);
                Thread.sleep(500);
                TankStop();
                }
                
            if (RC.red() > 20) {
                TankClose();
                TankBack(-0.25);
                Thread.sleep(500);
                TankStop();
                Thread.sleep(1000);
                JA.setPower(-1);
                Thread.sleep(1000);
                TankBack(-0.25);
                Thread.sleep(500);
                TankStop();
                }
                
        
            VuforiaFind();

            if (pictoGraph == "Right") {
                TankLift();
                Thread.sleep(1000);
                TankForward(-0.25);
                Thread.sleep(1700);
                TankStop();
                Thread.sleep(1000);
                TankTurnRight(-0.25);
                Thread.sleep(350);
                TankStop();
                Thread.sleep(1000);
                TankUnLift();
                Thread.sleep(1000);
                TankOpen();
                Thread.sleep(1000);
                TankForward(-0.25);
                Thread.sleep(500);
                TankStop();
                Thread.sleep(1000);
                TankBack(-0.25);
                Thread.sleep(350);
                TankStop();
                stop();
                }
                
            if (pictoGraph == "Center") {
                TankLift();
                Thread.sleep(1000);
                TankForward(-0.25);
                Thread.sleep(1700);
                TankStop();
                Thread.sleep(1000);
                TankTurnRight(-0.25);
                Thread.sleep(350);
                TankStop();
                Thread.sleep(1000);
                TankUnLift();
                Thread.sleep(1000);
                TankOpen();
                Thread.sleep(1000);
                TankForward(-0.25);
                Thread.sleep(500);
                TankStop();
                Thread.sleep(1000);
                TankBack(-0.25);
                Thread.sleep(350);
                TankStop();
                stop();
                    
            if (pictoGraph == "Left") {
                TankLift();
                Thread.sleep(1000);
                TankForward(-0.25);
                Thread.sleep(1700);
                TankStop();
                Thread.sleep(1000);
                TankTurnRight(-0.25);
                Thread.sleep(350);
                TankStop();
                Thread.sleep(1000);
                TankUnLift();
                Thread.sleep(1000);
                TankOpen();
                Thread.sleep(1000);
                TankForward(-0.25);
                Thread.sleep(500);
                TankStop();
                Thread.sleep(1000);
                TankBack(-0.25);
                Thread.sleep(350);
                TankStop();
                stop();
            }
        }
    }        
                public void TankForward(double power) {
                    RB.setPower(power);
                    RF.setPower(power);
                    LB.setPower(power);
                    LF.setPower(power);
                }


                public void TankStop() {
                    RB.setPower(0);
                    RF.setPower(0);
                    LB.setPower(0);
                    LF.setPower(0);
                }


                public void TankBack(double power) {
                    RB.setPower(-power);
                    RF.setPower(-power);
                    LB.setPower(-power);
                    LF.setPower(-power);
                }


                public void TankTurnRight(double power) {
                    RB.setPower(-power);
                    RF.setPower(-power);
                    LF.setPower(power);
                    LB.setPower(power);
                }


                public void TankTurnLeft(double power) {
                    RB.setPower(power);
                    RF.setPower(power);
                    LF.setPower(-power);
                    LB.setPower(-power);
                }


                public void TankClose() {
                    RG.setPosition(0.3);
                    LG.setPosition(0.5);
                }


                public void TankOpen() {
                    RG.setPosition(0.8);
                    LG.setPosition(0.1);
                }


                public void TankLift() {
                    int position = GM.getCurrentPosition();
                    telemetry.addData("GMEncoder", position);
                    GM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    GM.setTargetPosition(-500);
                    GM.setPower(-0.5);
                }

                
                public void TankUnLift() {
                    int position = GM.getCurrentPosition();
                    telemetry.addData("GMEncoder", position);
                    GM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    GM.setTargetPosition(0);
                    GM.setPower(0.25);
                }

                
                public void VuforiaFind() {

                    ElapsedTime runtime = new ElapsedTime();

                    runtime.reset();


                    while (!foundGraph && !(runtime.milliseconds() >= 10000)) {

                        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
                        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

                            vuMarkFound = vuMark;

                            if (vuMarkFound == RelicRecoveryVuMark.LEFT) {
                                pictoGraph = "Left";
                                foundGraph = true;
                            }
                            if (vuMarkFound == RelicRecoveryVuMark.CENTER) {
                                pictoGraph = "Center";
                                foundGraph = true;
                            }
                            if (vuMarkFound == RelicRecoveryVuMark.RIGHT) {
                                pictoGraph = "Right";
                                foundGraph = true;
                            }
                            if (vuMarkFound == RelicRecoveryVuMark.UNKNOWN) {
                                pictoGraph = "Unknown";
                            }
                        }
                        telemetry.addData("Found: ", pictoGraph);
                        telemetry.update();
                    }
                    foundGraph = false;
                }

                
                public void VuforiaLaunch() {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);


        parameters.vuforiaLicenseKey = "AbJFk/r/////AAAAmUgHWDtk+khrmV0Ifj7B+qqBXuZ58AvVBNBIgZ7ZJICyXgsltzk5xb9Kym207XN11d0aEx2rqU5dbnnFuZqo1e1JAFwRyBWLDnyNUllRHe7XwvWVAGXlAt9o+Fej3+6PD9Z2iUGcr75oS9nzt4fBOgL+HLe5gufXyH4DjSqDbvF2DOC/qDrXbFu1HbVdfpxnwJWFt4N0jbRkk7RFD8NIxU6RlABevjmu1+KoMigXfEJU+Swo2dwqsLUq3+5lKp28mBQfJ9xSzPOVMI7dzcjH9sMAdaXwPMFlbFulU9HIPs5CAhozyDasyiyZEZjg2ZckGyj7UXKsltPwchmp1/YgJL5Gdxsx45DvNRrfb6F/iTyq";


        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");

        relicTrackables.activate();

        telemetry.addData("Vuforia Active!", parameters.cameraDirection);
        telemetry.update();
    }
}
