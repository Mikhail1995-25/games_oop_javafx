package ru.job4j.black;
import  org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static ru.job4j.chess.firuges.Cell.*;

public class LogicTest {

    @Test
    public void whenLogic() {
        Logic logic = new Logic();
        logic.add (new BishopBlack(Cell.C1));
        assertThat(logic.move(Cell.C1, Cell.G5), is(true));
    }

    @Test
    public void whenWay() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.C1, Cell.G5);
        } catch (IllegalStateException e) {
            assertThat(logic, is("Could not way by diagonal from %s to %s"));
        }
    }

    @Test
    public void whenWay2() {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.C1);
        logic.add(black);
        assertThat(logic.move(Cell.C1, Cell.E3), is(true));


    }
}
