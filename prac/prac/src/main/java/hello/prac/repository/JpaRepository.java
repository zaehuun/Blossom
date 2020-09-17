package hello.prac.repository;

import hello.prac.Domain.Student;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Repository
public class JpaRepository implements Repository {

    private final EntityManager em;

    public JpaRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public Student save(Student st) {
        em.persist(st);
        return st;
    }

    @Override
    public Optional<Student> findByName(String name) {
        Student st = em.find(Student.class, name);
        return Optional.ofNullable(st);
    }

    @Override
    public Optional<Student> findById(String id) {
        List<Student> result = em.createQuery("select m from Student m where m.id = :id", Student.class).setParameter("id",id).getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Student> findAll() {
        List<Student> result = em.createQuery("select m from Student m", Student.class).getResultList();
        return result;
    }
}
