
public class Playlist {
private Song[] songs;
private int numSongs;
private static final int MIN_CAPACITY=3;
public Playlist() {
	this.songs=new Song[MIN_CAPACITY];
}
public Playlist(int capacity) {
	if(capacity<=MIN_CAPACITY) {
		this.songs=new Song[MIN_CAPACITY];
	}
	else if(capacity>MIN_CAPACITY){
		this.songs=new Song[capacity];
		
	}
}
public int getCapacity() {
	return songs.length;
}
public int getNumSongs() {
	return numSongs;
}
public Song getSong(int index) {
	if(index<0 || index>=songs.length) {
		return null;
	}
	else {
		return songs[index];
	}
	
}
public Song[] getSongs() {
	Song[] Songlist=new Song[numSongs];
	for(int i=0;i<songs.length;i++) {
		if(songs[i]!=null) {
			Songlist[i]=songs[i];
		}
	}
	return Songlist;
	
}
public boolean addSong(Song song) {
	if(song==null) {
		return false;
	}
	for(int i=0;i<songs.length;i++) {
		if(songs[i]==null) {
			numSongs++;
			songs[i]=song;
			return true;
		}
	}
	return false;
}
public boolean addSong(int index,Song song) {
	if(numSongs==songs.length) {
		return false;
	}
	else if(index<0 || index>numSongs) {
		return false;
	}
	else if(song==null) {
		return false;
	}
	else{
		
		for(int j=index;j<numSongs;j++) {
			songs[j+1]=songs[j];
			
		}
		songs[index]=song;
		numSongs++;
		return true;
		}
	}
public int addSongs(Playlist playlist) {
	if(playlist==null){
		return 0;
	}
	Song[] copy=java.util.Arrays.copyOf(playlist.songs, playlist.getCapacity());
	int count=0;
		for(int i=0;i<copy.length;i++) {
			if(copy[i]!=null) {
			for(int j=0;j<songs.length;j++) {
					if(songs[j]==null) {
						songs[j]=copy[i];
						numSongs++;
						count++;
						break;
					}
				}
			}
		}
		System.out.println("finished");
	
return count;
}
public Song removeSong() {
	boolean deleted=false;
	Song deletedSong=null;
	for(int i=songs.length-1;i>-1;i--) {
		if(songs[i]!=null) {
			numSongs--;
			deletedSong=songs[i];
			songs[i]=null;
			deleted=true;
			break;
		}
	}
	if(deleted==false) {
		return null;
	}
	return deletedSong;
}
public Song removeSong(int index) {
	Song removedSong=null;
	if(index<0 || index>songs.length||songs[index]==null ) {
		return null;
	}
	else {
		removedSong=songs[index];
		songs[index]=null;
		for(int i=index;i<songs.length-1;i++) {
			songs[i]=songs[i+1];
		}
		numSongs--;
		return removedSong;
	}
}
}





