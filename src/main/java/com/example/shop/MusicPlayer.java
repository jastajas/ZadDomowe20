package com.example.shop;

import javax.sound.sampled.*;
import java.io.*;

public class MusicPlayer {

    public void playsound() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File soundFile = new File("cash-register-04.aiff");

        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

        Clip clip = AudioSystem.getClip();

        clip.open(audioIn);

        clip.start();
    }
}
