/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
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

    
    public static final double DRIVETRAIN_WHEEL_DIAMETER = .1524;
    public static final double DISTANCE_PER_PULSE = (Math.PI * DRIVETRAIN_WHEEL_DIAMETER/1440)/3.68;
}
