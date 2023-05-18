package views;

import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    /**
     * Отобразить список столиков
     * 
     * @param tables список столиков
     */
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    /**
     * Отобразить результат бронирования
     * 
     * @param reservationNo номер брони
     */
    @Override
    public void showReservationStatus(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер брони: #%d\n", reservationNo);
        } else {
            System.out.println("Ошибка бронирования столика.");
        }
    }

    @Override
    public void showEditReservationStatus(int oldReservationNo, int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Бронь #%d отменена. Новый номер брони: #%d\n", oldReservationNo, reservationNo);
        } else {
            System.out.println("Ошибка бронирования столика.");
        }
    }

    /**
     * Установить наблюдателя
     * 
     * @param observer наблюдатель (презентер)
     */
    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования),
     * бронирование столика
     * 
     * @param orderDate дата бронирования
     * @param tableNo   номер столика
     * @param name      имя клиента
     */
    public void reservationTable(Date orderDate, int tableNo, String name) {
        observer.onReservationTable(orderDate, tableNo, name);
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование
     * столика
     * 
     * @param oldReservation  идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo         номер столика
     * @param name            Имя
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);

    }

}