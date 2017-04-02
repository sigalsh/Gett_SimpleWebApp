package simplewebapp;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface DriversRepository extends CrudRepository<Driver, Integer>  { 
    Optional<Driver> findById(int driverId);

}

