package org.usfirst.frc.team6353.robot.autonomous;

import org.usfirst.frc.team6353.robot.commands.TryADriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TryADrive extends CommandGroup {
	public TryADrive() {
		addSequential(new TryADriveCommand());
	}
}
