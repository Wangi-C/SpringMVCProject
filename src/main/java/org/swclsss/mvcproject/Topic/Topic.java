package org.swclsss.mvcproject.Topic;

import java.io.Serializable;

public class Topic implements Serializable {
    private String title;
    private String contents;

    public Topic() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
