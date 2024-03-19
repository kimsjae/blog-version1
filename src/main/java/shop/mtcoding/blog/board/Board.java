package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "board_tb")
@Data
public class Board {
    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 전략
    private int id;
    private String title;
    private String content;

    private int userId; // 테이블에 만들어 질때 user_id

    private LocalDateTime createdAt;
}
