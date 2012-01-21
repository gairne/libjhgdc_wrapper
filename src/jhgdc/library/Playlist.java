/*
 * Copyright 2012  Matthew Mole <code@gairne.co.uk>
 * 
 * This file is part of libjhgdc_wrapper.
 * 
 * libjhgdc_wrapper is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * libjhgdc_wrapper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with libjhgdc_wrapper.  If not, see <http://www.gnu.org/licenses/>.
 */
package jhgdc.library;

import java.util.ArrayList;

/**
 * A class representing a Playlist AT THE POINT OF INSTANTIATION.
 * If data obtained by a call to libjhgdc is left for a large period of time
 * then a Playlist object created from it, the Playlist will be out of date.
 */
public class Playlist {

	private ArrayList<PlaylistItem> items;
	
	/**
	 * @author Matthew Mole
	 * @param items An already instantiated ArrayList of PlaylistItems.
	 */
	public Playlist(ArrayList<PlaylistItem> items) {
		this.items = items;
	}
	
	/**
	 * @author Matthew Mole
	 * @return the ArrayList of PlaylistItems in the playlist at the time of instantiation.
	 */
	public ArrayList<PlaylistItem> getItems() {
		return this.items;
	}
	
	/**
	 * @author Matthew Mole
	 * @return True if the playlist is empty.
	 */
	public boolean isEmpty() {
		if (this.items == null) {
			return true;
		}
		return this.items.size() == 0;
	}
}
