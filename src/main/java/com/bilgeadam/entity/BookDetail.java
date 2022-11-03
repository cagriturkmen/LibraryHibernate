package com.bilgeadam.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class BookDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name ="is_borrowed")
	private boolean isBorrowed;
	@Column(name ="book_borrow_date")
	private LocalDate bookBorrowDate;
	@Column(name ="book_return_date")
	private LocalDate bookReturnDate;
	@OneToOne(mappedBy= "bookDetail")
	@JoinColumn(name="book_id",referencedColumnName = "id")
	private Book book;
    
}
