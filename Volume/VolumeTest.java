import javax.sound.sampled.*;
import java.io.*;

class VolumeTest
{
	public static void main(String args[]) throws Exception
	{
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
    new File("2.mp3"));
Clip clip = AudioSystem.getClip();
clip.open(audioInputStream);
FloatControl gainControl = 
    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
clip.start();
	}
}