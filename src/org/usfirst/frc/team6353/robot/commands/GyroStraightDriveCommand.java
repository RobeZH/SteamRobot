package org.usfirst.frc.team6353.robot.commands;


import org.usfirst.frc.team6353.robot.Robot;
import org.usfirst.frc.team6353.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroStraightDriveCommand extends Command {

	private double speed;
	private double finalAngle;
	private double timeout;
	
    public GyroStraightDriveCommand(double speed, double timeout) {
        requires(Robot.driveSubsystem);
        this.speed = speed;
        this.timeout = timeout;
    }
    
    public GyroStraightDriveCommand(double speed) {
        this(speed, 0);
    }
    
    protected void initialize() {
    	finalAngle = Robot.gyroSubsystem.getAngle();
    	if (timeout != 0) {
    		setTimeout(timeout);
    	}
    }
    
    protected void execute() {
    	double currentAngle = Robot.gyroSubsystem.getAngle();
    	double delta = Math.abs(currentAngle - finalAngle);
		Robot.driveSubsystem.arcadeDrive(speed, 
				delta < RobotMap.GyroStraightRotateToleranceDegree
				? 0
				: RobotMap.GyroStraightAdjustConstant * Math.signum(currentAngle - finalAngle));
    }
    
    protected boolean isFinished() {
        return isTimedOut();
    }
    
    protected void end() {
    	Robot.driveSubsystem.stop();
    }
    
    protected void interrupted() {
    	end();
    }
    
}
