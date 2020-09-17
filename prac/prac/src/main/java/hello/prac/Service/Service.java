package hello.prac.Service;

import hello.prac.repository.JpaRepository;
import hello.prac.repository.Repository;

public class Service {
    private final Repository repository;

    public Service(Repository repository){
        this.repository = repository;
    }
}
