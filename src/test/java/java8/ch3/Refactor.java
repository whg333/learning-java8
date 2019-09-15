package java8.ch3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import java8.music.Album;
import java8.music.Track;

public class Refactor {

	public Set<String> oldFindLongTracks(List<Album> albums) {
	    Set<String> trackNames = new HashSet<>();
	    for(Album album : albums) {
	        for (Track track : album.getTrackList()) {
	            if (track.getLength() > 60) {
	                String name = track.getName();
	                trackNames.add(name);
	            }
	        }
	    }
	    return trackNames;
	}
	
	public Set<String> findLongTracks(List<Album> albums) {
		return albums.stream()
				.map(album -> album.getTrackList())
				.flatMap(trackList -> trackList.stream())
				.filter(track -> track.getLength() > 60)
				.map(track -> track.getName())
				.collect(Collectors.toSet());
	}
	
}
