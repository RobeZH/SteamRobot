package org.usfirst.frc.team6353.robot.subsystems;

import org.usfirst.frc.team6353.robot.RobotMap;
import org.usfirst.frc.team6353.robot.Robot;
import org.usfirst.frc.team6353.robot.commands.ShootPrepareDefaultCommand;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;



/**
 *
 */
public class ShootPrepareSubsystem extends Subsystem {
	
	private VictorSP prepwheel;
	private boolean status;
	private boolean finished;
	
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
//    	System.out.println("Prop Spinning");
    	prepwheel.setSpeed(-0.50);
    }
    
    public void aiming() {
		double centerX;
		//double centerY;
		synchronized (Robot.imgLock) {
			centerX = Robot.centerX;
			//centerY = Robot.centerY;
//			System.out.println("Trying to lock img..." + "X: " + centerX + " Y: " + centerY);
			
		}
		double turn = centerX - (RobotMap.USBCameraWidth / 2);
		System.out.println(turn);
		double leftSpeed = 0.0, rightSpeed = 0.0;
		if(turn < -13) {
			 leftSpeed = -0.33; rightSpeed = 0.33;
		}
		if(turn > 13) {
			leftSpeed = 0.33; rightSpeed = -0.33;
		}
		Robot.driveSubsystem.robotDrive.tankDrive(leftSpeed, rightSpeed);
    }
    
    public void stop() {
    	//System.out.println("Trying to stop");
    	prepwheel.setSpeed(0);
    	
    }
    
    public boolean getStatus(){
    	return status;
    }
    
    public void changeStatus() {
    	status = !status;
    }
    
    public void run(){
    	prepwheel.setSpeed(-0.5 * (status ? 1 : 0));
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

