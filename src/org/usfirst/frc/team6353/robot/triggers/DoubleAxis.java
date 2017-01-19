package org.usfirst.frc.team6353.robot.triggers;

import org.usfirst.frc.team6353.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class DoubleAxis extends Trigger {
	private Joystick joy;
	private int leftAxis;
	private int rightAxis;
	
	public DoubleAxis(Joystick joy, int leftAxis, int rightAxis) {
		this.joy = joy;
		this.leftAxis = leftAxis;
		this.rightAxis = rightAxis;
	}

	@Override
	public boolean get() {
		return Math.abs(joy.getRawAxis(leftAxis) - 0.5) < RobotMap.JoystickAxisToleranceDegree
				|| Math.abs(joy.getRawAxis(rightAxis)-0.5) < RobotMap.JoystickAxisToleranceDegree;
	}
	
}
