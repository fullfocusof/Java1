package main.java.extensions.strategy;

public class RegSwitchAllUpp implements IRegSwitch
{
    @Override
    public String RegSwitchInit(String input)
    {
        return input.toUpperCase();
    }
}
