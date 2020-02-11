package com.solvd.sandinosanchez.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.sandinosanchez.model.DirectMessage.initializeDirectMessage;
import static com.solvd.sandinosanchez.model.Follower.initializeFollower;
import static com.solvd.sandinosanchez.model.Post.initializePost;

public class User extends BaseModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;
    private List<Post> posts;
    private List<Follower> followers;
    private List<DirectMessage> directMessages;


    public User(){
        super();
        posts = new ArrayList<>();
        followers = new ArrayList<>();
        directMessages = new ArrayList<>();
    }

    public User(Long id, String firstName, String lastName, String email, Gender gender) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.posts = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.directMessages = new ArrayList<>();
    }

    public static User initializeUser(ResultSet rs) throws SQLException {
        return new User(rs.getLong("id"), rs.getString("first_name"),
                rs.getString("last_name"), rs.getString("email"),
                new Gender(rs.getLong("gender_id"), rs.getString("name")));
    }

    public static User initializeUser(ResultSet rs, String idFieldName) throws SQLException {
        return new User(rs.getLong(idFieldName),rs.getString("first_name"),
                rs.getString("last_name"), rs.getString("email"),
                new Gender(rs.getString("name")));
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void addDirectMessage(DirectMessage dm) {
        this.directMessages.add(dm);
    }

    public void addFollower(Follower follower) {
        this.followers.add(follower);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    public List<DirectMessage> getDirectMessages() {
        return directMessages;
    }

    public void setDirectMessages(List<DirectMessage> directMessages) {
        this.directMessages = directMessages;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", posts=" + posts +
                ", followers=" + followers +
                ", directMessages=" + directMessages +
                ", id=" + id +
                '}';
    }
}
