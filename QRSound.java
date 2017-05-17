//package ie.itsligo.roomroute;

package sound;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class QRSound {
	private static final int caseA = 1; // Go to engineering message
	private static final int caseB = 2;
	private static final int caseCD = 3;
	private static final int caseE = 4;
	//private static final int caseA = 1;
	
	public static void main(String[] args) {
		
		playit(caseE);
		delayfor(7);	// delay for 7 seconds

	}
	
	public static void delayfor(int n)
	{
		try {
		    Thread.sleep(n * 1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
    /*
	 * Method is passed a sound flag it will play that sound there is only one
	 * currently supported. To use this sound - call new playit(SOUND);
	 */
	public static void playit(int soundRequired) {
		String fn = null;
		File sound; 
        URL location = QRSound.class.getProtectionDomain().getCodeSource().getLocation();
        
		switch (soundRequired) {
		case caseA:
			fn = location.getFile() + "../src/resources/case_A.wav";
			break;
		case caseB:
			fn = location.getFile() + "../src/resources/case_B.wav";
			break;
		case caseCD:
			fn = location.getFile() + "../src/resources/case_CD.wav";
			break;
		case caseE:
			//fn = location.getFile() + "../src/resources/case_E.wav";
			fn = "C:\\Temp\\case_E.wav";
			break;

		default:
			break;

		}

		// Go for it!
		try {
			// Open an audio input stream.
			sound = new File(fn);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			// plays
		}catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}