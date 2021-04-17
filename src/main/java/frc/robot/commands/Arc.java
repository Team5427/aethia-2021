package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Arc extends CommandBase
{

    private double speed, angle;
    private double startTime;
    private double time;

    public Arc(double speed, double angle, double time)
    {
        addRequirements(RobotContainer.getDriveTrain());
        this.speed = speed;
        this.angle = angle;
        this.time = time;
    }

    @Override
    public void initialize()
    {
        RobotContainer.getDriveTrain().getDriveBase().arcadeDrive(speed, angle);
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public void execute()
    {
        RobotContainer.getDriveTrain().getDriveBase().arcadeDrive(speed, angle);
    }

    @Override
    public boolean isFinished()
    {
        return Timer.getFPGATimestamp() - startTime >= time;
    }

    @Override
    public void end(boolean interrupted)
    {
        RobotContainer.getDriveTrain().stop();
    }


    
}
