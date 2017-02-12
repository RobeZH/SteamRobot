package org.usfirst.frc.team6353.robot.subsystems;

import org.usfirst.frc.team6353.robot.RobotMap;
import org.usfirst.frc.team6353.robot.commands.BallCollectDefaultCommand;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallCollectSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private VictorSP verticalCollectWheel;
	private VictorSP horiCollectWheel;
	
	public BallCollectSubsystem(){
		verticalCollectWheel = new VictorSP(RobotMap.BallCollectVerticalMotorPort);
		horiCollectWheel = new VictorSP(RobotMap.BallCollectHorizontalMotorPort);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new BallCollectDefaultCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void startCollecting(){
    	verticalCollectWheel.setSpeed(0.5);
    	horiCollectWheel.setSpeed(0.5);
    }
    
    public void stop(){
    	verticalCollectWheel.setSpeed(0);
    	horiCollectWheel.setSpeed(0);
    }
    
}

