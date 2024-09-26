package main.java.extensions.strategy;

public class RegSwitchAllLow implements IRegSwitch
{
    @Override
    public String RegSwitchInit(String input)
    {
        return input.toLowerCase();
    }
}