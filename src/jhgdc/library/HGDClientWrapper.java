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

import java.io.IOException;
import java.util.ArrayList;

public class HGDClientWrapper extends HGDClient {

	/**
	 * Parse input obtained from HGDClient.requestPlaylist() and return a populated Playlist.
	 * Dependent on the format of result of requestPlaylist (and subsequently the protocol version)
	 * 
	 * @author Matthew Mole
	 * @param inputs An array of expected format: <track-id>|<filename>|<artist>|<title>|<user>
	 * @return A Playlist object instantiated with an ArrayList of PlaylistItems, parsed from the given input
	 */
	public Playlist getPlaylist() throws IllegalArgumentException, JHGDException, IOException, IllegalStateException {
		ArrayList<PlaylistItem> items = new ArrayList<PlaylistItem>();
		
		for (String input : requestPlaylist()) {
			String[] sa = input.split("\\|");
			if (sa.length == 14) {
				items.add(new PlaylistItem(sa[0], sa[1], sa[2], sa[3], sa[4], sa[5], sa[6], sa[7], sa[8], sa[9], sa[10], sa[11], sa[12], sa[13]));
			}
			else {
				throw new IllegalArgumentException("input incorrect format " + input);
			}
		}
		
		return new Playlist(items);
	}
	
	/**
	 * Parse input obtained from HGDClient.requestNowPlaying() and return a populated PlaylistItem.
	 * Dependent on the format of result of requestNowPlaying (and subsequently the protocol version)
	 * 
	 * @param input
	 *            An input of expected format: ok|0 or ok|?|<track-id>|<filename>|<artist>|<title>|<user>
	 * @return
	 *            A PlaylistItem object instantiated with an current song data, parsed from the given input
	 */
	public PlaylistItem getCurrentPlaying() throws IllegalArgumentException, JHGDException, IOException, IllegalStateException {
		String input = requestNowPlaying();
		String[] sa = input.split("\\|");
		if (input.split("\\|").length == 2) { //ok|0 = not playing
			return null;
		}
		else if (sa.length == 16) {
			return new PlaylistItem(sa[2], sa[3], sa[4], sa[5], sa[6], sa[7], sa[8], sa[9], sa[10], sa[11], sa[12], sa[13], sa[14], sa[15]);
		}
		else {
			throw new IllegalArgumentException("input incorrect format " + input);
		}
	}
}
