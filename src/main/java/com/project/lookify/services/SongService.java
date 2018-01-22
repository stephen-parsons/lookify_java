package com.project.lookify.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.lookify.repositories.SongRepository;
import com.project.lookify.models.Song;

@Service
public class SongService {
	// Member variables / service initializations go here
		
	private SongRepository songRepository;

    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    public List<Song> allSongs(){
        return songRepository.findAll();
    }
    public void addSong(Song song){
        songRepository.save(song);
    }

    public Song findSongById(Long id) {
        return songRepository.findOne(id);
    }

    public void updateSong(Song song) {
        songRepository.save(song);
    }

    public void destroySong(Long id) {
        songRepository.delete(id);
    }

    public List<Song> getSongsByArtist(String artist){
    	List<Song> Songs = allSongs();
    	List<Song> Search = new ArrayList<Song>();
		for (Song x : Songs) {
			if (x.getArtist().equals(artist)){
				Search.add(x);
			}
		}
		return Search;
    }

 	public List<Song> topTen(){
 		return songRepository.findAllByOrderByRatingDesc();
 	}
}
