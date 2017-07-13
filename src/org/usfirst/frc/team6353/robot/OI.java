package org.usfirst.frc.team6353.robot;

import org.usfirst.frc.team6353.robot.RobotMap;
import org.usfirst.frc.team6353.robot.commands.ClimbFastCommand;
import org.usfirst.frc.team6353.robot.commands.ClimbReverseCommand;
import org.usfirst.frc.team6353.robot.commands.ClimbSlowCommand;
import org.usfirst.frc.team6353.robot.commands.DriveAbsRotateLeftCommand;
//import org.usfirst.frc.team6353.robot.commands.DriveStopCommand;
import org.usfirst.frc.team6353.robot.commands.DriveAbsRotateRightCommand;
import org.usfirst.frc.team6353.robot.commands.DriveStraightCommand;
import org.usfirst.frc.team6353.robot.commands.EmergStopCommand;
import org.usfirst.frc.team6353.robot.commands.GearCommand;
import org.usfirst.frc.team6353.robot.commands.GearLiftCommand;
import org.usfirst.frc.team6353.robot.commands.GearLiftReverseCommand;
import org.usfirst.frc.team6353.robot.commands.GearLiftSlowCommand;
import org.usfirst.frc.team6353.robot.commands.GearReverseCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick mainJoystick;
	public Joystick auxJoystick;
	
	public Button EnableDrivingButton;
	public Button AbsRotateLeftButton;
	public Button AbsRotateRightButton;
	public Button EmergStopButton;
	public Button ClimbSlowButton;
	public Button ClimbFastButton;
	public Button ClimbReverseButton;
	public Button ClimbAdjustButton;
	public Button DriveForwardButton;
	public Button DriveBackwardButton;
	public Button GearButton;
	public Button GearLiftButton;
	public Button GearLiftReverseButton;
	public Button GearReverseButton;
	public Button GearLiftSlowButton;
	
	public OI(){
		mainJoystick = new Joystick(RobotMap.DriverJoystickPort);
		auxJoystick = new Joystick(RobotMap.AuxJoystickPort);
		
		//CREATING BUTTONS
			//mainJoystick Buttons
		EnableDrivingButton =  new JoystickButton(mainJoystick, RobotMap.EnableDrivingButtonID);
		AbsRotateLeftButton = new JoystickButton(mainJoystick, RobotMap.DriverJoystickAbsRotateLButtonID);
		AbsRotateRightButton = new JoystickButton(mainJoystick, RobotMap.DriverJoystickAbsRotateRButtonID);
		EmergStopButton = new JoystickButton(mainJoystick, RobotMap.EmergStopButtonID);
//		DriveForwardButton = new JoystickButton(mainJoystick, RobotMap.DriveForwardButtonID);
//		DriveBackwardButton = new JoystickButton(mainJoystick, RobotMap.DriveBackwardButtonID);
			//ausJoystick Buttons
		GearButton = new JoystickButton(auxJoystick, RobotMap.GearButtonID);
		GearReverseButton = new JoystickButton(auxJoystick, RobotMap.GearReverseButtonID);
		GearLiftButton = new JoystickButton(auxJoystick, RobotMap.GearLiftButtonID);
		GearLiftReverseButton = new JoystickButton(auxJoystick, RobotMap.GearLiftReverseButtonID);
		GearLiftSlowButton = new JoystickButton(auxJoystick, RobotMap.GearLiftSlowButtonID);
		ClimbFastButton = new JoystickButton(auxJoystick, RobotMap.ClimbFastButtonID);
		ClimbReverseButton = new JoystickButton(auxJoystick, RobotMap.ClimbReverseButtonID);
		
		//TRIGGERING COMMANDS WITH BUTTONS
		
//		EnableDrivingButton.whenPressed(new DriveEnableStatusChangeCommand());
//		EnableDrivingButton.whenReleased(new DriveEnableStatusChangeCommand());
		AbsRotateLeftButton.whileHeld(new DriveAbsRotateLeftCommand());
		AbsRotateRightButton.whileHeld(new DriveAbsRotateRightCommand());
		EmergStopButton.whileHeld(new EmergStopCommand());
		
//		DriveForwardButton.whileHeld(new DriveStraightCommand(1));
//		DriveBackwardButton.whileHeld(new DriveStraightCommand(-1));
		
		ClimbSlowButton.whileHeld(new ClimbSlowCommand());
		ClimbFastButton.whileHeld(new ClimbFastCommand());
		ClimbReverseButton.whileHeld(new ClimbReverseCommand());
		ClimbAdjustButton.whileHeld(new ClimbSlowCommand());
		
		GearButton.whileHeld(new GearCommand());
		GearReverseButton.whileHeld(new GearReverseCommand());
		GearLiftButton.whileHeld(new GearLiftCommand());
		GearLiftReverseButton.whileHeld(new GearLiftReverseCommand());
		GearLiftSlowButton.whileHeld(new GearLiftSlowCommand());
	}

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
