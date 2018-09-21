package net.digitalbd.studentdetails;

public class Student {
    public String name,id,details,dbId,contact;
    public Student(String name, String id, String details, String dbId, String contact) {

        this.name = name;
        this.id = id;
        this.details = details;
        this.dbId = dbId;
        this.contact = contact;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }



    public String getName() {

        return name;
    }

    public String getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public String getDbId() {
        return dbId;
    }

    public String getContact() {
        return contact;
    }
}
