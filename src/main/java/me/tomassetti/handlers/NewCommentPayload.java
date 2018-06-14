package me.tomassetti.handlers;

import lombok.Data;
import me.tomassetti.Validable;

/**
* Created by federico on 24/07/15.
*/
@Data
class NewCommentPayload implements Validable {
    private String author;
    private String content;

    public boolean isValid() {
        return getAuthor() != null && !getAuthor().isEmpty() && getContent() != null && !getContent().isEmpty();
    }

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
