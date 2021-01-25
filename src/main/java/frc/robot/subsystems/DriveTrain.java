package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase
{
    SpeedControllerGroup left, right;
    DifferentialDrive drive;
    public DriveTrain(SpeedControllerGroup left, SpeedControllerGroup right, DifferentialDrive drive)
    {
        this.left = left;
        this.right = right;
        this.drive = drive;
    }
    
    public void tankDrive(double right_speed, double left_speed){
        left.set(-left_speed);
        right.set(-right_speed);
    }
    
    public void takeJoystickInputs(Joystick joy){
        drive.arcadeDrive(-joy.getY(), -joy.getZ() *.75);
    }
    public double getAvgDistance()
    {
        return (RobotContainer.getEncLeft().getDistance() + RobotContainer.getEncRight().getDistance()) / 2;
    }

    public double getAvgRate()
    {
        return (RobotContainer.getEncLeft().getRate() + RobotContainer.getEncRight().getRate()) / 2;
    }
    public void stop()
    {
        left.set(0);
        right.set(0);
    }

}