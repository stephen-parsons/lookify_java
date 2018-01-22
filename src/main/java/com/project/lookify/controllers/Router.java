package com.project.lookify.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.lookify.services.SongService;
import com.project.lookify.models.Song;

@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	
	private final SongService songService;
    public Router(SongService songService){
        this.songService = songService;
    }

	@RequestMapping("")
	public String index(){
		return "index";
	}

	@RequestMapping("dashboard")
	public String dashboard(Model model){
		model.addAttribute("songs", songService.allSongs());
		return "dashboard";
	}

	@RequestMapping("add")
	public String add(@ModelAttribute("song") Song song){
		return "add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }else{
            songService.addSong(song);
            return "redirect:/dashboard";
        }
    }

    @RequestMapping(value="/songs/delete/{id}")
	public String delete(@PathVariable("id") Long id){
		songService.destroySong(id);
		return "redirect:/dashboard";
	}

	@PostMapping("search")
	public String search(@RequestParam(value="artist") String artist, Model model){
		model.addAttribute("songs", songService.getSongsByArtist(artist));
		return "search";
	}

	@RequestMapping("top")
	public String top(Model model){
		model.addAttribute("songs", songService.topTen());
		return "top";
	}

	@RequestMapping("songs/{id}")
	public String top(Model model, @PathVariable("id") Long id){
		model.addAttribute("song", songService.findSongById(id));
		return "song";
	}
	
}
