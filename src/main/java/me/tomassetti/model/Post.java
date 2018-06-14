package me.tomassetti.model;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class Post {
    private UUID post_uuid;
    private String title;
    private String content;
    private Date publishing_date;
    private List<String> categories;
    
	public UUID getPost_uuid() {
		return post_uuid;
	}
	public void setPost_uuid(UUID post_uuid) {
		this.post_uuid = post_uuid;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
