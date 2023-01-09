// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class GearPistonSubsystem extends SubsystemBase {
  DoubleSolenoid solenoid1;
  int counter = 0;
  long timer = 0;
  /** Creates a new GearboxPistonSubsystem. */
  public GearPistonSubsystem() {
    solenoid1 = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.solenoidPort1,Constants.solenoidPort2);
  }

  public void useGearPistons(boolean activate) {
    if(activate && counter == 0 && cooldown(timer)) {
      solenoid1.set(Value.kForward);
      timer = System.currentTimeMillis();
      counter++;
      activate = false;
    }
    if(activate && counter == 1 && cooldown(timer)) {
      solenoid1.set(Value.kReverse);
      timer = System.currentTimeMillis();
      counter--;
      activate = false;
    }
  }
  public boolean cooldown(long startTime) {
    long cooldownTime = System.currentTimeMillis() - startTime;
    return (cooldownTime > 250);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
