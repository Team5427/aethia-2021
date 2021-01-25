/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.MoveStraight;
import frc.robot.commands.ResetEncoder;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private SpeedController leftTop, leftBottom, rightTop, rightBottom;
  private SpeedControllerGroup left, right;
  private DifferentialDrive drive;

  private static Joystick joy;
  private Button moveStraightPID;
  private Button reset;

  private static DriveTrain driveTrain;
  private static AHRS navX;

  private static Encoder leftEnc;
  private static Encoder rightEnc;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    leftTop = new WPI_VictorSPX(Constants.LEFTTOP);
    leftBottom = new WPI_VictorSPX(Constants.LEFTBOTTOM);
    rightTop = new WPI_VictorSPX(Constants.RIGHTTOP);
    rightBottom = new WPI_VictorSPX(Constants.RIGHTBOTTOM);

    left = new SpeedControllerGroup(leftTop, leftBottom);
    right = new SpeedControllerGroup(rightTop, rightBottom);

    drive = new DifferentialDrive(left, right);
    driveTrain = new DriveTrain(left, right, drive);
    driveTrain.setDefaultCommand(new DriveWithJoystick());

    navX = new AHRS(SPI.Port.kMXP);

    leftEnc = new Encoder(Constants.LEFT_ENC_PORT1, Constants.LEFT_ENC_PORT2);
    leftEnc.setDistancePerPulse(Constants.DISTANCE_PER_PULSE);
    rightEnc = new Encoder(Constants.RIGHT_ENC_PORT1, Constants.RIGHT_ENC_PORT2);
    rightEnc.setDistancePerPulse(Constants.DISTANCE_PER_PULSE);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    joy = new Joystick(0);

    moveStraightPID = new JoystickButton(joy, 7);
    reset = new JoystickButton(joy, 8);

    moveStraightPID.whenPressed(new MoveStraight(3));
    reset.whenPressed(new ResetEncoder());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

  public static Joystick getJoystick() {return joy;}
  public static DriveTrain getDriveTrain() {return driveTrain;}
  public static AHRS getNavX() {return navX;}
  public static Encoder getEncLeft() {return leftEnc;}
  public static Encoder getEncRight() {return rightEnc;}
}
