package org.usfirst.frc.team6353.robot.commands;

import org.usfirst.frc.team6353.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TryADriveCommand extends Command {

    public TryADriveCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.driveSubsystem);
    	System.out.println("Setting automomous DriveSubsystem");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Before trying to tryADrive...");
    	Robot.driveSubsystem.tankDrive(0.4,0.4);
    	System.out.println("After trying to tryADrive...");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
