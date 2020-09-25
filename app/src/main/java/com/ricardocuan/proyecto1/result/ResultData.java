package com.ricardocuan.proyecto1.result;

public class ResultData {

    // DECLARACIÓN DE VARIABLES
    private int Id;
    private String cost;
    private String title;
    private int quantity;

    // CONSTRUCTOR
    public ResultData(int id, int quantity, String title, String cost) {
        Id = id;
        this.cost = cost;
        this.title = title;
        this.quantity = quantity;
    }

    // GETTER
    public int getId()       { return Id;       }
    public String getCost()  { return cost;     }
    public String getTitle() { return title;    }
    public int getQuantity() { return quantity; }

    // SETTER
    public void setId(int id)             { Id = id;                  }
    public void setCost(String cost)      { this.cost = cost;         }
    public void setTitle(String title)    { this.title = title;       }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
