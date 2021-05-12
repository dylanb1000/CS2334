import java.util.Arrays;
/**
 * Song class used to create and modify song object that 
 * has parameters such as title,artist and time length of song.
 * 
 * @author CS2334
 * @author Dylan Bui
 *
 */
public class Song {
	
	private String title;
	private String artist;
	private int[] time;
	private static final String INFO_DELIMITER="; ";
	private static final String TIME_DELIMITER=":";
	private static final int IDX_TITLE=0;
	private static final int IDX_ARTIST=1;
	private static final int IDX_TIME=2;
	/**
	 * Explicit constructor, all fields are specified.
	 * 
	 * @param title		Title of the song
	 * @param artist 	Artist who wrote the song
	 * @param time		Song length of Array in format as follows{seconds, minutes, hours}
	 * 
	 * @throws FileNotFoundException if the file is not found
	 */
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		this.time = Arrays.copyOf(time, time.length);
	}
	/**
	 * Constructor, parses info to create constructor
	 * 
	 * @param info	String containing title, artist and time
	 * 
	 * 
	 * @throws FileNotFoundException if the file is not found
	 */
	public Song(String info) {
		String[] parsedInfo=info.split(INFO_DELIMITER,3);
		this.title=parsedInfo[0];
		this.artist=parsedInfo[1];
		String[] timeArrayString=parsedInfo[2].split(TIME_DELIMITER,3);
		int[] timeArrayInt=new int[timeArrayString.length];
		if(timeArrayString.length==1) {
			timeArrayInt[0]=(Integer.parseInt(timeArrayString[0]));
		}
		else if(timeArrayString.length==2) {
			timeArrayInt[0]=(Integer.parseInt(timeArrayString[1]));
			timeArrayInt[1]=(Integer.parseInt(timeArrayString[0]));
		}
		else if(timeArrayString.length==3) {
			timeArrayInt[0]=(Integer.parseInt(timeArrayString[2]));
			timeArrayInt[1]=(Integer.parseInt(timeArrayString[1]));
			timeArrayInt[2]=(Integer.parseInt(timeArrayString[0]));
		}
		
		
		
		this.time=Arrays.copyOf(timeArrayInt, timeArrayInt.length);
		
	}	
	/**
	 * Accessor method for the title field
	 * @return title of the song as a string
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Accessor method for the artist field
	 * @return artist who wrote the song as a string
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * Accessor method for the time field
	 * @return time array that represents length of song in format{seconds, minutes, hours}
	 */
	public int[] getTime() {
		return Arrays.copyOf(time, time.length);
	}
	/**
	 * Mutator method to give song parameters in String format
	 * 
	 */
	public String toString() {
		if(this.time.length==1) {
		 String titleString=String.format("%s%s%s%s%d",this.title,INFO_DELIMITER,this.artist,INFO_DELIMITER,this.time[0]);
		 return titleString;
		}
		else if(this.time.length==2) {
			 String titleString=String.format("%s%s%s%s%d%s%02d",this.title,INFO_DELIMITER,this.artist,INFO_DELIMITER,this.time[1],TIME_DELIMITER,this.time[0]);
			 return titleString;
			}
		else if(this.time.length==3) {
			 String titleString=String.format("%s%s%s%s%d%s%02d%s%02d",this.title,INFO_DELIMITER,this.artist,INFO_DELIMITER,this.time[2],TIME_DELIMITER,this.time[1],TIME_DELIMITER,this.time[0]);
			 return titleString;
			}
		else {
			return "";
		}
	}
}
