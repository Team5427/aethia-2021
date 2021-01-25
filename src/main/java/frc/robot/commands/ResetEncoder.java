package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ResetEncoder extends CommandBase
{
    public ResetEncoder()
    {
        
    }

    @Override
    public void initialize()
    {
        Robot.m_robotContainer.getEncLeft().reset();
        Robot.m_robotContainer.getEncRight().reset();
        Robot.m_robotContainer.getNavX().reset();
    }

    @Override
    public boolean isFinished()
    {
        return true;
    }
    
}
