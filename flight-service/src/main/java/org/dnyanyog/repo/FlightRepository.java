package org.dnyanyog.repo;

import java.util.List;

import org.dnyanyog.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository 
@Component
public interface FlightRepository extends JpaRepository<Flights, Long>{
  
	List<Flights> findByflightname(String flight_search);
}