// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html

public class MoveStraightPID extends PIDCommand {
  /** Creates a new MoveStraightPID. */

  private double startDist;
  private double distance;//in inches
  private double tolerance;

  public MoveStraightPID(double distance, int direction) {
    super(
        // The controller that the command will use
        new PIDController(0.17, 0.095, 0.005),
        //0.155
        //0.095
        //0.005
        // This should return the measurement
        () -> RobotContainer.getAHRS().getYaw(),
        // This should return the setpoint (can also be a constant)
        () -> 0,
        // This uses the output
        output -> {
          // Use the output here
          RobotContainer.getDriveTrain().rampLeft(-0.6 * direction);
          RobotContainer.getDriveTrain().getRight().set(output * direction);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.getDriveTrain());
    // Configure additional PID options by calling `getController` here.
    this.distance = Math.abs(distance);
  }

  @Override
  public void initialize()
  {
    tolerance = 2;
    startDist = RobotContainer.getDriveTrain().getAvgDistance();
    RobotContainer.getAHRS().reset();
    super.initialize();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    System.out.println("Distance: " + distance + "   Start Distance: " + startDist + "   Avg Distance: " + RobotContainer.getDriveTrain().getAvgDistance());
    SmartDashboard.putNumber("Yaw", RobotContainer.getAHRS().getYaw());
    return Math.abs(RobotContainer.getDriveTrain().getAvgDistance() - startDist) < distance + tolerance && Math.abs(RobotContainer.getDriveTrain().getAvgDistance() - startDist) > distance - tolerance;
  }

  @Override
  public void end(boolean interrupted)
  {
    RobotContainer.getDriveTrain().stop();
    DriveTrain.leftSpeed = 0;
    DriveTrain.rightSpeed = 0;
    SmartDashboard.putNumber("dist", RobotContainer.getDriveTrain().getAvgDistance());
    SmartDashboard.putNumber("Yaw", RobotContainer.getAHRS().getYaw());
  }
}
