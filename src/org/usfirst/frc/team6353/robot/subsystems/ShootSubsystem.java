package org.usfirst.frc.team6353.robot.subsystems;

import org.usfirst.frc.team6353.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootSubsystem extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private VictorSP shootWheel;
	
	public ShootSubsystem(){
		shootWheel = new VictorSP(RobotMap.ShootMotorPort);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shoot(){
    	shootWheel.setSpeed(0.3);
    }
    
    public void stop(){
    	shootWheel.setSpeed(0);
    }
}

