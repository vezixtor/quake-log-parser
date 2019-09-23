package com.herokuapp.zeversion.quakelogparser.repository;

import com.herokuapp.zeversion.quakelogparser.model.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {
}
