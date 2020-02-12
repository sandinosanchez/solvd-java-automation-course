package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.model.DirectMessage;
import com.solvd.sandinosanchez.connectionpool.model.User;

import java.sql.Date;
import java.util.List;

public interface IDirectMessageDao extends IQuery<DirectMessage> {

    List<DirectMessage> getAllDirectMessagesFromUser(User user);

    DirectMessage getDirectMessageFrom(User user);

    DirectMessage getDirectMessagesBetween(Date begin, Date end);

    List<DirectMessage> getAllByUserId(long id);
}
