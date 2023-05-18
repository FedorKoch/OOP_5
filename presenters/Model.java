package presenters;

import models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    /**
     * Получение всех доступных столиков
     * 
     * @return столики
     */
    Collection<Table> loadTables();

    /**
     * Бронирование столика
     * 
     * @param reservationDate дата бронирования
     * @param tableNo         номер столика
     * @param name            имя клиента
     * @return номер брони
     */
    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     * Изменение бронирования столика
     * 
     * @param oldReservation  старый ID бронирования для удаления
     * @param reservationDate новая дата бронирования
     * @param tableNo         новый номер стола
     * @param name            имя клиента
     * @return новый номер брони
     */
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);

}