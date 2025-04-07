package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.AutorDTO;
import application.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public Iterable<AutorDTO> list() {
        return autorService.getAll();
    }

    @GetMapping("/{id}")
    public AutorDTO findOne(@PathVariable long id) {
        return autorService.getOne(id);
    }

    @PostMapping
    public AutorDTO insert(@RequestBody AutorDTO autor) {
        return autorService.insert(autor);
    }

    @PutMapping("/{id}")
    public AutorDTO update(@PathVariable long id, @RequestBody AutorDTO autor) {
        return autorService.update(id, autor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        autorService.delete(id);
    }
}
