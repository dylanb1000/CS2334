import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Playlist class stores and modifies song objects in an Arraylist
 * 
 * @author CS2334
 * @author Dylan Bui
 *
 */
public class Playlist {
	
	private ArrayList<Song> songs;
	/**
	 * Default constructor, all fields are specified.
	 * @throws FileNotFoundException if the file is not found
	 */
	public Playlist() {
		this.songs=new ArrayList<Song>();
	}
	/**
	 * Accessor method for the Arraylist of songs
	 * @return Amount of songs stored in the Array list in the form of an integer
	 */
	public int getNumSongs() {
		return songs.size();
	}
	/**
	 * Accessor method for the Arraylist of songs
	 * @param index Integer used to specify the index of the song that will be returned
	 * @return Song at specified index
	 */
	public Song getSong(int index) {
		if (index < 0 || index >= getNumSongs()) {
			return null;
		}
		return songs.get(index);
	}
	/**
	 * Accessor method for the Arraylist of songs
	 * @return returns entire array of songs
	 */
	public Song[] getSongs() {
		return songs.toArray(new Song[0]);
	}
	/**
	 * Method used to add an individual song to the end of the Arraylist
	 * @param Song that will be added to the Arraylist of songs
	 * @return returns true if song was successfully added to the Arraylist and false otherwise
	 */
	public boolean addSong(Song song) {
		return addSong(getNumSongs(), song);
	}
	/**
	 * Method used to add a specified song at a specified index of the Arraylist
	 * @param index Integer used to specify the index of the song that will be added
	 * @param Song that will be added to the Arraylist of songs
	 * @return returns true if song was successfully added to the Arraylist and false otherwise
	 */
	public boolean addSong(int index, Song song) {
		if(song==null || index<0 || index>this.songs.size()) {
			return false;
		}
		else {
			songs.add(index,song);
			return true;
		}

	}
	/**
	 * Method used to add a Playlist of songs to another playlist
	 * @param Playlist that contains songs to be added
	 * @return returns the amount of songs that was added in the form of an integer
	 */
	public int addSongs(Playlist playlist) {
		if(playlist==null) {
			return 0;
		}
		else {
			int count=0;
			ArrayList<Song> copy=new ArrayList<Song>(playlist.songs);
			
			for(int i=0;i<copy.size();i++) {
				this.songs.add(copy.get(i));
				count++;
			}
			return count;
		}
	}
	/**
	 * Method used to remove the last song of a playlist
	 * 
	 */
	public Song removeSong() {
		return removeSong(getNumSongs() - 1);
	}
	/**
	 * Method used to remove a specified song at a specified index of the Arraylist
	 * @param index Integer used to specify the index of the song that will be removed
	 * @return returns the song that removed. returns null if song was not removed
	 */
	public Song removeSong(int index) {
		if(index<0 || index>songs.size()-1) {
			return null;
		}
		else {
			Song removedSong=songs.get(index);
			songs.remove(index);
			return removedSong;
		}
	}
	/**
	 * Constructor method create a playlist filled with songs from a file
	 * @param filename that contains the songs to be added
	 * @throws IOException 
	 */
	public Playlist(String filename) throws IOException {
		this.songs=new ArrayList<Song>();
		BufferedReader br=new BufferedReader(new FileReader(filename));
		String content="";
		while((content=br.readLine())!=null) {
			Song newSong=new Song(content);
			songs.add(newSong);
		}
		
	}
	/**
	 * Method used to add songs from a file to an Arraylist of songs
	 * @param filename that contains the songs to be added
	 * @throws IOException 
	 */
	public void addSongs(String filename) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(filename));
		String content="";
		while((content=br.readLine())!=null) {
			Song newSong=new Song(content);
			songs.add(newSong);
		}
	}
	/**
	 * Method used to return all songs in string format
	 * @return String of all the songs in the playlist in the format{title; artist;time}
	 * 
	 */
	public String toString() {
		String songString="";
		for(int i=0;i<songs.size();i++) {
			songString=songString.concat(songs.get(i).toString());
			if(i!=songs.size()-1) {
			songString=songString.concat(System.lineSeparator());
			}
		}
		return songString;
	}
	/**
	 * Method used to save or overwrite the current songs in the Arraylist to a specified filename
	 * @param filename used to specify the location where the songs will be saved
	 * @throws IOException 
	 * 
	 */
	public void saveSongs(String filename) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		bw.write(this.toString());
		bw.close();
	}
	/**
	 * Method used to receive the total amount of time of the songs in a playlist
	 * @return an Integer array of the total time in the format{seconds,minutes,hours}
	 * 
	 * 
	 */
	public int[] getTotalTime() {
		int seconds=0;
		int minutes=0;
		int hours=0;
		
		for(int i=0;i<songs.size();i++) {
			if(songs.get(i).getTime().length==1) {
				seconds+=songs.get(i).getTime()[0];
			}
			else if(songs.get(i).getTime().length==2) {
				minutes+=songs.get(i).getTime()[1];
				seconds+=songs.get(i).getTime()[0];
			}
			else if(songs.get(i).getTime().length==3) {
				hours+=songs.get(i).getTime()[2];
				minutes+=songs.get(i).getTime()[1];
				seconds+=songs.get(i).getTime()[0];
			}
		}
			if(seconds>=60) {
				int mod=seconds%60;
				int round=seconds/60;
				seconds=mod;
				minutes+=round;
			}
			if(minutes>=60) {
				int mod=minutes%60;
				int round=minutes/60;
				minutes=mod;
				hours+=round;
			}
			if(hours==0 && minutes==0) {
			int[] finalTime= {seconds};
			return finalTime;
			}
			else if(hours==0) {
				int[] finalTime= {seconds,minutes};
				return finalTime;
				}
			else{
				int[] finalTime= {seconds,minutes,hours};
				return finalTime;
				}
			
			
		}
	}

