package dk.via.sdj3_kursusopgave_part2.Client.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Weight cannot be negative")
public class WeightCannotBeNegativeException extends RuntimeException {

}
