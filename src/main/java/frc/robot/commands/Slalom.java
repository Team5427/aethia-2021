// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Slalom extends SequentialCommandGroup {
  /** Creates a new Slalom. */
  public Slalom() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    // addCommands(new MoveStraightPID(1.5), new Arc(-0.7, 0.55, 1.8), new Arc(-0.7, -0.5, 1.7), new Arc(-0.7, -0.1, 2.5), new Arc(-0.7, - 0.52, 1.3),new Arc(-0.7, 0.7, 1.5));
    // addCommands(new RampArc(-0.4, 0, 0.5), new Arc(-0.7, 0.52, 2.5), new RampDownArc(-0.7, -0.47, 2.47), new Wait(0.3), new MoveStraightPID(4), new Arc(-0.7,-0.47, 2.47), new Arc(-0.7, 0.55, 7.7), new Arc(-0.7, -0.435, 2), new Arc(-0.7, 0, 3));
    //addCommands(new RampArc(-0.4, 0, 0.5), new Arc(-0.7, 0.52, 2.2), new ArcStraight(-0.7, -0.52, 0), new MoveStraightPID(1), new Arc(-0.7, -0.47, 2.47), new Arc(-0.7, 0.55, 7.0), new ArcStraight(-0.7, -0.5, 180));//1.64
  }
}
