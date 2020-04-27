package ru.job4j.chess.firuges.black;

import javafx.css.Match;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static ru.job4j.chess.firuges.Cell.findBy;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
       if (!isDiagonal(source, dest)) {
           throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
          );
      }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
       int deltaX = dest.x < source.x ? -1 : 1;
       int deltaY = dest.y < source.y ? -1 : 1;
       for (int index = 0; index < size; index++) {
           steps[index] = source.findBy((source.x + (index + 1) * deltaX), (source.y + (index + 1) * deltaY));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.y - dest.y) == Math.abs(source.x - dest.x);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
