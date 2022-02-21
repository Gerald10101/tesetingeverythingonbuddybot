// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
//import org.opencv.core.Mat;
//import org.opencv.imgproc.Imgproc;
//import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.cameraserver.CameraServer;
//import edu.wpi.first.cscore.UsbCamera;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.cscore.UsbCamera;
//import edu.wpi.first.networktables.NetworkTable;

//import edu.wpi.first.cscore.CvSink;
//import edu.wpi.first.cscore.CvSource;
//import edu.wpi.first.cscore.UsbCamera;
//import edu.wpi.first.cameraserver.CameraServer;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Eye extends SubsystemBase {
public UsbCamera cam_0;
public CameraServer server1;

public Eye(){
//server1 = CameraServer;
  CameraServer.startAutomaticCapture();




}





}
