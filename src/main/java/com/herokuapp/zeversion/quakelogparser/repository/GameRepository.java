package com.herokuapp.zeversion.quakelogparser.repository;

import com.herokuapp.zeversion.quakelogparser.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
