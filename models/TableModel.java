package models;

import presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        // throw new RuntimeException("Некорректный номер столика");
    }

    /**
     * TODO: Разработать самостоятельно
     * Поменять бронь столика
     * 
     * @param oldReservation  номер старого резерва (для снятия)
     * @param reservationDate дата резерва столика
     * @param tableNo         номер столика
     * @param name            Имя
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            for (Reservation reserv : table.getReservations()) {
                if (reserv.getId() == oldReservation) {
                    table.getReservations().remove(reserv);
                    break;
                }
            }
        }
        return reservationTable(reservationDate, tableNo, name);
    }

}