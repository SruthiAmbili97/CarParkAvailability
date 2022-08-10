package sg.edu.rp.c346.id21006564.carparkavailability;

import java.io.Serializable;

public class CarParkAvailability implements Serializable {
    private String carpark_number;
    private String update_datetime;
    private  String total_lots;
    private  String lot_type;
    private String lots_available;

    public CarParkAvailability(String carpark_number, String update_datetime, String total_lots, String lot_type, String lots_available) {
        this.carpark_number = carpark_number;
        this.update_datetime = update_datetime;
        this.total_lots = total_lots;
        this.lot_type = lot_type;
        this.lots_available = lots_available;
    }

    public String getCarpark_number() {
        return carpark_number;
    }

    public void setCarpark_number(String carpark_number) {
        this.carpark_number = carpark_number;
    }

    public String getUpdate_datetime() {
        return update_datetime;
    }

    public void setUpdate_datetime(String update_datetime) {
        this.update_datetime = update_datetime;
    }

    public String getTotal_lots() {
        return total_lots;
    }

    public void setTotal_lots(String total_lots) {
        this.total_lots = total_lots;
    }

    public String getLot_type() {
        return lot_type;
    }

    public void setLot_type(String lot_type) {
        this.lot_type = lot_type;
    }

    public String getLots_available() {
        return lots_available;
    }

    public void setLots_available(String lots_available) {
        this.lots_available = lots_available;
    }

    @Override
    public String toString() {
        return "CarParkAvailability" +'\n'+
                "carpark_number: " + carpark_number + '\n' +
                " update_datetime: '" + update_datetime + '\n' +
                " total_lots: '" + total_lots + '\n' +
                " lot_type: '" + lot_type + '\n' +
                " lots_available: '" + lots_available + '\n' ;
    }
}
