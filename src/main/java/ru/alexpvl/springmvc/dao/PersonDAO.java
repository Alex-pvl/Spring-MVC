package ru.alexpvl.springmvc.dao;

import org.springframework.stereotype.Component;
import ru.alexpvl.springmvc.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
	private static int PEOPLE_COUNT = 0;
	private List<Person> people;

	{
		people = new ArrayList<>();

		people.add(new Person(++PEOPLE_COUNT, "Tom", 23, "tom@gmail.com"));
		people.add(new Person(++PEOPLE_COUNT, "Richard", 32, "richard@gmail.com"));
		people.add(new Person(++PEOPLE_COUNT, "Alex", 26, "alex@gmail.com"));
		people.add(new Person(++PEOPLE_COUNT, "Ben", 41, "ben@gmail.com"));
		people.add(new Person(++PEOPLE_COUNT, "Harry", 19, "harry@gmail.com"));
	}

	public List<Person> index() {
		return people;
	}

	public Person show(int id) {
		return people.stream()
				.filter(p -> p.getId() == id)
				.findAny()
				.orElse(null);
	}

	public void save(Person person) {
		person.setId(++PEOPLE_COUNT);
		people.add(person);
	}

	public void update(int id, Person person) {
		Person personToUpdate = show(id);
		personToUpdate.setName(person.getName());
		personToUpdate.setAge(person.getAge());
		personToUpdate.setEmail(person.getEmail());
	}

	public void delete(int id) {
		people.removeIf(p -> p.getId() == id);
	}
}
