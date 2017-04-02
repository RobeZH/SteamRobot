package org.usfirst.frc.team6353.robot.commands;

import org.usfirst.frc.team6353.robot.Robot;
import org.usfirst.frc.team6353.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDeliverGearCommand extends Command {
	

	private double speed;
	private double timeout;
	
    public AutoDeliverGearCommand(double speed, double timeout) {
    	requires(Robot.driveSubsystem);
        this.speed = speed;
        this.timeout = timeout;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (timeout != 0) {
    		setTimeout(timeout);
    	}
    	Robot.gyroSubsystem.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.gyroSubsystem.getAngle();
    	
		Robot.driveSubsystem.arcadeDrive(speed, 
				Math.abs(angle) < RobotMap.GyroStraightRotateToleranceDegree
				? 0
				: RobotMap.GyroStraightAdjustConstant * Math.signum(angle));
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSubsystem.robotDrive.tankDrive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
