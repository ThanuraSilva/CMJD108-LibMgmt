package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dao.BookDao;
import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lk.ijse.cmjd108.LibMgmt2025.service.BookService;
import lk.ijse.cmjd108.LibMgmt2025.util.EntityDTOConvert;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    }

    @Override
    public void updateBook(String bookId, BookDTO bookDTO) {

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
