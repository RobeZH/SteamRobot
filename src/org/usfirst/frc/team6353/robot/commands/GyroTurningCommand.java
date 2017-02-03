package org.usfirst.frc.team6353.robot.commands;

import org.usfirst.frc.team6353.robot.Robot;
import org.usfirst.frc.team6353.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class GyroTurningCommand extends Command {

	double targetAngle, finalAngle;
	int direction;

	public GyroTurningCommand(double targetAngle) {
		requires(Robot.driveSubsystem);

		this.targetAngle = targetAngle;

		finalAngle = 0;
		direction = 0;
	}

	protected static double getLowerBound(double currentAngle, double targetAngle) {
		int n = (int) Math.floor((currentAngle - targetAngle) / 360.0);
		return n * 360.0 + targetAngle;
	}

	protected static double getUpperBound(double currentAngle, double targetAngle) {
		return getLowerBound(currentAngle, targetAngle) + 360.0;
	}

	protected abstract void initialize();

	protected void execute() {
		double delta = Math.abs(Robot.gyroSubsystem.getAngle() - finalAngle);
		double curveSpeed = direction * ((delta >= RobotMap.GyroDegreeReduce) ? RobotMap.GyroTurnSpeedMaximum
				: (RobotMap.GyroTurnSpeedMaximum - RobotMap.GyroTurnSpeedMinimum) / RobotMap.GyroDegreeReduce * delta
						+ RobotMap.GyroTurnSpeedMinimum);
		Robot.driveSubsystem.arcadeDrive(0, curveSpeed);
	}

	protected boolean isFinished() {
		return Math.abs(Robot.gyroSubsystem.getAngle() - finalAngle) <= RobotMap.GyroDegreeTolerance;
	}

	protected void end() {
		Robot.driveSubsystem.stop();
	}

	protected void interrupted() {
		end();
	}
}
