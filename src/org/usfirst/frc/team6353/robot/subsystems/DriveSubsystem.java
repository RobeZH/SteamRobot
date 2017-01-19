package org.usfirst.frc.team6353.robot.subsystems;

import org.usfirst.frc.team6353.robot.RobotMap;
import org.usfirst.frc.team6353.robot.commands.DriveWithJoystickCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP driveFrontLeft;
	VictorSP driveFrontRight;
	VictorSP driveRearLeft;
	VictorSP driveRearRight;
	RobotDrive robotDrive;
	
	public DriveSubsystem(){
		driveFrontLeft = new VictorSP(RobotMap.DriverFrontLeftPort);
		driveFrontRight = new VictorSP(RobotMap.DriverFrontRightPort);
		driveRearLeft = new VictorSP(RobotMap.DriverRearLeftPort);
		driveRearRight = new VictorSP(RobotMap.DriverRearRightPort);
		
		robotDrive = new RobotDrive(driveFrontLeft, driveRearLeft, driveFrontRight, driveRearRight);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystickCommand());
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    public void stop(){
    	robotDrive.tankDrive(0, 0);
    }
    
    public void tankDrive(Joystick joy) {
    	robotDrive.tankDrive(0.1*joy.getRawAxis(RobotMap.DriverVerticalLeftAxisPort),
    			0.1*joy.getRawAxis(RobotMap.DriverVerticalRightAxisPort));
    }
    
    public void tankDrive(double leftValue, double rightValue) {
		robotDrive.tankDrive(leftValue, rightValue);
	}

	public void tankDrive(double leftValue, double rightValue, boolean isSquareInput) {
		robotDrive.tankDrive(leftValue, rightValue, isSquareInput);
	}
}

