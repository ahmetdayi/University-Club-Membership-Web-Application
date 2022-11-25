package com.project.clubmembership.core.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatus status,
                                                                  @NonNull WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BudgetDoesntExistException.class)
    public ResponseEntity<?> budgetDoesntExistExceptionHandler(BudgetDoesntExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClubDoesntArrangeEventYetException.class)
    public ResponseEntity<?> ClubDoesntArrangeEventYetExceptionHandler(ClubDoesntArrangeEventYetException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ClubDoesntExistException.class)
    public ResponseEntity<?> clubDoesntExistExceptionHandler(ClubDoesntExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ClubHasntMemberYetException.class)
    public ResponseEntity<?> clubHasNotMemberYetExceptionHandler(ClubHasntMemberYetException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EventDoesntExistException.class)
    public ResponseEntity<?> eventDoesntExistExceptionHandler(EventDoesntExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MemberDoesntEnrollEventYetException.class)
    public ResponseEntity<?> memberDoesntEnrollEventYetExceptionHandler(MemberDoesntEnrollEventYetException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MemberDoesntExistException.class)
    public ResponseEntity<?> memberDoesntExistExceptionHandler(MemberDoesntExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SponsorDoesntExistException.class)
    public ResponseEntity<?> sponsorDoesntExistExceptionHandler(SponsorDoesntExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MemberAlreadyExistException.class)
    public ResponseEntity<?> memberAlreadyExistExceptionHandler(MemberAlreadyExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MemberAlreadyEnrollEventException.class)
    public ResponseEntity<?> memberAlreadyEnrollEventExceptionHandler(MemberAlreadyEnrollEventException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MemberAlreadyEnrollClubException.class)
    public ResponseEntity<?> memberAlreadyEnrollClubExceptionHandler(MemberAlreadyEnrollClubException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MemberAlreadyCreateClubException.class)
    public ResponseEntity<?> memberAlreadyCreateClubExceptionHandler(MemberAlreadyCreateClubException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(EventPlaceDoesntEmptyException.class)
    public ResponseEntity<?> eventPlaceDoesntEmptyExceptionHandler(EventPlaceDoesntEmptyException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ClubIsAlreadyExistException.class)
    public ResponseEntity<?> clubIsAlreadyExistExceptionHandler(ClubIsAlreadyExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(CLubAlreadyArrangeEventAtTimeException.class)
    public ResponseEntity<?> clubAlreadyArrangeEventAtTimeExceptionHandler(CLubAlreadyArrangeEventAtTimeException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }





}
