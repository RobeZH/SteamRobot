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
	
	public static final int BallCollectMotorPort = 4;
	public static final int ShootPrepareMotorPort = 5;
	public static final int ShootMotorPort = 7;
	public static final int ClimbMotorPort = 6;
	
	//Joystick Ports
	public static final int DriverJoystickPort = 1;
	public static final int AuxJoystickPort = 0;
	
	//MainJoystick Button&Axis IDs
	public static final int DriverHorizontalAxisPort = 0;
	public static final int DriverVerticalAxisPort = 1;
	public static final int DriverSpeedControlAxisPort = 3;
	
	public static final int DriverJoystickAbsRotateLButtonID = 3;
	public static final int DriverJoystickAbsRotateRButtonID = 4;
	public static final int EnableDrivingButtonID = 1;
	public static final int EmergStopButtonID = 11;
	public static final int ClimbSlowButtonID = 2147483647;
	public static final int ClimbFastButtonID = 2147483647;
	public static final int ClimbReverseButtonID = 2147483647;
	
	//AuxJoystick Button&Axis IDs
	public static final int ShootPrepareButtonID = 5;
	public static final int ShootButtonID = 6;
	public static final int ShootReverseButtonID = 3;
//	public static final int AimingButtonID = 0;
	public static final int BallCollectButtonID = 1;
	public static final int BallCollectReverseButtonID = 2;
	public static final int ClimbButtonID = 4;
	
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
	public static final double DriverSpeedControlConstant = 0.8;
	
	
	//motor speed
	public static final double ClimbFullSpeed = 1;
	public static final double ClimbSlowSpeed = 0.4;
	public static final double ClimbReverseSpeed = - 0.4;
	
	
}
