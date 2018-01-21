package main.com.em.domain;

/**
 * Created by Admiral on 2018/1/20.
 */
//Reservation的扩展类
public class ReservationCustom extends Reservation {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
