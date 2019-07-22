package com.epam.dao;

import com.epam.models.AudioBookModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Repository
public class AudioBooksRepository {

    private static final List<AudioBookModel> AUDIO_BOOKS;

    static {
        AUDIO_BOOKS = Arrays.asList(AudioBookModel.builder()
                        .id(1)
                        .name("White Fang")
                        .description("Adventure literature and animal literature classics")
                        .artist("Jack London")
                        .rank(0)
                        .createDateTime(LocalDateTime.now())
                        .build(),
                AudioBookModel.builder()
                        .id(2)
                        .name("I am a dragon")
                        .description("Science fiction novel Alexander Sapegina")
                        .artist("Alexander Sapegin")
                        .rank(0)
                        .createDateTime(LocalDateTime.now())
                        .build(),
                AudioBookModel.builder()
                        .id(2)
                        .name("Ocean")
                        .description("\"Ocean\" - the third book of Diana Lilit, published in the publishing house \"AST\"")
                        .artist("Diane Lilith")
                        .rank(0)
                        .createDateTime(LocalDateTime.now())
                        .build(),
                AudioBookModel.builder()
                        .id(2)
                        .name("Jack on the moon")
                        .description("His name is Zhenya, but for everyone here he is - Jack")
                        .artist("Tatyana Rusuberg")
                        .rank(0)
                        .createDateTime(LocalDateTime.now())
                        .build());
    }

    public List<AudioBookModel> getAudioBooksAlbum() {

        return AUDIO_BOOKS;
    }
}
