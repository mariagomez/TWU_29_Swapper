package com.thoughtworks.twu.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Offer")
public class Offer implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Category")
    private String category;

    @Column(name = "Owner")
    private String owner;

    @Column(name = "CreationTime")
    private Date creationTime;

    @Column(name = "Hidden", columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean hidden;

    public Offer(){

    }

    public Offer(String title, String description, String category, String owner, Date creationTime, boolean hidden) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.owner = owner;
        this.creationTime = creationTime;
        this.hidden = hidden;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer offer = (Offer) o;
        String timeString = creationTime.toString();

        if (category != null ? !category.equals(offer.category) : offer.category != null) return false;
        if (timeString != null ? !timeString.equals(offer.creationTime.toString()) : offer.creationTime.toString() != null) return false;
        if (description != null ? !description.equals(offer.description) : offer.description != null) return false;
        if (id != null ? !id.equals(offer.id) : offer.id != null) return false;
        if (owner != null ? !owner.equals(offer.owner) : offer.owner != null) return false;
        if (title != null ? !title.equals(offer.title) : offer.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", owner='" + owner + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
