package ru.hogwarts.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Value;

@Entity
public class Avatar {

        @Value("${path.to.avatars.folder}")
        private String avatarsDir;

        @Id
        @GeneratedValue
        private Long id;

    private String filePath; //В нем будем хранить путь до файла на вашем диске.
        private long fileSize; //Это поле содержит информацию о размере файла в байтах.
        private String mediaType; //Тип файла
        private byte[] data; //В этом поле хранится сама информация о файле
        @OneToOne
        private Student student;

    public Avatar() {
    }

    public Avatar(String avatarsDir, Long id, String filePath, long fileSize, String mediaType, byte[] data, Student student) {
        this.avatarsDir = avatarsDir;
        this.id = id;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.mediaType = mediaType;
        this.data = data;
        this.student = student;
    }
        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getAvatarsDir() {
            return avatarsDir;
        }

        public void setAvatarsDir(String avatarsDir) {
            this.avatarsDir = avatarsDir;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public long getFileSize() {
            return fileSize;
        }

        public void setFileSize(long fileSize) {
            this.fileSize = fileSize;
        }

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }

    }