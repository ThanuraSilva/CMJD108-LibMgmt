package lk.ijse.cmjd108.LibMgmt2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO implements Serializable {
    private String bookId;
    private String bookName;
    private String author;
    private String edition;
    private String publisher;
    private String isbn;
    private Double price;
    private Integer totalQty;
    private Integer avilableQty;
    private String lastUpdateDate;
    private String lastUpdateTime;

//    public BookDTO(String bookId, String bookName, String author, String edition, String publisher, String isbn, Double price, Integer totalQty, Integer avilableQty, String lastUpdateDate, String lastUpdateTime) {
//        this.bookId = bookId;
//        this.bookName = bookName;
//        this.author = author;
//        this.edition = edition;
//        this.publisher = publisher;
//        this.isbn = isbn;
//        this.price = price;
//        this.totalQty = totalQty;
//        this.avilableQty = avilableQty;
//        this.lastUpdateDate = lastUpdateDate;
//        this.lastUpdateTime = lastUpdateTime;
//    }
//
//    public BookDTO() {
//    }
//
//    public String getBookId() {
//        return bookId;
//    }
//
//    public void setBookId(String bookId) {
//        this.bookId = bookId;
//    }
//
//    public String getBookName() {
//        return bookName;
//    }
//
//    public void setBookName(String bookName) {
//        this.bookName = bookName;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getEdition() {
//        return edition;
//    }
//
//    public void setEdition(String edition) {
//        this.edition = edition;
//    }
//
//    public String getPublisher() {
//        return publisher;
//    }
//
//    public void setPublisher(String publisher) {
//        this.publisher = publisher;
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public Integer getTotalQty() {
//        return totalQty;
//    }
//
//    public void setTotalQty(Integer totalQty) {
//        this.totalQty = totalQty;
//    }
//
//    public Integer getAvilableQty() {
//        return avilableQty;
//    }
//
//    public void setAvilableQty(Integer avilableQty) {
//        this.avilableQty = avilableQty;
//    }
//
//    public String getLastUpdateDate() {
//        return lastUpdateDate;
//    }
//
//    public void setLastUpdateDate(String lastUpdateDate) {
//        this.lastUpdateDate = lastUpdateDate;
//    }
//
//    public String getLastUpdateTime() {
//        return lastUpdateTime;
//    }
//
//    public void setLastUpdateTime(String lastUpdateTime) {
//        this.lastUpdateTime = lastUpdateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "BookDTO{" +
//                "bookId='" + bookId + '\'' +
//                ", bookName='" + bookName + '\'' +
//                ", author='" + author + '\'' +
//                ", edition='" + edition + '\'' +
//                ", publisher='" + publisher + '\'' +
//                ", isbn='" + isbn + '\'' +
//                ", price=" + price +
//                ", totalQty=" + totalQty +
//                ", avilableQty=" + avilableQty +
//                ", lastUpdateDate='" + lastUpdateDate + '\'' +
//                ", lastUpdateTime='" + lastUpdateTime + '\'' +
//                '}';
//    }
}
