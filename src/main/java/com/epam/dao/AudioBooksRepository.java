package com.epam.dao;

import com.epam.models.AudioBooksAlbumModel;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Repository
public class AudioBooksRepository {

    private static final List<AudioBooksAlbumModel> AUDIO_BOOKS_ALBUM;

    static {
        AUDIO_BOOKS_ALBUM = Arrays.asList(
                new AudioBooksAlbumModel(1, "White Fang", "", "Jack London", "Adventure literature and animal literature classics", 0, LocalDateTime.now()),
                new AudioBooksAlbumModel(2, "I am a dragon", "", "Alexander Sapegin", "Science fiction novel Alexander Sapegina", 0, LocalDateTime.now()),
                new AudioBooksAlbumModel(3, "Ocean", "", "Diane Lilith", "\"Ocean\" - the third book of Diana Lilit, published in the publishing house \"AST\"", 0, LocalDateTime.now()),
                new AudioBooksAlbumModel(4, "Jack on the moon", "", "Tatyana Rusuberg", "His name is Zhenya, but for everyone here he is - Jack", 0, LocalDateTime.now())
        );
    }

    public List<AudioBooksAlbumModel> getAudioBooksAlbum() {

        return AUDIO_BOOKS_ALBUM;
    }
}
