package com.solvd.sandinosanchez.connectionpool.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "User")
@XmlType(propOrder = {"firstName", "lastName", "email", "password", "gender", "posts", "directMessages", "followers"})
public class User extends BaseModel {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private List<Post> posts;
    @XmlTransient
    private List<Follower> followers;
    @XmlTransient
    private List<DirectMessage> directMessages;
    @XmlTransient
    private String password;


    public User(){
        super();
        posts = new ArrayList<>();
        followers = new ArrayList<>();
        directMessages = new ArrayList<>();
    }

    public User(Long id, String firstName, String lastName, String email) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = new Gender();
        this.posts = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.directMessages = new ArrayList<>();
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
                ", posts=" + posts.toString() +
                '}';
    }
}
