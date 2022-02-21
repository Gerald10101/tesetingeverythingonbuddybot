// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants.DriveConstants;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
public class Drive extends SubsystemBase {
  /** Creates a new drives. */
  
  
  
  private final CANSparkMax m_LeftMotor = new CANSparkMax(DriveConstants.kLeftDriveMotorCANID,MotorType.kBrushed);
  private final CANSparkMax m_RightMotor = new CANSparkMax(DriveConstants.kRightDriveMotorCANID,MotorType.kBrushed);
  public static RelativeEncoder m_LeftEncoder; 
 public  static RelativeEncoder m_RightEncoder; 
 private final DifferentialDrive m_DriveController;
 //private final Joystick m_Gamepad = new Joystick(0);
 
  public Drive() {
 
    m_LeftMotor.setInverted(true);
    m_RightMotor.setInverted(true);
    m_LeftEncoder = m_LeftMotor.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, DriveConstants.kEncoderCountsPerRev);
    m_RightEncoder = m_RightMotor.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, DriveConstants.kEncoderCountsPerRev);
    m_DriveController = new DifferentialDrive(m_LeftMotor, m_RightMotor);
    m_LeftEncoder.setPositionConversionFactor(DriveConstants.kEncoderPositionConversionFactor);
    m_RightEncoder.setPositionConversionFactor(DriveConstants.kEncoderPositionConversionFactor);
    zeroEncoders();
  }


   
    
      
    @Override 
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Right Encoder", m_RightEncoder.getPosition());
    SmartDashboard.putNumber("Left Encoder", m_LeftEncoder.getPosition());
    SmartDashboard.putNumber("Average Encoder", getAverageEncoderDistance());
    SmartDashboard.putNumber("ticks per rev", m_LeftEncoder.getCountsPerRevolution());

    m_LeftEncoder.getPosition();
m_RightEncoder.getPosition();
m_LeftEncoder.getCountsPerRevolution();  
}
  public void driveArcade(double xSpeed, double zRotation) {
    m_DriveController.arcadeDrive(xSpeed, zRotation);


  }
  
  public void stop() {
    m_LeftMotor.set(0);
    m_RightMotor.set(0);
  }
  public void zeroEncoders() {
    m_LeftEncoder.setPosition(0);
    m_RightEncoder.setPosition(0);

  }

  public double getAverageEncoderDistance() {
    return (m_LeftEncoder.getPosition() + m_RightEncoder.getPosition()) / 2;
  }
  public void autoDriveBack(){
    m_LeftMotor.set(0.5);
    m_RightMotor.set(-0.5);
  
    

  }
   
    
  
  public void driveStop(){
    m_LeftMotor.set(0);
    m_RightMotor.set(0);

  }



}