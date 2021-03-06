import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    public void listAllFiles(){
        int position = 0;
        while (position < files.size()){ 
            String filename = files.get(position);
            position ++;
            System.out.println(position + ".- " + filename);
        }
    }
    
    public void listMatching(String searchString) {
        boolean siExiste = false;
        for (String filename : files) {
            if (filename.contains(searchString)){    
                siExiste = true;
                System.out.println(filename);
            }
        }
        
        if (siExiste == false){
            System.out.println("No existe ninguna cancion con " + searchString);
        }
    }
    
    public void playSamplesArtist(String artista){
        for (String filename : files) {
            if (filename.contains(artista)){
                player.playSample(filename);
            }
        }
    }
    
    public int findFirst(String searchString){
        boolean existe = true;
        int index = 0;
        int valor = 0;
        while (index < files.size() && existe) {
            String filename = files.get(index);
            if (filename.contains(searchString)){
                existe = false;
                valor = index;
            }
            else{
                index++;
            }
        }
        
        if (existe == true){
            valor = -1;
        }
        
        return valor;
    }
    
    /** Prueba de ejercicio que no funciona
     * 
    public void deleteSongsWithText(String cancion){
        for (String filename : files) {
            if (filename.contains(cancion)){    
                files.remove(filename);
            }
        }
    }
    */
}
