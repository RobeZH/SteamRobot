package org.usfirst.frc.team6353.robot.commands;

import org.usfirst.frc.team6353.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestGyroAngleCommand extends Command {

	double timeout;
	
    public TestGyroAngleCommand(double timeout) {
    	requires(Robot.gyroSubsystem);
        
    	this.timeout = timeout;
    	
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (timeout != 0) {
    		setTimeout(timeout);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(Robot.gyroSubsystem.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
