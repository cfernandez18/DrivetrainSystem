// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  WPI_VictorSPX leftFrontVictorSPX = null;
  WPI_VictorSPX leftBackVictorSPX = null;
  WPI_VictorSPX rightFrontVictorSPX = null;
  WPI_VictorSPX rightBackVictorSPX = null; 

  MotorControllerGroup leftMotors = null;
  MotorControllerGroup rightMotors = null;

  DifferentialDrive differentialDrive = null;


  
  public Drivetrain() {
  leftFrontVictorSPX = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_FRONT_VICTORSPX);
  leftBackVictorSPX = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_BACK_VICTORSPX);
  rightFrontVictorSPX = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_FRONT_VICTORSPX);
  rightBackVictorSPX = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_BACK_VICTORSPX);

  leftMotors = new MotorControllerGroup(leftFrontVictorSPX, leftBackVictorSPX);
  rightMotors = new MotorControllerGroup(rightFrontVictorSPX, rightBackVictorSPX);

  differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
