package de.alphahelix.alphalibary.core.utils.implementations;

import de.alphahelix.alphalibary.core.utils.abstracts.AbstractArrayUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IArrayUtil extends AbstractArrayUtil {
	
	public final <T> T[] makeArray(T... types) {
		return types;
	}
	
	public Player[] makePlayerArray(List<String> types) {
		List<Player> playerArrayList = new ArrayList<>();
		
		for(String type : types) {
			if(Bukkit.getPlayer(type) == null) continue;
			playerArrayList.add(Bukkit.getPlayer(type));
		}
		
		return playerArrayList.toArray(new Player[playerArrayList.size()]);
	}
	
	public Player[] makePlayerArray(Set<String> types) {
		List<Player> playerArrayList = new ArrayList<>();
		
		for(String type : types) {
			if(Bukkit.getPlayer(type) == null) continue;
			playerArrayList.add(Bukkit.getPlayer(type));
		}
		
		return playerArrayList.toArray(new Player[playerArrayList.size()]);
	}
	
	public Vector[] makeVectorArray(Location... locations) {
		Vector[] vectors = new Vector[locations.length];
		
		for(int i = 0; i < vectors.length; i++)
			vectors[i] = locations[i].toVector();
		
		return vectors;
	}
	
	public Vector[] makeLocationArray(World world, Vector... vectors) {
		Location[] locations = new Location[vectors.length];
		
		for(int i = 0; i < locations.length; i++)
			locations[i] = vectors[i].toLocation(world);
		
		return vectors;
	}
	
	public String[] replaceInArray(String pattern, String replace, String... array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = array[i].replace(pattern, replace);
		}
		return array;
	}
	
	public <T> List<T> getTypesOf(Class<T> clazzType, List<Object> inList) {
		List<T> types = new ArrayList<>();
		for(Object e : inList)
			if(e.getClass().isInstance(clazzType))
				types.add((T) e);
		return types;
	}
	
	public void checkForArguments(Object[] array, int min, int max) {
		if(array.length < min || array.length > max)
			throw new ArrayIndexOutOfBoundsException("You have to at least parse " + min + " arguments and up to " + max);
	}
	
	@SafeVarargs
	public final <T> T[] replaceInArray(T obj, int pos, T... array) {
		T[] clone = array.clone();
		
		clone[pos] = obj;
		
		return clone;
	}
	
	public double min(double... a) {
		double lowest = a[0];
		
		for(double l : a)
			lowest = Math.min(l, lowest);
		
		return lowest;
	}
	
	public int min(int... a) {
		int lowest = a[0];
		
		for(int l : a)
			lowest = Math.min(l, lowest);
		
		return lowest;
	}
	
	public long min(long... a) {
		long lowest = a[0];
		
		for(long l : a)
			lowest = Math.min(l, lowest);
		
		return lowest;
	}
	
	public float min(float... a) {
		float lowest = a[0];
		
		for(float l : a)
			lowest = Math.min(l, lowest);
		
		return lowest;
	}
	
	public double max(double... a) {
		double highest = a[0];
		
		for(double l : a)
			highest = Math.max(l, highest);
		
		return highest;
	}
	
	public int max(int... a) {
		int highest = a[0];
		
		for(int l : a)
			highest = Math.max(l, highest);
		
		return highest;
	}
	
	public long max(long... a) {
		long highest = a[0];
		
		for(long l : a)
			highest = Math.max(l, highest);
		
		return highest;
	}
	
	public float max(float... a) {
		float highest = a[0];
		
		for(float l : a)
			highest = Math.max(l, highest);
		
		return highest;
	}
	
	public double sum(double... a) {
		double sum = a[0];
		
		for(double s : a)
			sum += s;
		
		return sum;
	}
	
	public int sum(int... a) {
		int sum = a[0];
		
		for(int s : a)
			sum += s;
		
		return sum;
	}
	
	public float sum(float... a) {
		float sum = a[0];
		
		for(float s : a)
			sum += s;
		
		return sum;
	}
	
	public long sum(long... a) {
		long sum = a[0];
		
		for(long s : a)
			sum += s;
		
		return sum;
	}
	
}