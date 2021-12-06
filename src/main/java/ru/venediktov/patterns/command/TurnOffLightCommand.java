package ru.venediktov.patterns.command;

public class TurnOffLightCommand implements Command{

  private Light light;

  public TurnOffLightCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.turnOff();
  }
}
