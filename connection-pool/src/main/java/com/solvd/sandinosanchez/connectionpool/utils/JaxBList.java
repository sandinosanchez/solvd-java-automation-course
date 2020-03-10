package com.solvd.sandinosanchez.connectionpool.utils;

import com.solvd.sandinosanchez.connectionpool.models.BaseModel;
import com.solvd.sandinosanchez.connectionpool.models.User;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Models")
@XmlAccessorType(XmlAccessType.FIELD)
public class JaxBList<T> {
    @XmlElement(name = "Model")
    private List<T> list;

    public JaxBList(){}

    public JaxBList(List<T> list){
        this.list = list;
    }

    @XmlAnyElement(lax = true)
    public List<T> getList(){
        return list;
    }
}
