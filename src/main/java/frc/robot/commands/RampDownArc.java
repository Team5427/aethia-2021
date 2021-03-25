package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class RampDownArc extends CommandBase
{

    private double speed, angle;
    private double startTime;
    private double time;

    public RampDownArc(double speed, double angle, double time)
    {
        addRequirements(RobotContainer.getDriveTrain());
        this.speed = speed;
        this.angle = angle;
        this.time = time;
    }

    @Override
    public void initialize()
    {
        RobotContainer.getDriveTrain().rampDownArcade(speed, angle);
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public void execute()
    {
        RobotContainer.getDriveTrain().rampDownArcade(speed, angle);

    }

    @Override
    public boolean isFinished()
    {
        SmartDashboard.putNumber("Yaw", RobotContainer.getAHRS().getYaw());
        return Timer.getFPGATimestamp() - startTime >= time;
    }

    @Override
    public void end(boolean interrupted)
    {
        RobotContainer.getDriveTrain().stop();
        DriveTrain.arcadeSpeedHigh = Constants.SLALOM_SPEED;
        SmartDashboard.putNumber("Yaw", RobotContainer.getAHRS().getYaw());

    }


    
}
