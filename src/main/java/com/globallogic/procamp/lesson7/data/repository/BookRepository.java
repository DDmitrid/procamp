package com.globallogic.procamp.lesson7.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.globallogic.procamp.lesson7.data.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    @Nullable
    Book findByName(@Nullable String name);
    
}


    //    List<Book> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

/*
     Enables the distinct flag for the query
    List<People> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
    List<People> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);
*/
    
/*
     Enabling ignoring case for an individual property
    List<Book> findByLastnameIgnoreCase(String lastname);
*/
     
/*

     Enabling ignoring case for all suitable properties
    List<Book> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);
*/
     

/* 
    Enabling static ORDER BY for a query
    
    List<Book> findByLastnameOrderByFirstnameAsc(String lastname);
    List<Book> findByLastnameOrderByFirstnameDesc(String lastname);
    Page<User> findByLastname(String lastname, Pageable pageable);

    Slice<User> findByLastname(String lastname, Pageable pageable);

    List<User> findByLastname(String lastname, Sort sort);

    List<User> findByLastname(String lastname, Pageable pageable);
*/


/*
    Limiting Query Results

    User findFirstByOrderByLastnameAsc();

    User findTopByOrderByAgeDesc();

    Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);

    Slice<User> findTop3ByLastname(String lastname, Pageable pageable);

    List<User> findFirst10ByLastname(String lastname, Sort sort);

    List<User> findTop10ByLastname(String lastname, Pageable pageable);
*/
//}





//
//    long countByLastname(String lastname);
//
//    long deleteByLastname(String lastname);
//
//    List<String> removeByLastname(String lastname);
//
//    /**
//     * Throws an EmptyResultDataAccessException when the query executed does not produce a result. 
//     * Throws an IllegalArgumentException when the emailAddress handed to the method is null.
//     */
//    Book getByEmailAddress(EmailAddress emailAddress);
//
//    /**
//     * Returns null when the query executed does not produce a result.
//     * Also accepts null as the value for emailAddress.
//     */
//    @Nullable
//    Book findByEmailAddress(@Nullable EmailAddress emailAdress);
//
//    /**
//     * 	Returns Optional.empty() when the query executed does not produce a result. 
//     * 	Throws an IllegalArgumentException when the emailAddress handed to the method is null.
//     */
//    Optional<Book> findOptionalByEmailAddress(EmailAddress emailAddress);
//    
//}
