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

/**
 * A class representing a PlaylistItem AT THE POINT OF INSTANTIATION.
 * If data obtained by a call to libjhgdc is left for a large period of time
 * then a PlaylistItem object created from it, the PlaylistItem will be out of date.
 */
public class PlaylistItem {

	private String trackId, filename, artist, title, user, album, genre, duration, bitrate, samplerate, channels, year, votesneeded, voted;
	
	/**
	 * @author Matthew Mole
	 * @param trackId The ID of the song, typically an incrementing natural
	 * @param filename The filename of the uploaded song
	 * @param artist The song's artist
	 * @param title The song's title
	 * @param user The user who uploaded the file
	 */
	public PlaylistItem(String trackId, String filename, String artist, String title, String user, String album, String genre, String duration, String bitrate, String samplerate, String channels, String year, String votesneeded, String voted) {
		this.trackId = trackId;
		this.filename = filename;
		this.artist = artist;
		this.title = title;
		this.user = user;
		this.album = album;
		this.genre = genre;
		this.duration = duration;
		this.bitrate = bitrate;
		this.samplerate = samplerate;
		this.channels = channels;
		this.year = year;
		this.votesneeded = votesneeded;
		this.voted = voted;
	}
	
	/**
	 * @return The trackId
	 */
	public String getId() {
		return this.trackId;
	}
	
	/**
	 * @return The filename
	 */
	public String getFilename() {
		return this.filename;
	}
	
	/**
	 * @return The artist
	 */
	public String getArtist() {
		return this.artist;
	}
	
	/**
	 * @return The song title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * @return The user who enqueued the file
	 */
	public String getUser() {
		return this.user;
	}
	
	public String getAlbum() {
		return this.album;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public String getDuration() {
		return this.duration;
	}
	
	public String getBitrate() {
		return this.bitrate;
	}
	
	public String getSamplerate() {
		return this.samplerate;
	}
	
	public String getChannels() {
		return this.channels;
	}
	
	public String getYear() {
		return this.year;
	}
	
	public String getVotesNeeded() {
		return this.votesneeded;
	}
	
	/**
	 * 
	 * @return "0" if the user has not voted, "1" if the user has, and "-1" if not logged in.
	 */
	public String haveVoted() {
		return this.voted;
	}
	
	/**
	 * @return True if there is no current song playing
	 */
	public boolean isEmpty() {
		return false;
	}
}
