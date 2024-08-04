package org.dnyanyog.repo;

import java.util.List;

import org.dnyanyog.entity.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface PassengersRepository extends JpaRepository<Passengers, Long>{
	List<Passengers> findByusername(String passenger_search);
}
