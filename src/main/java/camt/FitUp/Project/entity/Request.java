package camt.FitUp.Project.entity;

import javax.persistence.*;

/**
 * Created by Film on 5/11/2559.
 */

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String request;

    public Request(String request) {
        this.request = request;
    }

    public Request(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (id != null ? !id.equals(request.id) : request.id != null) return false;
        return this.request != null ? this.request.equals(request.request) : request.request == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (request != null ? request.hashCode() : 0);
        return result;
    }
}
