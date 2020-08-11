package com.crud.tasks.trello;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTest {
    @Mock
    TrelloValidator trelloValidator;

    @Test
    public void testValidateTrelloBoards() {
        //Given
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "name", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "test name", new ArrayList<>());
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);
        //When
        TrelloValidator trelloValidator = new TrelloValidator();
        List<TrelloBoard> filtredTrelloBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        assertEquals(2, filtredTrelloBoards.size());
    }

    @Test
    public void testValidateCard() {
        TrelloCard trelloCard1 = new TrelloCard("test", "desc", "top", "3");
        TrelloCard trelloCard2 = new TrelloCard("test name", "desc", "top", "6");

        trelloValidator.validateCard(trelloCard1);
        trelloValidator.validateCard(trelloCard2);

        verify(trelloValidator, times(1)).validateCard(trelloCard1);
        verify(trelloValidator, times(1)).validateCard(trelloCard2);
    }
}
