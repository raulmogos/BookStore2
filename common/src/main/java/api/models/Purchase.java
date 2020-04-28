package api.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Purchase extends BaseEntity<Long> implements Serializable {
    Long bookId;
    Long clientId;

    public Purchase (Long id, Long bookId, Long clientId) {
        this.id = id;
        this.bookId = bookId;
        this.clientId = clientId;
    }

    public Purchase(Long bookId, Long clientId, LocalDate lastModifiedDate) {
        this.bookId = bookId;
        this.clientId = clientId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Purchase: " + "id: " + id + ", bookId: " + bookId + ", clientId: " + clientId;
    }
}
