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
	
	public static final int DriverVerticalLeftAxisPort = 1;
	public static final int DriverVerticalRightAxisPort = 5;
	
	public static final int DriverJoystickPort = 1;
	public static final int ReleaseJoystickPort = 1;
	
	
	public static final double JoystickAxisToleranceDegree = 0.2;
	
	public static final int JoystickStopButon = 1;
	
	public static final boolean IsSquareInput = true;
	
}
