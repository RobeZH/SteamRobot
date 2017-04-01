package org.usfirst.frc.team6353.robot.commands;

import org.usfirst.frc.team6353.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightCommand extends Command {

	double angle;
	int direction;
	double kp = 0.03;
	double speed;
	
    public DriveStraightCommand(int direction) {
    	requires(Robot.driveSubsystem);
    	this.direction = direction;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyroSubsystem.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle = Robot.gyroSubsystem.getAngle();
    	speed = Robot.driveSubsystem.getSpeedConstant(Robot.oi.mainJoystick);
    	Robot.driveSubsystem.arcadeDrive(speed * direction, -kp*angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
