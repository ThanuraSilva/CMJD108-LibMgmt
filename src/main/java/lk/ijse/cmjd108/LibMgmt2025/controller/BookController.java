package lk.ijse.cmjd108.LibMgmt2025.controller;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
     @GetMapping("health")
     public String healthTest(){
         return "Book Controller is running";
     }
     @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO){
          System.out.println(bookDTO);
          return new ResponseEntity<>(HttpStatus.CREATED);
     }
     @DeleteMapping
     public ResponseEntity<Void> deleteBook(@RequestParam ("bookIdKey") String bookIdValue){
          System.out.println(bookIdValue);
          return ResponseEntity.noContent().build();
     }
     @PatchMapping(value = "/{bookId}",consumes = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Void> updateBook(@PathVariable String bookId, @RequestBody BookDTO bookDTO){
          System.out.println(bookId);
          System.out.println(bookDTO);
          return ResponseEntity.noContent().build();
     }
     @GetMapping("{bookId}")
     public ResponseEntity<BookDTO> getSelectedBook(@PathVariable String bookId){
          System.out.println("Get selected book for "+bookId);
          return ResponseEntity.ok(new BookDTO("B005",
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
     @GetMapping
     public ResponseEntity<List<BookDTO>> getAllBooks(){
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
          return ResponseEntity.ok(bookList);
     }



}
