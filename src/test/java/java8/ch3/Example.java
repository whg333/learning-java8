package java8.ch3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import java8.music.Track;

public class Example {
	
	@Test
	public void flatMap(){
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
				.flatMap(numbers -> numbers.stream())
				.collect(Collectors.toList());
		Assert.assertEquals(Arrays.asList(1, 2, 3, 4), together);
	}
	
	@Test
	public void min(){
		List<Track> tracks = Arrays.asList(
				new Track("Bakai", 524),
				new Track("Violets for Your Furs", 378),
				new Track("Time Was", 451));
		Track shortestTrack = tracks.stream()
				.min(Comparator.comparing(track -> track.getLength()))
				.get();
		Assert.assertEquals(tracks.get(1), shortestTrack);
	}
	
	@Test
	public void max(){
		List<Track> tracks = Arrays.asList(
				new Track("Bakai", 524),
				new Track("Violets for Your Furs", 378),
				new Track("Time Was", 451));
		Track longestTrack = tracks.stream()
				.max(Comparator.comparing(track -> track.getLength()))
				.get();
		Assert.assertEquals(tracks.get(0), longestTrack);
	}
	
	@Test
	public void reduce(){
		int sum = Stream.of(1, 2, 3, 4)
			.reduce(0, (acc, ele) -> acc + ele);
		Assert.assertEquals(10, sum);
		
		int count = Stream.of(1, 2, 3, 4)
				.reduce(0, (acc, ele) -> acc + 1);
		Assert.assertEquals(4, count);
		
		int min = Stream.of(3, 2, 1, 4)
				.reduce(1, (acc, ele) -> ele < acc ? ele : acc);
		Assert.assertEquals(1, min);
		
		int max = Stream.of(3, 2, 1, 4)
				.reduce(0, (acc, ele) -> ele > acc ? ele : acc);
		Assert.assertEquals(4, max);
	}
	
}
