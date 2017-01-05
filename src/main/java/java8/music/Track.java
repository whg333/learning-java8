/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package java8.music;

/**
 * 专辑中的一支曲目
 * @author richard
 */
public final class Track {
    
    private final String name;
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }
    
    @Override
	public String toString() {
		return "Track [name=" + name + ", length=" + length + "]";
	}

	/**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the length of the track in milliseconds.
     */
    public int getLength() {
        return length;
    }

    public Track copy() {
        return new Track(name, length);
    }

}
