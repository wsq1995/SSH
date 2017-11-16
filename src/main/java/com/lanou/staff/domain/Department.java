package com.lanou.staff.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
public class Department {
    private String depID;
    private String depName;
    private Set<Post>posts = new HashSet<>();
    private Set<Staff>staffs = new HashSet<>();

    public Department() {
    }

    public Department(String depID, String depName) {
        this.depID = depID;
        this.depName = depName;
    }

    public Department(String depID) {
        this.depID = depID;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depID=" + depID +
                ", depName='" + depName + '\'' +
                '}';
    }
}
