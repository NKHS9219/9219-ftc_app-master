package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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



@Autonomous(name="AutoNineTwoOneNineBlueOne", group="Master")
public class AutoNineTwoOneNineBlueOne extends LinearOpMode {

    private DcMotor RB;
    private DcMotor RF;
    private DcMotor LF;
    private DcMotor LB;
    private DcMotor GM;
    private Servo RG;
    private Servo LG;
    private Orientation Angles;
    private VuforiaLocalizer vuforia;
    private RelicRecoveryVuMark vuMarkFound;
    private VuforiaTrackable relicTemplate;
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


        LF.setDirection(DcMotor.Direction.FORWARD);
        RF.setDirection(DcMotor.Direction.REVERSE);
        RB.setDirection(DcMotor.Direction.REVERSE);
        LB.setDirection(DcMotor.Direction.FORWARD);
        GM.setDirection(DcMotor.Direction.FORWARD);
        GM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        VuforiaLaunch();

        waitForStart();
        
        VuforiaFind();

            if (pictoGraph == "Right") {
                TankLift();
                Thread.sleep(1000);
                TankBack(-0.25);
                Thread.sleep(1700);
                TankStop();
                Thread.sleep(1000);
                TankTurnLeft(-0.25);
                Thread.sleep(2000);
                TankStop();
                Thread.sleep(1000);
                TankForward(-0.25);
                Thread.sleep(1250);
                TankStop();
                Thread.sleep(1000);
                TankTurnLeft(-0.25);
                Thread.sleep(250);
                TankStop();
                Thread.sleep(1000);
                TankUnLift();
                Thread.sleep(1000);
                TankOpen();
                Thread.sleep(1000);
                TankBack(-0.2);
                Thread.sleep(230);
                TankStop();
                stop();
            }   
                
            if (pictoGraph == "Center") {
                TankLift();
                Thread.sleep(1000);
                TankBack(-0.25);
                Thread.sleep(1700);
                TankStop();
                Thread.sleep(1000);
                TankTurnLeft(-0.25);
                Thread.sleep(2200);
                TankStop();
                Thread.sleep(1000);
                TankUnLift();
                Thread.sleep(1000);
                TankOpen();
                Thread.sleep(1000);
                TankForward(-0.25);
                Thread.sleep(940);
                TankStop();
                Thread.sleep(1000);
                TankBack(-0.2);
                Thread.sleep(215);
                TankStop();
                stop();
            }
                    
            if (pictoGraph == "Left") {
                TankLift();
                Thread.sleep(1000);
                TankBack(-0.25);
                Thread.sleep(1700);
                TankStop();
                Thread.sleep(1000);
                TankTurnLeft(-0.25);
                Thread.sleep(2500);
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
                TankBack(-0.2);
                Thread.sleep(215);
                TankStop();
                stop();
            }
            
            if (pictoGraph == "Unknown") {
                TankLift();
                Thread.sleep(1000);
                TankBack(-0.25);
                Thread.sleep(1700);
                TankStop();
                Thread.sleep(1000);
                TankTurnLeft(-0.25);
                Thread.sleep(2200);
                TankStop();
                Thread.sleep(1000);
                TankUnLift();
                Thread.sleep(1000);
                TankOpen();
                Thread.sleep(1000);
                TankForward(-0.25);
                Thread.sleep(940);
                TankStop();
                Thread.sleep(1000);
                TankBack(-0.2);
                Thread.sleep(215);
                TankStop();
                stop();
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

                    while (!foundGraph || !(runtime.milliseconds() >= 5000)) {

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
                        } 
                        telemetry.addData("Found: ", pictoGraph);
                        telemetry.update();
                    }
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
