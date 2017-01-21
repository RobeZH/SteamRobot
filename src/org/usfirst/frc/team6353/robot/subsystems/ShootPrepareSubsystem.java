package org.usfirst.frc.team6353.robot.subsystems;

import org.usfirst.frc.team6353.robot.RobotMap;
import org.usfirst.frc.team6353.robot.commands.ShootPrepareDefaultCommand;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootPrepareSubsystem extends Subsystem {
	
	VictorSP prepwheel;
	
	public ShootPrepareSubsystem() {
		prepwheel = new VictorSP(RobotMap.ShootPrepareMotorPort);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new ShootPrepareDefaultCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void prepForShoot() {
    	prepwheel.setSpeed(0.3);
    	//System.out.println("Executing...");
    }
    
    public void stop() {
    	//System.out.println("Trying to stop");
    	prepwheel.setSpeed(0);
    	
    }
}

