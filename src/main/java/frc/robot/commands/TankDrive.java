// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Chassis;

public class TankDrive extends CommandBase {
  private final Chassis chassis;

  public TankDrive(Chassis chassis) {
    this.chassis = chassis;
    addRequirements(chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.rightJoystick.getY() > 0.1 || RobotContainer.rightJoystick.getY() < -0.1) {
      chassis.setRightPower(RobotContainer.rightJoystick.getY());
    } else {
      chassis.setRightPower(0);
    }

    if (RobotContainer.leftJoystick.getY() > 0.1 || RobotContainer.leftJoystick.getY() < -0.1) {
        chassis.setLeftPower(RobotContainer.leftJoystick.getY());
    } else {
      chassis.setLeftPower(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
