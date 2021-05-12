public class Song {
	private String title;
	private String artist;
	private int[] time;
	public Song(String title,String artist,int[] time) {
		this.title=title;
		this.artist=artist;
		int[] newTime=java.util.Arrays.copyOf(time, time.length);
		this.time=newTime;
	}
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public int[] getTime() {
		int[] newTime=java.util.Arrays.copyOf(time, time.length);
		return newTime;
	}
}
