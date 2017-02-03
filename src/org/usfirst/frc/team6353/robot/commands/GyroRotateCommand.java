package org.usfirst.frc.team6353.robot.commands;

import org.usfirst.frc.team6353.robot.Robot;


public class GyroRotateCommand extends GyroTurningCommand {

	public GyroRotateCommand(double targetAngle) {
		super(targetAngle);
	}

	protected void initialize() {
		double currentAngle = Robot.gyroSubsystem.getAngle();
		double __lAngle = GyroTurningCommand.getLowerBound(currentAngle, currentAngle + targetAngle),
				__rAngle = GyroTurningCommand.getUpperBound(currentAngle, currentAngle + targetAngle);
		
		if (currentAngle - __lAngle <= __rAngle - currentAngle) {
			direction = 1;
			finalAngle = __lAngle;
		} else {
			direction = -1;
			finalAngle = __rAngle;
		}
	}
}
