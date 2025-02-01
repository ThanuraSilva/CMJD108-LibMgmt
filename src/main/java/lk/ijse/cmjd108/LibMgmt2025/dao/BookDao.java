package lk.ijse.cmjd108.LibMgmt2025.dao;

import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<BookEntity,String> {
    // JPQL query
    @Query("SELECT SUM(b.avilableQty) FROM BookEntity b WHERE b.bookId = :bookId ")
    int avlilQty(@Param("bookId") String bookId);
    // deduct book count based on lending
    @Modifying
    @Query("UPDATE BookEntity b SET b.avilableQty = b.avilableQty - 1 WHERE b.bookId = :bookId AND b.avilableQty > 0")
    int deductBasedOnLending(@Param("bookId") String bookId);
    @Modifying
    @Query("UPDATE BookEntity b SET b.avilableQty = b.avilableQty + 1 WHERE b.bookId = :bookId")
    void addBookBasedBookHandover(@Param("bookId") String bookId);
}
