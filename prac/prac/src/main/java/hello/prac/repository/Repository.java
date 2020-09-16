package hello.prac.repository;

import hello.prac.Domain.Student;

import java.util.List;
import java.util.Optional;

public interface Repository {
    Student save(Student st);
    Optional<Student> findByName (String name);
    Optional<Student> findById (String id);
    List<Student> findAll();
}
