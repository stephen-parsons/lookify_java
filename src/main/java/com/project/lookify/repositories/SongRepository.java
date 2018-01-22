package com.project.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.lookify.services.SongService;
import com.project.lookify.models.Song;

@Repository 												
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findAllByOrderByRatingDesc();
}
