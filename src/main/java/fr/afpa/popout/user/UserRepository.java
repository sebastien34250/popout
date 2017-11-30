package fr.afpa.popout.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	 @Query("SELECT user FROM User user WHERE user.id =:id")
	    @Transactional(readOnly = true)
	    User findById(@Param("id") Integer id);

}
