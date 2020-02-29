package com.pablo.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pablo.workshopmongo.dto.AuthorDTO;
import com.pablo.workshopmongo.dto.CommentDTO;

@Document
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String Id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	private List<CommentDTO> comments = new ArrayList<>();
	
	public Post() {
		
	}

	public Post(String id, Date date, String title, String body, AuthorDTO author) {
		super();
		Id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	public AuthorDTO getAuthor() {
		return author;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	
}
