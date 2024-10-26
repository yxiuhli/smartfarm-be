package com.dadn.smartfarm.repository;

import com.dadn.smartfarm.entity.Actuator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActuatorRepository extends JpaRepository<Actuator, Long>{

}
