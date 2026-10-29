package psu.se411.lab14.controller.CourseController;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import psu.se411.lab14.model.Course;
import psu.se411.lab14.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        Course toSave = new Course(null, course.code(), course.name(),
                course.description(), course.credits());
        Course saved = repository.save(toSave);
        return ResponseEntity.created(URI.create("/courses/" + saved.id())).body(saved);
    }

    @GetMapping
    public List<Course> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Course updated = new Course(id, course.code(), course.name(),
                course.description(), course.credits());
        return ResponseEntity.ok(repository.save(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
