package presenters;

import models.Table;

import java.util.Collection;

public interface View {

    /**
     * Отобразить список всех столиков
     * 
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    void showReservationStatus(int reservationNo);

    void showEditReservationStatus(int oldReservationNo, int reservationNo);

    /**
     * Установить нового наблюдателя
     * 
     * @param observer наблюдатель (презентер)
     */
    void setObserver(ViewObserver observer);

}