package kr.co.woobi.imyeon.networkexam;

import kr.co.woobi.imyeon.networkexam.model.Users;

public class EventUserItem {

    Users users;

    public EventUserItem(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EventUserItem{");
        sb.append("users=").append(users);
        sb.append('}');
        return sb.toString();
    }
}
