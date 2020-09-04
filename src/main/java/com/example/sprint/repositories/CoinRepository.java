package com.example.sprint.repositories;

import com.example.sprint.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long>{
}
