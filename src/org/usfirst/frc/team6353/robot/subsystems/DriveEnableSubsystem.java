package org.usfirst.frc.team6353.robot.subsystems;

import org.usfirst.frc.team6353.robot.commands.EnableDrivingDefaultCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveEnableSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	boolean driveEnabled = false;
	
    public void initDefaultCommand() {
    	setDefaultCommand(new EnableDrivingDefaultCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void driveEnable(){
		driveEnabled = true;
	}
	
	public void driveDisable(){
		driveEnabled = false;
	}
}

