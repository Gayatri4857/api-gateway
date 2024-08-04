package org.dnyanyog.repo;

import java.util.List;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UsersRepository extends JpaRepository<Users, Long> {
	List<Users> findByEmailIDAndPasswords(String emailID, String passwords); // Declaration
	
	List<Users> findByUsername(String nameToSearch);




}
