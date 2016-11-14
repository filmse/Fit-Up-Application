package camt.FitUp.Project.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Film on 25/7/2559.
 */
@Entity
public class ImageUser {

        @Id
        @GeneratedValue
        private Long id;

        String fileName;
        @Lob
        byte[] content;
        String contentType;

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
}
