package com.globallogic.procamp.lesson3.rest.resource;

import javax.sound.sampled.AudioInputStream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class AudioBookResource extends BookResource{
    
    private String audio;
    
    private final BookType type = BookType.AUDIO;

    @Builder
    public AudioBookResource(String audio, String name, String author) {
        super(name, author);
        this.audio = audio;
    }
    
    @Override public BookType getBookType() {
        return type;
    }
}
