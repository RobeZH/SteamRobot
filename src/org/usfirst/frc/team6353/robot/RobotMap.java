package org.usfirst.frc.team6353.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static final int DriverFrontLeftPort = 0;
	public static final int DriverFrontRightPort = 1;
	public static final int DriverRearLeftPort = 2;
	public static final int DriverRearRightPort = 3;
	
	public static final int DriverHorizontalAxisPort = 0;
	public static final int DriverVerticalAxisPort = 1;
	public static final int DriverSpeedControlAxisPort = 3;
	
	public static final int DriverJoystickPort = 0;
	public static final int AuxJoystickPort = 1;
	
	public static final int DriverJoystickAbsRotateLPort = 3;
	public static final int DriverJoystickAbsRotateRPort = 4;
	
	public static final int ShootPrepareButtonID = 6;
	public static final int AimingButtonID = 5;
	
	public static final int ShootPrepareMotorPort = 9;
	
	public static final int USBCameraWidth = 320;
	public static final int USBCameraHeight = 240;
	
	public static final double GyroStraightRotateToleranceDegree = 1;
	
	public static final double GyroStraightAdjustConstant = 0.2;
	
	public static final double GyroDegreeTolerance = 3;
	public static final double GyroDegreeReduce = 40;
	public static final double GyroTurnSpeedMinimum = 0.3;
	public static final double GyroTurnSpeedMaximum = 0.95;
	public static final double GyroStraightRotateAdjust = 0.2;
	public static final double GyroStraightRotateTolerance = 1;
	
	public static final double JoystickAxisToleranceDegree = 0.2;
	
	public static final int JoystickStopButon = 1;
	
	public static final boolean IsSquareInput = true;
	
	public static final double DriverSpeedControlConstant = 0.4;
	
}
