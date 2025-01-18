package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.BookService;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {
    @Override
    public void addBook(BookDTO bookDTO) {
        //Business Process
        bookDTO.setBookId(UtilData.generateBookId());
        bookDTO.setLastUpdateDate(String.valueOf(UtilData.generateTodayDate()));
        bookDTO.setLastUpdateTime(String.valueOf(UtilData.generateCurrentTime()));
        System.out.println(bookDTO);
    }

    @Override
    public void deleteBook(String bookId) {

    }

    @Override
    public void updateBook(String bookId, BookDTO bookDTO) {

    }

    @Override
    public BookDTO getSelectedBook(String bookId) {
        return (new BookDTO("B005",
                "Spring boot -2025",
                "Kamal Perera",
                "2024",
                "Oxford publisher",
                "14466-56136",
                500.0,
                50,
                10,
                "2024-01-11",
                "10.25"
        ));
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookList = new ArrayList<>();
        bookList.add(new BookDTO(
                "B005",
                "Spring boot -2025",
                "Kamal Perera",
                "2024",
                "Oxford publisher",
                "14466-56136",
                500.0,
                50,
                10,
                "2024-01-11",
                "10.25"
        ));

        bookList.add(new BookDTO(
                "B45454",
                "Java Programming",
                "Nimal Silva",
                "2023",
                "Pearson",
                "978-3-16-148410-0",
                650.0,
                70,
                20,
                "2024-01-10",
                "09.15"
        ));

        bookList.add(new BookDTO(
                "B88",
                "Data Structures and Algorithms",
                "Sunil Fernando",
                "2022",
                "McGraw Hill",
                "978-0-07-013151-4",
                750.0,
                40,
                15,
                "2024-01-05",
                "11.45"
        ));

        bookList.add(new BookDTO(
                "B6563",
                "Microservices Architecture",
                "Aruna Perera",
                "2025",
                "Packt",
                "978-1-78588-243-6",
                850.0,
                30,
                5,
                "2024-01-08",
                "14.30"
        ));

        bookList.add(new BookDTO(
                "B98998",
                "Cloud Computing Essentials",
                "Kavinda Jayasuriya",
                "2021",
                "Wiley",
                "978-0-470-28255-0",
                900.0,
                60,
                25,
                "2024-01-12",
                "16.00"
        ));
        return bookList;
    }
}
