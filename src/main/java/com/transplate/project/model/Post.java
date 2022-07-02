package com.transplate.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_number")
    private Long rowNumber;
	
	@Column(name = "category", nullable = false)
    private String category;
	
	@Column(name = "subject", nullable = false)
    private String subject;
	
	@Column(name = "contents", columnDefinition = "TEXT")
	private String contents;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted = false;
}
