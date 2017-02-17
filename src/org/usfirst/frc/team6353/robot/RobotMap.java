package org.usfirst.frc.team6353.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Roborio Ports
	public static final int DriverFrontLeftPort = 0;
	public static final int DriverFrontRightPort = 2;
	public static final int DriverRearLeftPort = 1;
	public static final int DriverRearRightPort = 3;
	public static final int ShootPrepareMotorPort = 7;
	public static final int BallCollectMotorPort = 4;
	public static final int ShootMotorPort = 5;
	
	//Joystick Ports
	public static final int DriverJoystickPort = 0;
	public static final int AuxJoystickPort = 1;
	
	//MainJoystick Button&Axis IDs
	public static final int DriverHorizontalAxisPort = 0;
	public static final int DriverVerticalAxisPort = 1;
	public static final int DriverSpeedControlAxisPort = 3;
	public static final int DriverJoystickAbsRotateLButtonID = 3;
	public static final int DriverJoystickAbsRotateRButtonID = 4;
	public static final int EmergStopButtonID  = 11;
	
	//AuxJoystick Button&Axis IDs
	public static final int ShootPrepareButtonID = 6;
	public static final int ShootButtonID = 1;
	public static final int AimingButtonID = 2;
	public static final int BallCollectButtonID = 5;
	
	//Camera
	public static final int USBCameraWidth = 320;
	public static final int USBCameraHeight = 240;
	
	//Gyro Constants
	public static final double GyroStraightRotateToleranceDegree = 1;
	public static final double GyroStraightAdjustConstant = 0.2;
	public static final double GyroDegreeTolerance = 3;
	public static final double GyroDegreeReduce = 40;
	public static final double GyroTurnSpeedMinimum = 0.3;
	public static final double GyroTurnSpeedMaximum = 0.95;
	public static final double GyroStraightRotateAdjust = 0.2;
	public static final double GyroStraightRotateTolerance = 1;
	
	//for tests
	public static final double DriverSpeedControlConstant = 0.4;
	
	
	
}
