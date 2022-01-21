package tw.com.rex.k8stester.api.web.request;

import java.io.Serializable;

public class Name implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
