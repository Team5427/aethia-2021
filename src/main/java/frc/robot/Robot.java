/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.MotionProfile;
import frc.robot.commands.MoveDistance;
import frc.robot.commands.MoveStraightPID;
import frc.robot.commands.PointTurn;
import frc.robot.commands.Slalom;
import frc.robot.subsystems.DriveTrain;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  public static RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    RobotContainer.getAHRS().reset();
    RobotContainer.getEncLeft().reset();
    RobotContainer.getEncRight().reset();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("Yaw", RobotContainer.getAHRS().getYaw());
    SmartDashboard.putNumber("angle", RobotContainer.getAHRS().getYaw());
    // SmartDashboard.putNumber("Encoder", m_robotContainer.getEncLeft().getDistance());
    // SmartDashboard.putNumber("Encoder Right", m_robotContainer.getEncRight().getDistance());
    // SmartDashboard.putNumber("Average distance", m_robotContainer.getDriveTrain().getAvgDistance());
    SmartDashboard.putNumber("Distance", Units.metersToInches(RobotContainer.getDriveTrain().getAvgDistance()));
    SmartDashboard.putNumber("dist", Units.metersToInches(RobotContainer.getDriveTrain().getAvgDistance()));



  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() 
  {
    RobotContainer.getAHRS().reset();
    RobotContainer.getEncLeft().reset();
    RobotContainer.getEncRight().reset();

    DriveTrain.leftSpeed = 0;
    DriveTrain.rightSpeed = 0;
    DriveTrain.arcadeSpeed = 0;
    
    // Pose2d start;
    // Pose2d end;
    // ArrayList<Translation2d> waypoints = new ArrayList<Translation2d>();
    // start = new Pose2d(Units.inchesToMeters(Constants.startX), Units.inchesToMeters(Constants.startY), Constants.startRotation);
    // end = new Pose2d(Units.inchesToMeters(Constants.endX), Units.inchesToMeters(Constants.endY), Constants.endRotation);
    // MotionProfile motionProfile = new MotionProfile(start, end, waypoints);

    // MoveDistance moveDistance = new MoveDistance(60);

    // MoveStraightPID moveStraightPID = new MoveStraightPID();

    Slalom slalom = new Slalom();
    
    m_autonomousCommand = slalom;

    if(m_autonomousCommand != null)
    {
      m_autonomousCommand.schedule();
    }

    // RobotContainer.getDriveTrain().rampArcade(0.3, -0.2);
    // RobotContainer.getDriveTrain().rampRight(0.3);


  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() 
  {
    // RobotContainer.getDriveTrain().rampArcade(-0.7, 0.4);
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
