package cf.dylan.board.service;

import cf.dylan.board.dto.BoardDTO;
import cf.dylan.board.dto.PageRequestDTO;
import cf.dylan.board.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        BoardDTO dto = BoardDTO.builder()
                .title("Test.")
                .content("Test...")
                .writerEmail("user55@aaa.com")  //현재 데이터베이스에 존재하는 회원 이메일
                .build();
        Long bno = boardService.register(dto);
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);
        for (BoardDTO boardDTO : result.getDtoList()) {
            System.out.println(boardDTO);
        }
    }

    @Test
    public void testGet() {
        Long bno = 100L;
        BoardDTO boardDTO = boardService.get(bno);
        System.out.println(boardDTO);
    }

    @Test
    public void testRemove() {
        Long bno = 1L;
        boardService.removeWithReplies(bno);
    }

    @Test
    public void testUpdate() {
        BoardDTO dto = BoardDTO.builder()
                .bno(101L)
                .title("Update Test.")
                .content("Update Test...")
                //.writerEmail("user55@aaa.com")  //현재 데이터베이스에 존재하는 회원 이메일
                .build();
        
        boardService.modify(dto);
    }

}
