package java8.ch3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java8.music.Album;
import java8.music.Artist;
import java8.music.SampleData;

public class Exercise {

	@Test
	public void testAddUp(){
		Assert.assertEquals(6, addUp(Stream.of(1, 2, 3)));
		Assert.assertEquals(10, addUp(Stream.of(1, 2, 3, 4)));
		Assert.assertEquals(15, addUp(Stream.of(1, 2, 3, 4, 5)));
	}
	
	private int addUp(Stream<Integer> numbers){
		return numbers.reduce(0, (acc, ele) -> acc + ele);
	}
	
	@Test
	public void showNameAndNationalityOfArtist(){
		showNameAndNationality(SampleData.getThreeArtists()).stream()
			.forEach(nameAndNationality -> System.out.println(nameAndNationality));
	}
	
	private List<String> showNameAndNationality(List<Artist> artistList){
		return artistList.stream()
				.map(artist -> "name:"+artist.getName()+", nationality:"+artist.getNationality())
				.collect(Collectors.toList());
	}
	
	@Test
	public void showAtMost3TracksOfAlbum(){
		showAtMost3Tracks(SampleData.getThreeAlbums()).stream()
				.forEach(album -> System.out.println(album));
	}
	
	private List<Album> showAtMost3Tracks(List<Album> albumList){
		return albumList.stream()
				.filter(album -> album.getTracks().count() <= 3)
				.collect(Collectors.toList());
	}
	
	@Test
	public void testExternalIteration(){
		List<Artist> artists = SampleData.getThreeArtists();
		int totalMembers = 0;
		for(Artist artist:artists){
			Stream<Artist> members = artist.getMembers();
			totalMembers += members.count();
		}
		Assert.assertEquals(4, totalMembers);
	}
	
	@Test
	public void testInternalIteration(){
		List<Artist> artists = SampleData.getThreeArtists();
		long totalMembers = artists.stream()
			.flatMap(artist -> artist.getMembers())
			.count();
		Assert.assertEquals(4, totalMembers);
	}
	
	/**
	 * 3、
	 * a、及早求值，因为会立即返回明确的boolean值
	 * b、惰性求值，因为返回的是Stream流，可以等待后续继续进行组装配合其他流操作
	 * 
	 * 4、
	 * a、是，因为该函数的参数接受一个函数接口Predicate
	 * b、不是，该函数的参数接受的是一个long值而非函数接口，且其返回值为Stream而并非一个函数接口
	 * 
	 * 5、
	 * x -> x + 1	这个没有副作用，应该只是做了下计算操作，而没有涉及到其他变量状态的修改
	 * musician -> count.incAndGet()	这个是有副作用的，因为已经在修改变量count的值了
	 */
	
	@Test
	public void testCountStringLowercaseNum(){
		String str = "AaBbCcDdEeFfGg";
		long lowercaseNum = str.chars()
			.filter(intChar -> (intChar >= 97 && intChar <= 122))
			.count();
		Assert.assertEquals(7, lowercaseNum);
	}
	
	@Test
	public void testFindMaxLowercaseNumOfStringList(){
		long count = Arrays.asList("AbCDefG", "HIjKLmn", "opqrstu")
			.stream()
			.map(str -> str.chars())
			.map(chars -> chars.filter(intChar -> (intChar >= 97 && intChar <= 122)).count())
			.max(Comparator.comparing(value -> value))
			.get();
		Assert.assertEquals(7, count);
	}
	
}
