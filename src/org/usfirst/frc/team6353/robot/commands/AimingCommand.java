package org.usfirst.frc.team6353.robot.commands;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team6353.robot.GripPipeline;
import org.usfirst.frc.team6353.robot.Robot;
import org.usfirst.frc.team6353.robot.RobotMap;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.vision.VisionThread;


/**
 *
 */
public class AimingCommand extends Command {

	
    public AimingCommand() {
    	requires(Robot.shootPrepareSubsystem);
//    	setTimeout(3.0);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shootPrepareSubsystem.aiming();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
//    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
