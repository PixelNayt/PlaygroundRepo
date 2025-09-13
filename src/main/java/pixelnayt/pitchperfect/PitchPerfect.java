package pixelnayt.pitchperfect; // remove if not Netbeans IDE
import java.io.*;
import javax.sound.sampled.*;
import java.util.*;

//test comment new change

public class PitchPerfect {
    //GET PIANO MAJOR SCALES: Decide what Piano Major Scale to use
    private static final String [] piano_CMajorNotes = {"C4", "D4", "E4", "F4", "G4", "A4", "B4", "C5"}; //
    private static final String [] piano_DMajorNotes = {"D4", "E4", "F#4", "G4", "A4", "B4", "C#5", "D5"}; //
    private static final String [] piano_EMajorNotes = {"E4", "F#4", "G#4", "A4", "B4", "C#5", "D#5", "E5"}; //
    private static final String [] piano_FMajorNotes = {"F4", "G4", "A4", "Bb", "C5", "D5", "E5", "F5"}; //
    private static final String [] piano_GMajorNotes = {"G4", "A4", "B4", "C5", "D5", "E5", "F#5", "G5"}; //
    private static final String [] piano_AMajorNotes = {"A4", "B4", "C#5", "D5", "E5", "F#5", "G#5", "A5"}; //
    private static final String [] piano_BMajorNotes = {"B4", "C#5", "D#5", "E5", "F#5", "G#5", "A#5", "B5"}; //
    
    //MAJOR SCALE NOTE SELECTION FOR PIANO
    public static String getRandomMajorScale(String [] majorNotesArray){
        Random random = new Random();
        int randomNote = random.nextInt(majorNotesArray.length);
        return majorNotesArray[randomNote];
    }

    //PLAY PIANO AUDIO NOTE
    public static void playInstrumentScaleNote(String note, String scaleName) throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        File audioFile = new File(note + scaleName + ".wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile); 
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();
        clip.drain();
    }
    
    //GET GUITAR MAJOR SCALES: Decide what Guitar Major Scale to use
    private static final String [] aGuitar_CMajorNotes = {"C4", "D4", "E4", "F4", "G4", "A4", "B4", "C5"}; //
    private static final String [] aGuitar_DMajorNotes = {"D4", "E4", "F#4", "G4", "A4", "B4", "C#5", "D5"}; //
    private static final String [] aGuitar_EMajorNotes = {"E4", "F#4", "G#4", "A4", "B4", "C#5", "D#5", "E5"}; //
    private static final String [] aGuitar_FMajorNotes = {"F4", "G4", "A4", "Bb", "C5", "D5", "E5", "F5"}; //
    private static final String [] aGuitar_GMajorNotes = {"G4", "A4", "B4", "C5", "D5", "E5", "F#5", "G5"}; //
    private static final String [] aGuitar_AMajorNotes = {"A4", "B4", "C#5", "D5", "E5", "F#5", "G#5", "A5"}; //
    private static final String [] aGuitar_BMajorNotes = {"B4", "C#5", "D#5", "E5", "F#5", "G#5", "A#5", "B5"}; //
    
    //UI TO PICK A SCALE TO PLAY
    public static void pickMajorScaleToPlay() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Scanner scan = new Scanner(System.in);
        String instrument = "";
        
        do {
            int instrumentChoice = 0;
            
            Boolean validInstrument = false;
            while (!validInstrument){
                try {
                    System.out.println("===================================================");
                    System.out.println("Choose an Instrument:");
                    System.out.println("|1| Piano");
                    System.out.println("|2| Acoustic Guitar");
                    System.out.print("Enter your choice: ");
                    instrumentChoice = scan.nextInt();
                    scan.nextLine();
                    if(instrumentChoice == 1){
                        instrument = "piano";
                        validInstrument = true;
                    } else if (instrumentChoice == 2){
                        instrument = "aGuitar";
                        validInstrument = true;
                    } else {
                        System.out.println("==================================================");
                        System.out.println("Invalid Input! Please Try Again!");
                    }
                    
                } catch (Exception e){
                    System.out.println("==================================================");
                    System.out.println("Invalid Input! Please Try Again!");
                    scan.next();
                }  
            }
        } while (!instrument.equals("piano") && !instrument.equals("aGuitar"));   
        
        if(instrument.equals("piano")){
            Boolean validPianoScale = false;
            
            while (!validPianoScale) {
                try {
                    System.out.println("===================================================");
                    System.out.println("Choose a Major Scale to Play:");
                    System.out.println("|1| C Major");
                    System.out.println("|2| D Major");
                    System.out.println("|3| E Major");
                    System.out.println("|4| F Major");
                    System.out.println("|5| G Major");
                    System.out.println("|6| A Major");
                    System.out.println("|7| B Major");
                    System.out.println("|8| EXIT");

                    System.out.print("Enter your choice: ");
                    int scaleChoice = scan.nextInt();
                    validPianoScale = true;

                    switch (scaleChoice) {
                        case 1:
                            MajorScaleGame(piano_CMajorNotes, "C Major Scale", "piano_CMajorNotes");
                            break;
                        case 2:
                            MajorScaleGame(piano_DMajorNotes, "D Major Scale", "piano_DMajorNotes");
                            break;
                        case 3:
                            MajorScaleGame(piano_EMajorNotes, "E Major Scale", "piano_EMajorNotes");
                            break;
                        case 4:
                            MajorScaleGame(piano_FMajorNotes, "F Major Scale", "piano_FMajorNotes");
                            break;
                        case 5:
                            MajorScaleGame(piano_GMajorNotes, "G Major Scale", "piano_GMajorNotes");
                            break;
                        case 6:
                            MajorScaleGame(piano_AMajorNotes, "A Major Scale", "piano_AMajorNotes");
                            break;
                        case 7:
                            MajorScaleGame(piano_BMajorNotes, "B Major Scale", "piano_BMajorNotes");
                            break;
                        case 8:
                            System.out.println("\nGoing back to Main Menu...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please select a valid Scale or Exit the program");
                    }
                } catch (Exception e) {
                    System.out.println("==================================================");
                    System.out.println("Invalid Input! Please Try Again!");
                    scan.next();
                }
            }
        } else if (instrument.equals("aGuitar")){
            Boolean validAGuitarScale = false;
            
            while (!validAGuitarScale) {
                try {
                    System.out.println("===================================================");
                    System.out.println("Choose a Major Scale to Play:");
                    System.out.println("|1| C Major");
                    System.out.println("|2| D Major");
                    System.out.println("|3| E Major");
                    System.out.println("|4| F Major");
                    System.out.println("|5| G Major");
                    System.out.println("|6| A Major");
                    System.out.println("|7| B Major");
                    System.out.println("|8| EXIT");

                    System.out.print("Enter your choice: ");
                    int scaleChoice = scan.nextInt();
                    validAGuitarScale = true;

                    switch (scaleChoice) {
                        case 1:
                            MajorScaleGame(aGuitar_CMajorNotes, "C Major Scale", "aGuitar_CMajorNotes");
                            break;
                        case 2:
                            MajorScaleGame(aGuitar_DMajorNotes, "D Major Scale", "aGuitar_DMajorNotes");
                            break;
                        case 3:
                            MajorScaleGame(aGuitar_EMajorNotes, "E Major Scale", "aGuitar_EMajorNotes");
                            break;
                        case 4:
                            MajorScaleGame(aGuitar_FMajorNotes, "F Major Scale", "aGuitar_FMajorNotes");
                            break;
                        case 5:
                            MajorScaleGame(aGuitar_GMajorNotes, "G Major Scale", "aGuitar_GMajorNotes");
                            break;
                        case 6:
                            MajorScaleGame(aGuitar_AMajorNotes, "A Major Scale", "aGuitar_AMajorNotes");
                            break;
                        case 7:
                            MajorScaleGame(aGuitar_BMajorNotes, "B Major Scale", "aGuitar_BMajorNotes");
                            break;
                        case 8:
                            System.out.println("\nGoing back to Main Menu...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please select a valid Scale or Exit the program");
                    }
                } catch (Exception e) {
                    System.out.println("==================================================");
                    System.out.println("Invalid Input! Please Try Again!");
                    scan.next();
                }
            }
        }
    }
    
    //MAIN GAME
    public static void MajorScaleGame(String [] selectedMajorScale, String currentScale, String appendInstrumentScale) throws UnsupportedAudioFileException, LineUnavailableException, IOException, FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        int userScore = 0;
        int numberOfRounds = 10;
        boolean continueGame = true; 
        boolean replayGame = false;
        
        while(continueGame == true){
            System.out.println("==================================================");
            System.out.println("\nWelcome to the " + currentScale + " Game!");
            System.out.println("You will be given " + numberOfRounds + " Random Notes from the " + currentScale + " and will have to guess the Note one at a time!");
            
            int userChoice = 0;
            boolean startGameConfirm = false;
            do{
                try {
                    System.out.println("Type 1 to START\nType 2 to QUIT");
                    System.out.print("Enter Choice: ");
                    userChoice = scan.nextInt();
                    scan.nextLine();
                    System.out.println("");
                    startGameConfirm = true;
                } catch (Exception e){
                    System.out.println("==================================================");
                    System.out.println("Invalid Input! Please Try Again!");
                    scan.next();
                }
            } while(!startGameConfirm);
            
            if(userChoice == 1){
                do{
                    for(int round = 1; round <= 10; round++){
                    String noteToGuess = getRandomMajorScale(selectedMajorScale);
                    playInstrumentScaleNote(noteToGuess, appendInstrumentScale);
                    System.out.println("---------------------------------------------------");
                    System.out.println("Round: " + round + " of " + numberOfRounds);
                    System.out.println("Score: " + userScore + " out of " + numberOfRounds);
                    System.out.println("CHOICES: " + String.join(" ", selectedMajorScale));
                    System.out.println("---------------------------------------------------");
                    System.out.print("Enter Note: ");
                    String userGuess = scan.nextLine();

                    if(noteToGuess.equals(userGuess)){
                        userScore += 1;
                        System.out.println("CORRECT! The Note is " + noteToGuess);
                        System.out.println("===================================================");
                    } else {
                        System.out.println("INCORRECT! The Note should be " + noteToGuess);
                        System.out.println("===================================================");
                    }
                    }
                    System.out.println("YOUR FINAL SCORE: " + userScore + " out of " + numberOfRounds);
                    userScore = 0;
                    
                    //Replay System
                    String replayOption = "A";
                    do{                      
                        System.out.println("Would you like to try again?\n[A]YES\n[B]NO");
                        System.out.print("Enter Choice: ");
                        replayOption = scan.nextLine().toUpperCase();
                        if(replayOption.equals("A")){
                            replayGame = true;
                            break;
                        } else if(replayOption.equals("B")){
                            replayGame = false;
                            continueGame = false;
                            break;
                        } else {
                            System.out.println("===================================================");
                            System.out.println("Invalid Option, Please Try Again!");
                        }
                    } while (!"A".equals(replayOption) || !"B".equals(replayOption));
                } while (replayGame == true);        
            } else if (userChoice == 2){
                continueGame = false;
            } else {
                System.out.println("Invalid Input! Please Try Again!");
            }
        }   
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        Scanner scan = new Scanner(System.in);
        Boolean continueProgram = true;
        
        //Main Menu: Start Game or Exit
        while (continueProgram) {
            Boolean validMainMenuChoice = false;
            
            while(!validMainMenuChoice){
                try{
                    System.out.println("===================================================");
                    System.out.println("NOTE RECOGNATION GAME MAIN MENU");
                    System.out.println("[1] Play Game");
                    System.out.println("[2] Exit");
                    System.out.print("\nSELECT: ");

                    int choice = scan.nextInt();

                    switch (choice) {
                        case 1:
                            validMainMenuChoice = true;
                            pickMajorScaleToPlay();
                            break;
                        case 2:
                            validMainMenuChoice = true;
                            System.out.println("\nExiting the program...");
                            continueProgram = false;
                            break;
                        default:
                            System.out.println("\nInvalid choice. Please Select 1 or 2.");
                    }
                } catch (Exception e) {
                    System.out.println("==================================================");
                    System.out.println("Invalid Input! Please Try Again!");
                    scan.next();
                }
            }
        }
        scan.close();
    }
}
