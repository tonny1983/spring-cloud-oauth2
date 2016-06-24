package cc.tonny.springclouddemo.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cc.tonny.springclouddemo.person.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
