package me.tomassetti.handlers;

import lombok.Data;
import me.tomassetti.Validable;

import java.util.LinkedList;
import java.util.List;

/**
* Created by federico on 24/07/15.
*/
@Data
class NewPostPayload implements Validable {
    private String title;
    private List<String> categories = new LinkedList<>();
    private String content;

    public boolean isValid() {
        return getTitle() != null && !getTitle().isEmpty() && getContent() != null && !getContent().isEmpty();
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
