package api.models.validation;

import api.models.exceptions.ValidatorException;

public interface Validator<T> {
    void validate(T object) throws ValidatorException;
}
