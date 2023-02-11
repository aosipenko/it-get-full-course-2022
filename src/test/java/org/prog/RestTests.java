package org.prog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.prog.dto.PersonDto;
import org.prog.dto.RootDto;

public class RestTests {

  @Test
  public void myRestTest() throws JsonProcessingException {
    Response response = RestAssured.get("https://randomuser.me/api/?inc=gender,name,nat&results=20");
    RootDto rootDto = response.body().as(RootDto.class);

    PersonDto person = rootDto.getResults().stream()
        .filter(p -> p.getGender().equals("male"))
            .findFirst().get();

    String searchQuery = person.getName().getFirst() + " " + person.getName().getLast();


    System.out.println(rootDto.getInfo().getSeed());
    System.out.println(rootDto.getResults().get(0).getName().getFirst());
    System.out.println(rootDto.getResults().get(0).getName().getLast());

    System.out.println(objectToString(rootDto));
  }

  @Test
  public void mapperTest() throws JsonProcessingException {
    List<Passenger> passengers = new ArrayList<>();
    passengers.add(new Passenger("Jane"));
    passengers.add(new Passenger("John"));
    passengers.add(new Passenger("Alice"));
    passengers.add(new Passenger("Bob"));

    Car car = new Car(passengers);

    System.out.println(objectToString(car));

    String carString =
        "{\"passengers\":[{\"name\":\"Jane\"},{\"name\":\"John\"},{\"name\":\"Alice\"},{\"name\":\"Bob\"}]}";
    Car clonedCar = stringToObject(carString);
    System.out.println(clonedCar.getPassengers().get(0).getName());
  }

  private String objectToString(Object dto) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(dto);
  }

  private Car stringToObject(String input) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(input, Car.class);
  }
}
