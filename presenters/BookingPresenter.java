package presenters;

import models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;
    private Collection<Table> tables;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Загрузить список всех столиков
     */
    public void loadTables() {
        if (tables == null) {
            tables = model.loadTables();
        }
    }

    /**
     * Отобразить список столиков
     */
    public void updateView() {
        view.showTables(tables);
    }

    /**
     * Отобразить результат бронирования столика
     * 
     * @param reservationNo номер брони
     */
    private void updateReservationStatusView(int reservationNo) {
        view.showReservationStatus(reservationNo);
    }

    /**
     * Отобразить результат изменения брони столика
     * 
     * @param reservationNo номер брони
     */
    private void updateEditReservationStatusView(int oldReservationNo, int reservationNo) {
        view.showEditReservationStatus(oldReservationNo, reservationNo);
    }

    /**
     * Получили уведомление о попытке бронирования столика
     * 
     * @param orderDate дата бронирования
     * @param tableNo   номер столика
     * @param name      имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationNo = model.reservationTable(orderDate, tableNo, name);
        updateReservationStatusView(reservationNo);
    }

    /**
     * Получили уведомление о попытке изменения брони столика
     * 
     * @param oldReservation ID записи о бронировании для отмены
     * @param orderDate      дата бронирования
     * @param tableNo        номер столика
     * @param name           имя клиента
     */
    @Override
    public void onChangeReservationTable(int oldReservation, Date orderDate, int tableNo, String name) {
        int reservationNo = model.changeReservationTable(oldReservation, orderDate, tableNo, name);
        updateEditReservationStatusView(oldReservation, reservationNo);
    }
}