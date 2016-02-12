
package org.usfirst.frc.team5839.robot;

import java.sql.Time;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.NetworkButton;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public RobotDrive robotDrive;
	public Joystick leftJoystick, rightJoystick;
	
	
	public Robot() {
		robotDrive = new RobotDrive(0, 1, 2, 3);
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
		
		
		CameraServer.getInstance().startAutomaticCapture();//image transmission
	}
	
	public void robotInit(){
		
	}
	
    public void teleopPeriodic() {
    	double left = leftJoystick.getAxis(Joystick.AxisType.kY);
    	double right = rightJoystick.getAxis(Joystick.AxisType.kY);
    	double leftFactor = leftJoystick.getRawButton(1)?0.6:1;
    	double rightFactor = rightJoystick.getRawButton(1)?0.6:1;
    	double leftPower = left * leftFactor;
    	double rightPower = right * rightFactor;
        robotDrive.tankDrive( leftPower,  rightPower);
       SmartDashboard.putDouble("left motor power", leftPower);
       SmartDashboard.putDouble("right motor power", rightPower);
       
       
    }
    
    
}

