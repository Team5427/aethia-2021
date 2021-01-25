package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;


public class DriveWithJoystick extends CommandBase
{

    public DriveWithJoystick()
    {
        addRequirements(Robot.m_robotContainer.getDriveTrain());
    }

    @Override
    public void execute()
    {
        Robot.m_robotContainer.getDriveTrain().takeJoystickInputs(Robot.m_robotContainer.getJoystick());
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

}