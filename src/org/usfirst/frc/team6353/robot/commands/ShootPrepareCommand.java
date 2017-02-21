package org.usfirst.frc.team6353.robot.commands;

import org.usfirst.frc.team6353.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootPrepareCommand extends Command {

    public ShootPrepareCommand() {
    	requires(Robot.shootPrepareSubsystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shootPrepareSubsystem.resetFinish();
//    	System.out.println("Start to prepforshoot...");
    	Robot.shootPrepareSubsystem.changeStatus();
    	Robot.shootPrepareSubsystem.Finish();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shootPrepareSubsystem.Finished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//System.out.println("Try to end");
    	Robot.shootPrepareSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
