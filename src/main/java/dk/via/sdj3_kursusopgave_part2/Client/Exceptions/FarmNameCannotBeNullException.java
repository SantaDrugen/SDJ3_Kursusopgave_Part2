package dk.via.sdj3_kursusopgave_part2.Client.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Farm Name Cannot Be Null Exception")

public class FarmNameCannotBeNullException extends RuntimeException{

}
