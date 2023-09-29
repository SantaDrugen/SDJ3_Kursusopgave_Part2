package dk.via.sdj3_kursusopgave_part2.Client.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Animal does not exist")
public class AnimalDoesNotExistException extends RuntimeException {

}
