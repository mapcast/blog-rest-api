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
import lombok.Setter;

@Entity
@Table(name = "comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_number")
    private Long rownumber;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 36)
    private String uuid;
	
	@Column(name = "writer", nullable = false)
    private String writer;
	
	@Column(name = "writer_id", length = 36)
    private String writerId;
	
	@Column(name = "writer_password")
    private String writerPassword;
	
	@Column(name = "post_id", nullable = false, length = 36)
    private String postId;
	
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted = false;
	
	@Column(name = "created_time_at")
	@CreationTimestamp
	private Date createdTimeAt;
	
	@Column(name = "updated_time_at")
	@UpdateTimestamp
	private Date updatedTimeAt;
}
