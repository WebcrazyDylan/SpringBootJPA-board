package cf.dylan.board.repository;

import cf.dylan.board.entity.Board;
import cf.dylan.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Modifying
    @Query("delete from Reply r where r.board.bno =:bno ")  //Board 삭제시에 댓글들 삭제
    void deleteByBno(@Param("bno") Long bno);

    List<Reply> getRepliesByBoardOrderByRno(Board board);
}

