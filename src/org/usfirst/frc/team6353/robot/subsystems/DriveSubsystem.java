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
	private VictorSP driveFrontLeft;
	private VictorSP driveFrontRight;
	private VictorSP driveRearLeft;
	private VictorSP driveRearRight;
	private boolean status = false;
	private boolean finished = false;
	private double leftSpeed = 0;
	private double rightSpeed = 0;
	private int enableconstant = 0;
	
	public RobotDrive robotDrive;
	
	public DriveSubsystem(){
		System.out.println("DriveSubsystem Initializing");
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
    
    public void stop() {
    	System.out.println("DriveSubSys Stopping");
    	robotDrive.tankDrive(0, 0);
    }
    
	public double getLeftSpeed() {
		return leftSpeed;
	}
	
	public double getRightSpeed() {
		return rightSpeed;
	}
    
    public void tankDrive(Joystick joy) {
//    	if(!enabled) return;
    	double x = joy.getRawAxis(RobotMap.DriverHorizontalAxisPort);
    	double y = joy.getRawAxis(RobotMap.DriverVerticalAxisPort);
    	double DistanceFromZero = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    	double angle = Math.acos(Math.abs(x) / DistanceFromZero);
    	double Proportiontozero = (angle > Math.PI / 4 ? Math.abs(y) : Math.abs(x));
    	double anglespeed = angle / (Math.PI / 2);
    	double controlspeedconstant = - joy.getRawAxis(RobotMap.DriverSpeedControlAxisPort) / 2 + 1.0 / 2;
    	if(y < 0) {
    		if(x == 0) {
    			leftSpeed = 1;
    			rightSpeed = 1;
    		}
    		if(x > 0) {
    			leftSpeed = 1;
    			rightSpeed = anglespeed;
    		}
    		else {
    			leftSpeed = anglespeed;
    			rightSpeed = 1;
    		}
    	}
    	else if(x!=0 && angle <= 0.1 * Math.PI) {
    		if(x > 0) {
    			leftSpeed = 1;
    			rightSpeed = 0;
    		}
    		else if(x < 0) {
    			leftSpeed = 0;
    			rightSpeed = 1;
    		}
    			
    	}
    	else if(y > 0.8) {
    		leftSpeed = -1;
    		rightSpeed = -1;
    	}
    	
    	else {
    		leftSpeed = 0;
    		rightSpeed = 0;
    	}
    	tankDrive(controlspeedconstant * Proportiontozero * leftSpeed,
    			controlspeedconstant * Proportiontozero * rightSpeed);		
    }
    
    public void tankDrive(double leftValue, double rightValue) {
//    	if(!enabled) return;
//    	System.out.println("Tankdrive(a,b):"+leftValue+','+rightValue);
//    	enableconstant = (status ? 1 : 0);
    	leftSpeed = leftValue;
    	rightSpeed = rightValue;
		robotDrive.tankDrive(RobotMap.DriverSpeedControlConstant * leftValue ,// * enableconstant,
				RobotMap.DriverSpeedControlConstant * rightValue); // * enableconstant);
	}

	public void arcadeDrive(double speed, double rotateValue) {
		robotDrive.arcadeDrive(speed, rotateValue);	
	}
	
	public void AbsRotateLeft(Joystick joy) {
//		if(!enabled) return;
		double controlSpeedConstant = - joy.getRawAxis(RobotMap.DriverSpeedControlAxisPort) / 2 + 1.0 / 2;
		tankDrive( - controlSpeedConstant, controlSpeedConstant);
	}
	
	public void AbsRotateRight(Joystick joy) {
//		if(!enabled) return;
		double controlSpeedConstant = - joy.getRawAxis(RobotMap.DriverSpeedControlAxisPort) / 2 + 1.0 / 2;
		tankDrive(controlSpeedConstant, - controlSpeedConstant);
	}
	
	public boolean getStatus(){
    	return status;
    }
    
    public void changeStatus() {
    	status = !status;
    }
    
    public void resetFinish(){
    	finished = false;
    }
    
    
    public void Finish(){
    	finished = true;
    }

	public boolean Finished() {
		return finished;
	}
}

