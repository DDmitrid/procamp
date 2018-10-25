package com.globallogic.procamp.lesson3.rest.resource;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "BookResource")
@JsonTypeInfo(
                use = JsonTypeInfo.Id.NAME,
                property = "type",
                visible = true)

@JsonSubTypes(value = {
                @JsonSubTypes.Type(value = EbookResource.class, name="EBOOK"),
                @JsonSubTypes.Type(value = AudioBookResource.class, name="AUDIO")
})
//@ApiModel(
//                value = "BookResource",
//                subTypes = {AudioBookResource.class, EbookResource.class},
//                discriminator = "type",
//                description = "parent class for book hierarchy"
//)

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BookResource {
    
    private String name;
    private String author;

    @JsonIgnore
    public abstract BookType getBookType();
}
