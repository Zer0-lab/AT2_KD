package henrotaym.env.repositories;

import henrotaym.env.entities.Characters;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CharacterRepository
    extends JpaRepository<Characters, BigInteger>, QuerydslPredicateExecutor<Characters> {}
