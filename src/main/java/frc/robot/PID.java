// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class PID {
    double kp;
    double ki; 
    double kd;


    double i = 0; 
    public PID (double kp, double ki, double kd){
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
    }

    public PID (double kp, double ki){
        this.kp = kp;
        this.ki = ki;
    }

    public double calculatePid(double error) {
        i += error * 0.02f;
        double value = kp*error + ki*i;
        return value;
      }

    
}
