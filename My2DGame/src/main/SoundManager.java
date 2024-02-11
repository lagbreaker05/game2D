package main;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundManager {

	Clip clip;
	URL soundURL;
	
	
	 public SoundManager() {
	        soundURL = getClass().getResource("/themes/lobby_theme.wav");
	        try {
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
	            clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	            e.printStackTrace();
	        }
	    }

	    public void playLoop() {
	        if (clip != null) {
	            clip.loop(Clip.LOOP_CONTINUOUSLY);
	        }
	    }

	    public void stop() {
	        if (clip != null && clip.isRunning()) {
	            clip.stop();
	        }
	    }
	
	
}
