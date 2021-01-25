package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class SteelTalonsController extends WPI_VictorSPX
{
    private double bias;
    
    public SteelTalonsController(int deviceNumber, boolean inverted, double bias) 
    {
        super(deviceNumber);
        setInverted(inverted);
        this.bias = bias;
    }
 
    @Override
    public void set(double speed)
    {
        super.set(speed*bias);
    }

}