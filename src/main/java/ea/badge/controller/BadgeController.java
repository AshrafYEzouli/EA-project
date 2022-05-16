package ea.badge.controller;

import ea.badge.domain.Badge;
import ea.badge.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/badges")
public class BadgeController {
    @Autowired
    private BadgeService service;

    @GetMapping
    public Collection<Badge> getAll() { return service.findAll(); }
    @GetMapping("/{id}")
    public Badge getById(@PathVariable("id") Integer id) { return service.findById(id); }

    @PostMapping @PutMapping
    public Badge createOrUpdate(@RequestBody Badge badge) { return service.createOrUpdate(badge); }
    @PostMapping("/{id}/replace")
    public Badge replaceWithNew(@RequestBody Badge badge) { return service.replaceWithNew(badge); }
    @PutMapping("/{id}/deactivate")
    public Badge deactivate(@RequestBody Badge badge) { return service.deactivateById(badge.getId()); }

    @PutMapping("/{id}/activate")
    public Badge activate(@RequestBody Badge badge) { return service.activateById(badge.getId()); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) { service.deleteById(id); }
}
