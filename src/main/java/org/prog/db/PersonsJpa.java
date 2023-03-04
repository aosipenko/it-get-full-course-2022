package org.prog.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsJpa extends JpaRepository<Persons, Long> {

}
