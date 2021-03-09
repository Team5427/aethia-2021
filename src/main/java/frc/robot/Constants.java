/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants 
{
    public static final int LEFTTOP = 8;
    public static final int RIGHTTOP = 11;
    public static final int LEFTBOTTOM = 7;
    public static final int RIGHTBOTTOM = 10;

    public static final int LEFT_ENC_PORT1 = 0;
    public static final int RIGHT_ENC_PORT1 = 3;
    public static final int LEFT_ENC_PORT2 = 1;
    public static final int RIGHT_ENC_PORT2 = 2;

    
    public static final double DRIVETRAIN_WHEEL_DIAMETER = 0.1524; //in meters
    public static final double DISTANCE_PER_PULSE = (Math.PI * DRIVETRAIN_WHEEL_DIAMETER/256)/12.91;

    /************************* MOTION PROFILING **********************/
    public static final double MAX_VELOCITY = Units.inchesToMeters(105.967667);
    //104.33596297676506: 2.176431000000001
    //106.21048405472158: 1.0557599999999994
    //107.358148028799: 2.155234
    //105.967667: 1.795808

    public static final double MAX_TIME = 1.795808;
    public static final double MAX_ACCELERATION = MAX_VELOCITY / MAX_TIME;
    // (% Voltage [-1,1])/(Speed in meters per second) [basically we have to measure this]
    public static final double KV = 1/MAX_VELOCITY;

    //influence of acceleration on velocity, just a bias which can be further tested.
    public static final double KA = 0;

    public static final double KP_left = 0.003;
    public static final double KI_left = 0;
    public static final double KD_left = 0;

    public static final double KP_right = 0.003;
    public static final double KI_right = 0;
    public static final double KD_right = 0;

    public static final double K_THETA_P = 0;
    public static final double K_THETA_D = 0;

    //in inches

    public static final double startX = 0;
    public static final double startY = 0;
    public static final Rotation2d startRotation = new Rotation2d(0);

    // public static final ArrayList<Translation2d> waypoints = new ArrayList<>();
    // waypoints.add(new Translation2d(0, 60));
    // waypoints.add(new Translation2d(30, 60));
    // waypoints.add(new Translation2d(-90, 30));

    // public static final Translation2d testWaypoint = new Translation2d(0, 1);

    public static final double endX = 0;
    public static final double endY = -60;
    public static final Rotation2d endRotation = new Rotation2d(Units.degreesToRadians(0));
 
}
