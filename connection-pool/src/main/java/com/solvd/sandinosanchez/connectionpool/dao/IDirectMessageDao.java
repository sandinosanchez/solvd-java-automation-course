package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.models.DirectMessage;
import com.solvd.sandinosanchez.connectionpool.models.User;

import java.sql.Date;
import java.util.List;

public interface IDirectMessageDao extends IQuery<DirectMessage> {

    DirectMessage getDirectMessageFrom(User user);

    List<DirectMessage> getDirectMessagesBetween(Date begin, Date end);

    DirectMessage getById(long id);

}
