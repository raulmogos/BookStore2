package ro.bookstore2.models.validation;


import ro.bookstore2.models.exceptions.ValidatorException;

public interface Validator<T> {
    void validate(T object) throws ValidatorException;
}
