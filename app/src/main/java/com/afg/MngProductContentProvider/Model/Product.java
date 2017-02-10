package com.afg.MngProductContentProvider.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

/**
 * Created by joselu on 11/01/17.
 */

public class Product implements Parcelable, Comparable<Product> {
    long ID;
    String name;
    String description;
    String brand;
    String dosage;
    Double price;
    String stock;
    byte[] image;
    int idCategory;

    public Product(long ID, String name, String description, String brand, String dosage, Double price, String stock, byte[] image, int idCategory) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.dosage = dosage;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.idCategory = idCategory;
    }



    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public String getDosage() {
        return dosage;
    }

    public Double getPrice() {
        return price;
    }

    public String getStock() {
        return stock;
    }

    public byte[] getImage() {
        return image;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getFormattedPrice(){
        return String.format("$%s", this.price);
    }

    public static final Comparator<Product> NAME_COMPARATOR = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };

    public Product() {

        this.ID = 0;
    }

    public Product(String name, String description, String brand, String dosage, Double price,
                   String stock, byte[] image, int idCategory) {

        this.name = name;
        this.description = description;
        this.brand = brand;
        this.dosage = dosage;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.idCategory = idCategory;
    }

    @Override
    public int compareTo(Product product) {
        if(this.getName().compareTo(product.getName()) == 0)
            return this.getBrand().compareTo(product.getBrand());
        else
            return this.getName().compareTo(product.getName());
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.ID);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.brand);
        dest.writeString(this.dosage);
        dest.writeValue(this.price);
        dest.writeString(this.stock);
        dest.writeByteArray(this.image);
        dest.writeInt(this.idCategory);
    }

    protected Product(Parcel in) {
        this.ID = in.readLong();
        this.name = in.readString();
        this.description = in.readString();
        this.brand = in.readString();
        this.dosage = in.readString();
        this.price = (Double) in.readValue(Double.class.getClassLoader());
        this.stock = in.readString();
        this.image = in.createByteArray();
        this.idCategory = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
