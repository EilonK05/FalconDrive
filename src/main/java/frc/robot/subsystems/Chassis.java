// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Chassis extends SubsystemBase {
  private static Chassis chassis;

  private TalonFX rightFrontMotor, rightRearMotor, leftFrontMotor, leftRearMotor;

  public Chassis() {
    rightFrontMotor = new TalonFX(1);
    rightRearMotor = new TalonFX(2);

    leftFrontMotor = new TalonFX(3);
    leftRearMotor = new TalonFX(4);

    rightRearMotor.follow(rightFrontMotor);
    leftRearMotor.follow(leftFrontMotor);
  }

  public void setRightPower(double rightPower) {
    rightFrontMotor.set(TalonFXControlMode.PercentOutput, rightPower);
  }

  public void setLeftPower(double leftPower) {
    leftFrontMotor.set(TalonFXControlMode.PercentOutput, leftPower);
  }

  public static Chassis getInstance() {
    if (chassis == null)
      chassis = new Chassis();
    return chassis;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
