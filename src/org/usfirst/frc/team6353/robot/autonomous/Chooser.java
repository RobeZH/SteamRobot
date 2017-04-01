package org.usfirst.frc.team6353.robot.autonomous;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chooser {

	SendableChooser<CommandGroup> chooser;
	Command autonomousCommand;
	
	public Chooser() {
		//System.out.println("Creating CHooser");
		chooser = new SendableChooser<CommandGroup>();
		
		chooser.addDefault("Do nothing", null);
		chooser.addDefault("Straight Forward", new DriveStraightForward());
		
		SmartDashboard.putData("Auto selector", chooser);
		System.out.println("Creating Chooser compelte");
	}
	
	public void run() {
		autonomousCommand = (Command) chooser.getSelected();
		
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	
	public void cancel() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}
}
