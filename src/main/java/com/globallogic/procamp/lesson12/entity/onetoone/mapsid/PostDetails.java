package com.globallogic.procamp.lesson12.entity.onetoone.mapsid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "PostDetails")
@Table(name = "post_details")
@Getter
@Setter
public class PostDetails {

    @Id
    private Long id;

    @Column(name = "created_by")
    private String createdBy;
    
    @OneToOne
    @MapsId
    private Post post;

}
