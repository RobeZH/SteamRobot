package org.usfirst.frc.team6353.robot.subsystems;

import org.usfirst.frc.team6353.robot.RobotMap;
import org.usfirst.frc.team6353.robot.commands.ShootHighDefaultCommand;
import org.usfirst.frc.team6353.robot.commands.ShootPrepareDefaultCommand;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootSubsystem extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private VictorSP shootWheel;
	private boolean status;
	
	public ShootSubsystem(){
		shootWheel = new VictorSP(RobotMap.ShootMotorPort);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ShootHighDefaultCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void changeStatus(){
    	status = !status;
    }
    
    public void shoot(){
//    	System.out.println("Shooting...");
    	shootWheel.setSpeed(-1.0);
    }
    
    public void stop(){
    	shootWheel.setSpeed(0);
    }
    
    public void startOrStopShooting() {
    	if(status)
    		shoot();
    	else
    		stop();
    }
}

