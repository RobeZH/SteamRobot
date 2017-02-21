package org.usfirst.frc.team6353.robot;


import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team6353.robot.autonomous.Chooser;
import org.usfirst.frc.team6353.robot.grip.GripPipeline;
import org.usfirst.frc.team6353.robot.subsystems.ShootPrepareSubsystem;
import org.usfirst.frc.team6353.robot.subsystems.BallCollectSubsystem;
import org.usfirst.frc.team6353.robot.subsystems.ClimbSubsystem;
import org.usfirst.frc.team6353.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team6353.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team6353.robot.subsystems.ShootSubsystem;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.VisionThread;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	
	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static final ClimbSubsystem climbSubsystem = new ClimbSubsystem();
    public static final ShootSubsystem shootSubsystem = new ShootSubsystem();
    public static final BallCollectSubsystem ballCollectSubsystem = new BallCollectSubsystem();
    public static final GyroSubsystem gyroSubsystem = new GyroSubsystem();
    public static final ShootPrepareSubsystem shootPrepareSubsystem = 
			new ShootPrepareSubsystem();
	
	
	public static UsbCamera camera;
	public static final Object imgLock = new Object();
	public static VisionThread visionThread;
	public static double centerX = 0.0;
	public static double centerY = 0.0;
	
	Chooser chooser;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		chooser = new Chooser();
		System.out.println("Robot Initializing");
		//chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(RobotMap.USBCameraWidth, RobotMap.USBCameraHeight);
		
		visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
			if (!pipeline.filterContoursOutput().isEmpty()) {
				Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
				synchronized (imgLock) {
					centerX = r.x + (r.width / 2);
					centerY = r.y + (r.height / 2);
					
				}
			}
		});
		
		visionThread.start();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		System.out.println("Autonoumous Period Initializing");
		chooser.run();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		System.out.println("Autonoumous Period running");
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		System.out.println("Teleoporating Period Initializing");
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		chooser.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		//System.out.println("Teleoporating Period...");
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		System.out.println("Test Period...");
		LiveWindow.run();
	}
}
