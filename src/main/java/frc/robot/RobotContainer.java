// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.cameraserver.CameraServer;
//import edu.wpi.first.cscore.UsbCamera;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.SimpleAutonomous;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.*;
//import edu.wpi.first.wpilibj2.command.Subsystem;
/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final Joystick m_Gamepad = new Joystick(0);
  // private final UsbCamera camera1 = new UsbCamera("Camera1", 1);
  public boolean camera = true;
  public boolean light = false;

  private final Drive m_drive = new Drive();
  SendableChooser<Command> m_chooser = new SendableChooser<>();
 
 private final Complex_Auto m_auto2 = new Complex_Auto(m_drive);
  private final SimpleAutonomous m_auto1 = new SimpleAutonomous(m_drive);
 // public final Command m_autoCommand = new Autonomous(m_drive);
//  private final chooser m_Chooser = new chooser();

  // public final Command m_autoCommand2 = new Autonomous(m_drive);

  // The robot's subsystems and commands are defined here...

  private final Subsystem watch = new Eye();
  // private final Subsystem m_drive = new Drive();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();
    m_chooser.setDefaultOption("Simple Autonomous", m_auto1);
    m_chooser.addOption("Complex Autonomous", m_auto2);
    SmartDashboard.putData("auto chooser", m_chooser);




    m_drive.setDefaultCommand(
        new RunCommand(() -> m_drive.driveArcade(m_Gamepad.getRawAxis(4) * -1, m_Gamepad.getRawAxis(5)), m_drive));

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
return (Command) m_chooser.getSelected();
  
  }
  public Drive getdrive() {
    return m_drive;
}



}
