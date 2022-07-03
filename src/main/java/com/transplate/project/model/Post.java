package com.transplate.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
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
	
	@Column(name = "created_time_at")
	@CreationTimestamp
	private Date createdTimeAt;
	
	@Column(name = "updated_time_at")
	@UpdateTimestamp
	private Date updatedTimeAt;
}
