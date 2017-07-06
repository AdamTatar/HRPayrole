package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
