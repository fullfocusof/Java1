package main.java.extensions.strategy;

public class RegSwitchInterraction
{
    public IRegSwitch curRegSwitch;

    public void setRegSwitch(IRegSwitch inputRegSwitch)
    {
        curRegSwitch = inputRegSwitch;
    }

    public String executeRegSwitch(String input)
    {
        return curRegSwitch.RegSwitchInit(input);
    }
}
