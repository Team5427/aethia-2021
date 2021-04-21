package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class RightAuton extends SequentialCommandGroup
{
    public RightAuton()
    {
        addCommands(new MoveStraightPID(46.62, 1), new PointTurn(30), new Wait(3), new PointTurn(0), new Wait(1), new MoveStraightPID(130, 1), new MoveStraightPID(12, -1));
    }
}
