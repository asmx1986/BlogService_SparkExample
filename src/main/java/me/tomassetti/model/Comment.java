package me.tomassetti.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Comment {
    UUID comment_uuid;
    UUID post_uuid;
    private String author;
    private String content;
    boolean approved;
    Date submission_date;
    
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
