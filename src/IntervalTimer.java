import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.util.Scanner;

public class IntervalTimer {

    static Timer countdown;
    static int duration; // duration of interval
    static int count; // remaining time in interval
    public static void main(String[] args) {

        duration = getIntervalDuration();

        final int oneSecond = 1000;
        count = duration;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println(updateCountdown());
            }
        }, oneSecond, oneSecond);

        // Timer timer = new Timer();
        long period = oneSecond * Integer.valueOf(duration);

        // marks every iteration of interval, plays sound
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                playAudio("w.wav");
            }
        }, oneSecond, period);

        // draw();

    }

    public static int updateCountdown() {
        if (count == 0)
            count=duration;
        return count--;
    }

    public static int getIntervalDuration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Duration of interval?");
        String duration = scanner.nextLine();
        scanner.close();
        return Integer.valueOf(duration);
    }
    
    // https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
    public static void playAudio(String url) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                IntervalTimer.class.getResourceAsStream(url));
            clip.open(inputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void draw() {
        JFrame f=new JFrame();//creating instance of JFrame  
          
        // JButton b=new JButton("click");//creating instance of JButton  
        // b.setBounds(130,100,100, 40);//x axis, y axis, width, height
        // f.add(b);//adding button in JFrame  


        JLabel l = new JLabel("Hello, world!");
        l.setBounds(130,100,100, 40);
        f.add(l);

        JTextField t=new JTextField("asdf");
        // t.setBounds(130,100,100, 40);
        f.add(t);
        
        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 
    }

    // play sound
    // count
    // receive user input

    // GUI
        // select audio? 
        // time remaining / passed?

}
