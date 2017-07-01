package pl.coderslab.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Test;

public interface TestRepository extends JpaRepository<Test, Long> {


	
}
