package camt.FitUp.Project.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Film on 25/7/2559.
 */
@Entity
public class ImageUser {

    @Id
    @GeneratedValue
    private Long id;

    private String fileName;
    @Lob
    private byte[] content;
    private String contentType;

    @Temporal(TemporalType.TIMESTAMP)
    Date created;

    public ImageUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date create) {
        this.created = create;
    }

    public ImageUser(String fileName, byte[] content, String contentType, Date created) {
        this.fileName = fileName;
        this.content = content;
        this.contentType = contentType;
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageUser imageUser = (ImageUser) o;

        if (id != null ? !id.equals(imageUser.id) : imageUser.id != null) return false;
        if (fileName != null ? !fileName.equals(imageUser.fileName) : imageUser.fileName != null) return false;
        if (!Arrays.equals(content, imageUser.content)) return false;
        if (contentType != null ? !contentType.equals(imageUser.contentType) : imageUser.contentType != null)
            return false;
        return created != null ? created.equals(imageUser.created) : imageUser.created == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }
}
