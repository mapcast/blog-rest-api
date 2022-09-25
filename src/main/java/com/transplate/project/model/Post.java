	package com.transplate.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rownumber")
    private Long rownumber;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 36)
    private String uuid;
	
	@Column(name = "category", nullable = false)
    private String category;
	
	@Column(name = "subject", nullable = false)
    private String subject;
	
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	
	@Builder.Default
	@Column(name = "is_deleted")
	private Boolean isDeleted = false;
	
	@Column(name = "created_time_at")
	@CreationTimestamp
	private Date createdTimeAt;
	
	@Column(name = "updated_time_at")
	@UpdateTimestamp
	private Date updatedTimeAt;
	
	@Builder.Default
	@OneToMany(mappedBy = "post")
	private List<Comment> comments = new ArrayList<>();
}
