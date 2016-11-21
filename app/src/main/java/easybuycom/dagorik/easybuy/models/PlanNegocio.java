package easybuycom.dagorik.easybuy.models;

import android.widget.EditText;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Dagorik on 21/11/16.
 */

public class PlanNegocio extends RealmObject {

    @PrimaryKey
    private String id;

    private String NameProduct;
    private double total;
    private double iva;
    private int months;
    private double NumberPayments;


    public PlanNegocio(String id, String nameProduct, double total, double iva, int months, double numberPayments) {
        this.id = id;
        NameProduct = nameProduct;
        this.total = total;
        this.iva = iva;
        this.months = months;
        NumberPayments = numberPayments;
    }

    public PlanNegocio() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public double getNumberPayments() {
        return NumberPayments;
    }

    public void setNumberPayments(double numberPayments) {
        NumberPayments = numberPayments;
    }

    @Override
    public String toString() {
        return "PlanNegocio{" +
                "id='" + id + '\'' +
                ", NameProduct='" + NameProduct + '\'' +
                ", total=" + total +
                ", iva=" + iva +
                ", months=" + months +
                ", NumberPayments=" + NumberPayments +
                '}';
    }
}
