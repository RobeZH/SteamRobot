package org.usfirst.frc.team6353.robot.subsystems;

import org.usfirst.frc.team6353.robot.RobotMap;
import org.usfirst.frc.team6353.robot.commands.ShootHighDefaultCommand;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootSubsystem extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private VictorSP shootWheel;
	private int status = 0;
	
	public ShootSubsystem(){
		shootWheel = new VictorSP(RobotMap.ShootMotorPort);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ShootHighDefaultCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void shoot(){
//    	System.out.println("Shooting...");
    	shootWheel.setSpeed(-1.0);
    }
    
    public void stop(){
    	shootWheel.setSpeed(0);
    }
    
    public void changePositiveStatus() {
    	status = ( status == 1 ? 0 : 1 );
    }
    
    public void changeNegativeStatus() {
    	status = ( status == -1 ? 0 : -1 );
    }
    
    public void run(){
    	shootWheel.setSpeed(-0.8 * status);
    }
    
}

