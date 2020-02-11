package com.solvd.sandinosanchez.dao.interfaces;

import com.solvd.sandinosanchez.model.DirectMessage;
import com.solvd.sandinosanchez.model.User;

import java.sql.Date;
import java.util.List;

public interface IDirectMessageDao extends IQuery<DirectMessage> {

    List<DirectMessage> getAllDirectMessagesFromUser(User user);

    DirectMessage getDirectMessageFrom(User user);

    DirectMessage getDirectMessagesBetween(Date begin, Date end);
}
