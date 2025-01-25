package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dao.BookDao;
import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lk.ijse.cmjd108.LibMgmt2025.exception.BookNotFoundException;
import lk.ijse.cmjd108.LibMgmt2025.service.BookService;
import lk.ijse.cmjd108.LibMgmt2025.util.EntityDTOConvert;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceIMPL implements BookService {
    private final BookDao bookDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addBook(BookDTO bookDTO) {
        //Business Process
        bookDTO.setBookId(UtilData.generateBookId());
        bookDTO.setLastUpdateDate(UtilData.generateTodayDate());
        bookDTO.setLastUpdateTime(UtilData.generateCurrentTime());
        //Pass to Dao
        var bookEntity = entityDTOConvert.convertBookDTOToBookEntity(bookDTO);
        bookDao.save(bookEntity);
    }

    @Override
    public void deleteBook(String bookId) {
        //is Avlble
        Optional<BookEntity> foundBook = bookDao.findById(bookId);
        if(!foundBook.isPresent()){
            throw new BookNotFoundException("Book not found");
        }
        bookDao.deleteById(bookId);

    }

    @Override
    public void updateBook(String bookId, BookDTO bookDTO) {
        Optional<BookEntity> foundBook = bookDao.findById(bookId);
        if(!foundBook.isPresent()){
            throw new BookNotFoundException("Book not found");
        }
        foundBook.get().setBookName(bookDTO.getBookName());
        foundBook.get().setAuthor(bookDTO.getAuthor());
        foundBook.get().setEdition(bookDTO.getEdition());
        foundBook.get().setPublisher(bookDTO.getPublisher());
        foundBook.get().setIsbn(bookDTO.getIsbn());
        foundBook.get().setPrice(bookDTO.getPrice());
        foundBook.get().setTotalQty(bookDTO.getTotalQty());
        foundBook.get().setAvilableQty(bookDTO.getAvilableQty());
        foundBook.get().setLastUpdateDate(UtilData.generateTodayDate());
        foundBook.get().setLastUpdateTime(UtilData.generateCurrentTime());
    }

    @Override
    public BookDTO getSelectedBook(String bookId) {
        return null;
    }

    @Override
    public List<BookDTO> getAllBooks() {
      return null;
    }
}
