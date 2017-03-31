package org.usfirst.frc.team6353.robot.subsystems;

import org.usfirst.frc.team6353.robot.RobotMap;
import org.usfirst.frc.team6353.robot.commands.ClimbDefaultCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbSubsystem extends Subsystem {

	private VictorSP climbwheel;
	private boolean status;
	private boolean finished;

	
	public ClimbSubsystem() {
		climbwheel = new VictorSP(RobotMap.ClimbMotorPort);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new ClimbDefaultCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void stop() {
    	//System.out.println("Trying to stop");
    	climbwheel.setSpeed(0);
    }
    
    public boolean getStatus(){
    	return status;
    }
    
    public void changeStatus() {
    	status = !status;
    }
    
    public void climb(double speed){
    	climbwheel.setSpeed(speed);
    }
    
    public void resetFinish(){
    	finished = false;
    }
    
    
    public void Finish(){
    	finished = true;
    }

	public boolean Finished() {
		return finished;
	}
}

