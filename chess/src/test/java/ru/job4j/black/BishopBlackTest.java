package ru.job4j.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void whenPosition() {
        BishopBlack black = new BishopBlack(Cell.D2);
        Cell cell = black.position();
        assertThat(cell, is(Cell.D2));
    }

    @Test
    public void whenCopy() {
        Figure black = new BishopBlack(Cell.D2);
        Figure figure = black.copy(Cell.A1);
        assertThat(figure.equals(black), is(false));
    }

    @Test
    public void whenWay() {
        BishopBlack black = new BishopBlack(Cell.C1);
        Cell[] cell = black.way(Cell.C1, Cell.G5);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cell, is(expected));
    }
}
