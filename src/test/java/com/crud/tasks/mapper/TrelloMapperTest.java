package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.dto.TrelloBoardDto;
import com.crud.tasks.domain.dto.TrelloCardDto;
import com.crud.tasks.domain.dto.TrelloListDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {
    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardsTest() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "testList", true));
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto("1", "testBoard", trelloListDto));
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDto);
        //Then
        assertEquals(trelloBoardDto.get(0).getName(), trelloBoards.get(0).getName());
        assertEquals(trelloBoardDto.get(0).getId(), trelloBoards.get(0).getId());
        assertEquals(trelloBoardDto.get(0).getLists().size(), trelloBoards.get(0).getLists().size());
        assertEquals(trelloBoardDto.size(), trelloBoards.size());
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "testList1", true));
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("1", "testBoard1", trelloList));
        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoard);
        //Then
        assertEquals(trelloBoard.get(0).getName(), trelloBoardsDto.get(0).getName());
        assertEquals(trelloBoard.get(0).getId(), trelloBoardsDto.get(0).getId());
        assertEquals(trelloBoard.get(0).getLists().size(), trelloBoardsDto.get(0).getLists().size());
        assertEquals(trelloBoard.size(), trelloBoardsDto.size());
    }

    @Test
    public void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("2", "testList2", false));
        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDto);
        //Then
        assertEquals(trelloListDto.get(0).getName(), trelloList.get(0).getName());
        assertEquals(trelloListDto.get(0).getId(), trelloList.get(0).getId());
        assertEquals(trelloListDto.get(0).isClosed(), trelloList.get(0).isClosed());
        assertEquals(trelloListDto.size(), trelloList.size());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("3", "testList3", false));
        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloList);
        //Then
        assertEquals(trelloList.get(0).getName(), trelloListDto.get(0).getName());
        assertEquals(trelloList.get(0).getId(), trelloListDto.get(0).getId());
        assertEquals(trelloList.get(0).isClosed(), trelloListDto.get(0).isClosed());
        assertEquals(trelloList.size(), trelloListDto.size());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test4", "testCard", "04", "4");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test5", "testCard01", "05", "5");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals(trelloCardDto.getName(), trelloCard.getName());
        assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
        assertEquals(trelloCardDto.getPos(), trelloCard.getPos());
        assertEquals(trelloCardDto.getListId(), trelloCard.getListId());
    }
}
