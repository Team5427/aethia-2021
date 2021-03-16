// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class MoveDistance extends PIDCommand {
  /** Creates a new MoveDistance. */

  private double startTime;

  public MoveDistance(double setpoint) {
    super(
        // The controller that the command will use
        new PIDController(0.5, 0, 0),
        // This should return the measurement
        () -> Units.metersToInches(RobotContainer.getDriveTrain().getAvgDistance()),
        // This should return the setpoint (can also be a constant)
        () -> setpoint,
        // This uses the output
        output -> {
          // Use the output here
          RobotContainer.getDriveTrain().rampLeft(-output);
          RobotContainer.getDriveTrain().rampRight(output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

  @Override
  public void initialize()
  {
    startTime = Timer.getFPGATimestamp();
    RobotContainer.getEncLeft().reset();
    RobotContainer.getEncRight().reset();
    super.initialize();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return getController().atSetpoint();
  }
}
