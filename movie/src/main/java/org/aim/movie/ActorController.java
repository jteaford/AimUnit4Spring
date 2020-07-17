package org.aim.movie;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/actors")

public class ActorController {
    
    @Autowired
    private ActorRepository actorRepository;

    @GetMapping(path = "")
    public @ResponseBody Iterable<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @PostMapping(path = "/")
    public @ResponseBody String createActor(@RequestBody Actor actor) {
        actorRepository.save(actor);
        return "Saved";
    }

}