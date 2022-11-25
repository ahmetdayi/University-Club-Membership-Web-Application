package com.project.clubmembership.core.validator;


import com.project.clubmembership.entity.dto.CreateMemberRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        CreateMemberRequest member = ( CreateMemberRequest) obj;
        return member.getPassword().equals(member.getPasswordMatch());
    }


}