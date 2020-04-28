package api.models.validation;

import api.models.Book;
import api.models.exceptions.ValidatorException;


public class BookValidator implements Validator<Book> {
    @Override
    public void validate(Book object) throws ValidatorException {
        if (object.getPrice() <= 0)
            throw new ValidatorException("Invalid Book Price");
    }
}
