package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.TaxOffice;

public interface TaxOfficeRepository extends JpaRepository<TaxOffice, Long> {

}
