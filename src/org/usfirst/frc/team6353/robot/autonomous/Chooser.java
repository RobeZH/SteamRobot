package org.usfirst.frc.team6353.robot.autonomous;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chooser {

	SendableChooser<CommandGroup> chooser;
	Command autonomousCommand;
	
	public Chooser() {
		chooser = new SendableChooser<CommandGroup>();
		
		chooser.addDefault("什么都没干", null);
		chooser.addDefault("尝试一下", new TryADrive());
		
		SmartDashboard.putData("Auto selector", chooser);
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
