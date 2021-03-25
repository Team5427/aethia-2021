// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html

public class MoveStraightPID extends PIDCommand {
  /** Creates a new MoveStraightPID. */

  private double startTime;
  private double time;

  public MoveStraightPID(double time) {
    super(
        // The controller that the command will use
        new PIDController(0.16, 0.095, 0.005),
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
          RobotContainer.getDriveTrain().rampLeft(-0.4);
          RobotContainer.getDriveTrain().getRight().set(output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.getDriveTrain());
    // Configure additional PID options by calling `getController` here.
    this.time = time;
  }

  @Override
  public void initialize()
  {
    startTime = Timer.getFPGATimestamp();
    RobotContainer.getAHRS().reset();
    super.initialize();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return Timer.getFPGATimestamp() - startTime >= time;
  }

  @Override
  public void end(boolean interrupted)
  {
    RobotContainer.getDriveTrain().stop();
    DriveTrain.leftSpeed = 0;
    DriveTrain.rightSpeed = 0;
  }
}
